package RealtimeInstruments;

import io.ably.lib.types.AblyException;
import models.ContentPackage;

import java.util.ArrayList;

public class RealtimeRepo {
    private final RealtimeConnection realtimeConnection;

    public RealtimeRepo(String id, ArrayList<Runnable> actionsToDo) {
        realtimeConnection = new RealtimeConnection(id,actionsToDo);
    }

    public void getRealTimeEvents(String[] optionalEvents, ContentPackage.ApiAsyncReturn stockApiAsyncReturn) {
        try {
            if (optionalEvents == null || optionalEvents.length == 0) {
                realtimeConnection.subscribeToAllChannels(stockApiAsyncReturn);
            } else {
                System.out.println("Specific channels");
                realtimeConnection.subscribeToEvent(optionalEvents, stockApiAsyncReturn);
            }
        }
        catch (Exception exception){
            exception.printStackTrace();
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(exception);
            stockApiAsyncReturn.getPackage(contentPackage);
        }

    }

    public void notifyChangeActions() {
        realtimeConnection.notifyChangeActions();
    }
}
