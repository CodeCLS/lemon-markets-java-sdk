package RealtimeInstruments;

import io.ably.lib.realtime.AblyRealtime;
import io.ably.lib.realtime.Channel;
import io.ably.lib.realtime.ConnectionStateListener;
import io.ably.lib.types.AblyException;
import io.ably.lib.types.Message;
import io.ably.lib.types.PaginatedResult;

public class RealtimeConnection {
    private AblyRealtime ably = null;
    private final String id;
    private Channel channel;

    public RealtimeConnection(String id) {
        this.id = id;
        try {
            ably = new AblyRealtime("_aarfg.h6_0HQ:huZQgfP8GXpBlX3G");
            startListener();

        } catch (AblyException e) {
            e.printStackTrace();
        }

    }

    private void startListener() {
        ably.connection.on(new ConnectionStateListener() {
            @Override
            public void onConnectionStateChanged(ConnectionStateChange state) {
                System.out.println("New state is " + state.current.name());
                switch (state.current) {
                    case connected: {
                        try {
                            subscribeToAllChannels();
                            //subscribeToEvent(new String[]{"DE000A3GMKD7"});
                        } catch (AblyException e) {
                            e.printStackTrace();
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

    private void subscribeToAllChannels() throws AblyException {
        channel = ably.channels.get(id);
        channel.subscribe(new Channel.MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("All Events: " + message.toString());

            }
        });
    }
    private void subscribeToEvent(String[] events) throws AblyException {
        channel = ably.channels.get(id);
        System.out.println("Subscribe to event " + channel);

        channel.subscribe(events,new Channel.MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("Certain Event: " + message.toString());

            }
        });
    }
}
