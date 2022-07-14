package RealtimeInstruments;

import Exceptions.ApplicationNotInstantiated;
import Exceptions.BodyEmptyException;
import Exceptions.RealTimeNotConnected;
import Exceptions.UnsuccessfulException;
import Quotes.Quote;
import Quotes.QuoteConverter;
import Trading.ApiServiceRealtime;
import Trading.TradingApplication;
import com.google.gson.JsonObject;
import io.ably.lib.realtime.*;
import io.ably.lib.types.*;
import models.ContentPackage;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

public class RealtimeConnection {
    private String token;
    private ApiServiceRealtime service;
    private ArrayList<Runnable> actions = new ArrayList<>();
    private AblyRealtime ably = null;
    private String id;
    private Channel channel;
    private Channel allChannel;

    private boolean isConnected = false;
    private ContentPackage.ApiAsyncReturn realTimeListener;
    private Channel subscriptionChannel;

    public RealtimeConnection(String id, ArrayList<Runnable> actionsToDo) {
        ClientOptions options = new ClientOptions();
        options.token = TradingApplication.instance.realtimeAuthToken;
        options.transportParams = new Param[]{new Param("remainPresentFor", "1000")};
        if (fetchTradingEnv()) return;
        this.actions = actionsToDo;
        this.id = id;
        try {
            ably = new AblyRealtime(options);
            System.out.println("Subscribe to event " + channel);

            channel = ably.channels.get(id);
            try {
                channel.subscribe(new Channel.MessageListener() {
                    @Override
                    public void onMessage(Message message) {
                        if (realTimeListener == null)
                            return;
                        System.out.println("Certain Event: " + message.toString());
                        notifyEventOccurred(message, realTimeListener);
                    }
                });
                startListener(actionsToDo);

            } catch (AblyException exception) {
                exception.printStackTrace();
                notifyErrorOccurred(exception,realTimeListener);

            }



        } catch (AblyException e) {
            e.printStackTrace();
        }


    }

    private boolean fetchTradingEnv() {
        if (TradingApplication.instance == null){
            System.err.println(new ApplicationNotInstantiated().getMessage());
            return true;
        }
        service = TradingApplication.instance.serviceRealtime;
        token =  TradingApplication.instance.token;
        return false;
    }

    public RealtimeConnection() {
        fetchTradingEnv();

    }

    private void startListener(ArrayList<Runnable> actionsToDo) {
        subscriptionChannel =ably.channels.get(id + ".subscriptions");
        subscriptionChannel.on(new ChannelStateListener() {
            @Override
            public void onChannelStateChanged(ChannelStateChange stateChange) {

            }
        });
        ably.connection.on(new ConnectionStateListener() {
            @Override
            public void onConnectionStateChanged(ConnectionStateChange state) {
                isConnected = state.current == ConnectionState.connected;
                System.out.println("New state is " + state.current.name());
                switch (state.current) {
                    case connected: {
                        for(Runnable runnable: actionsToDo){
                            runnable.run();
                        }
                        // Successful connection
                        break;
                    }
                    case failed: {
                        // Failed connection
                        break;
                    }
                }
            }
        });
    }
    public void subscribeToEvent(String[] events,ContentPackage.ApiAsyncReturn apiAsyncReturn) throws AblyException, RealTimeNotConnected {
        realTimeListener = apiAsyncReturn;
        if (!isConnected)
            throw new RealTimeNotConnected(RealTimeNotConnected.message);
        subscriptionChannel.publish("isins", events, new CompletionListener() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(ErrorInfo reason) {
                System.err.println("ERROR ABLY"+reason.message);

            }
        });
    }

    private void notifyErrorOccurred(Exception exception, ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        ContentPackage contentPackage = new ContentPackage();
        contentPackage.setException(exception);
        apiAsyncReturn.getPackage(contentPackage);
    }

    private void notifyEventOccurred(Message message, ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        ContentPackage contentPackage = new ContentPackage();
        Quote quote = new QuoteConverter().convertJSON(((JsonObject) message.data).toString());
        contentPackage.setValue(quote);
        apiAsyncReturn.getPackage(contentPackage);
    }

    public void notifyChangeActions() {
        if (isConnected){
            for(Runnable runnable: actions){
                runnable.run();
            }
        }

    }

    public ContentPackage getAuthToken(String token) throws UnsuccessfulException {
        ContentPackage contentPackage = new ContentPackage();
        try {
            Response<ResponseBody> response =service.requestRealTimeAuthToken(token).execute();
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    try {
                        String val = response.body().string();
                        System.out.println("val: " + val);
                        contentPackage.setValue(new JSONObject(val).get("token").toString());
                        TradingApplication.instance.setRealtimeAblyUid(new JSONObject(val).get("user_id").toString());
                        System.out.println("AblyUID: " + TradingApplication.instance.getAblyUid());
                    } catch (IOException e) {
                        contentPackage.setException(e);
                        e.printStackTrace();
                    }
                } else {
                    contentPackage.setException(new BodyEmptyException());

                }
            } else {
                contentPackage.setException(new UnsuccessfulException());
            }

        } catch (IOException e) {
            e.printStackTrace();
            contentPackage.setException(e);
        }
        if (((String)contentPackage.getValue()) == null){
            System.err.println("IMPORTANT: Auth Token is null");
            throw new UnsuccessfulException();

        }

        return contentPackage;
    }
}
