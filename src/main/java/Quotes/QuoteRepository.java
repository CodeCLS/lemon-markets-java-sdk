package Quotes;

import RealtimeInstruments.RealtimeRepo;
import Stock.StockApiConnection;
import Trading.TradingApplication;
import models.ContentPackage;

import java.util.ArrayList;

public class QuoteRepository {
    private RealtimeRepo realtimeRepo = null;
    private QuoteApiConnection connection;
    private ArrayList<Runnable> actionsToDo = new ArrayList<>();

    public QuoteRepository() {
        if (TradingApplication.instance == null){
            System.err.println("Please instantiate the TradingApplication before calling this or any other class.");
            return;
        }
        realtimeRepo = new RealtimeRepo(TradingApplication.account,actionsToDo);
        connection = new QuoteApiConnection();
    }
    public void getRealTimeQuotes(String[] optionalEvents, ContentPackage.ApiAsyncReturn stockApiAsyncReturn){
        try {
            realtimeRepo.getRealTimeEvents(optionalEvents,stockApiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            stockApiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }
    public void getLatestQuotes(String isin, String mic,ContentPackage.ApiAsyncReturn apiAsyncReturn){
        try {
            connection.getLatestQuotes(isin,mic,apiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            apiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }

    public void postGetRealTimeQuotes(String[] optionalEvents, ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        actionsToDo.add(new Runnable() {
            @Override
            public void run() {
                getRealTimeQuotes(optionalEvents,apiAsyncReturn);
            }
        });
    }

}
