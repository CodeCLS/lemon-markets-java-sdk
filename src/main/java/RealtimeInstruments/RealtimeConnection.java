package RealtimeInstruments;

import Exceptions.RealTimeNotConnected;
import Quotes.Quote;
import Quotes.QuoteConverter;
import com.google.gson.JsonObject;
import io.ably.lib.realtime.AblyRealtime;
import io.ably.lib.realtime.Channel;
import io.ably.lib.realtime.ConnectionState;
import io.ably.lib.realtime.ConnectionStateListener;
import io.ably.lib.types.AblyException;
import io.ably.lib.types.Message;
import models.ContentPackage;
import org.json.JSONObject;

import java.util.ArrayList;

public class RealtimeConnection {
    private AblyRealtime ably = null;
    private final String id;
    private Channel channel;
    private boolean isConnected = false;

    public RealtimeConnection(String id, ArrayList<Runnable> actionsToDo) {
        this.id = id;
        try {
            ably = new AblyRealtime("_aarfg.h6_0HQ:huZQgfP8GXpBlX3G");
            startListener(actionsToDo);

        } catch (AblyException e) {
            e.printStackTrace();
        }

    }

    private void startListener(ArrayList<Runnable> actionsToDo) {
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

    public void subscribeToAllChannels(ContentPackage.ApiAsyncReturn apiAsyncReturn) throws AblyException, RealTimeNotConnected {
        if (!isConnected)
            throw new RealTimeNotConnected(RealTimeNotConnected.message);
        channel = ably.channels.get(id);
        channel.subscribe(new Channel.MessageListener() {
            @Override
            public void onMessage(Message message) {
                notifyEventOccured(message, apiAsyncReturn);


            }
        });
    }
    public void subscribeToEvent(String[] events, ContentPackage.ApiAsyncReturn apiAsyncReturn) throws AblyException, RealTimeNotConnected {
        if (!isConnected)
            throw new RealTimeNotConnected(RealTimeNotConnected.message);
        channel = ably.channels.get(id);
        System.out.println("Subscribe to event " + channel);

        channel.subscribe(events,new Channel.MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("Certain Event: " + message.toString());
                notifyEventOccured(message, apiAsyncReturn);

            }
        });
    }

    private void notifyEventOccured(Message message, ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        ContentPackage contentPackage = new ContentPackage();
        Quote quote = new QuoteConverter().convertJSON(((JsonObject) message.data).toString());
        contentPackage.setValue(quote);
        apiAsyncReturn.getPackage(contentPackage);
    }
}
