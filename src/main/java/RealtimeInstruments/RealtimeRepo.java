package RealtimeInstruments;
import Exceptions.UnsuccessfulException;
import Trading.TradingApplication;
import models.ContentPackage;
import java.util.ArrayList;
public class RealtimeRepo {
    private final RealtimeConnection realtimeConnection;
    public RealtimeRepo(String id, ArrayList<Runnable> actionsToDo) {
        realtimeConnection = new RealtimeConnection(id,actionsToDo);
    }
    public void getRealTimeEvents(String[] optionalEvents, ContentPackage.ApiAsyncReturn stockApiAsyncReturn) {
        try {
            System.out.println("Specific channels");
            realtimeConnection.subscribeToEvent(optionalEvents,stockApiAsyncReturn);
        }
        catch (Exception exception){
            exception.printStackTrace();
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(exception);
            stockApiAsyncReturn.getPackage(contentPackage);
        }
    }
    public static ContentPackage getRealTimeAuthToken() throws UnsuccessfulException {
        return new RealtimeConnection().getAuthToken(TradingApplication.instance.token);
    }
    public void notifyChangeActions() {
        realtimeConnection.notifyChangeActions();
    }
}