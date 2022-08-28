package Stock;

import Trading.TradingApplication;
import models.ContentPackage;

public class StockRepository {
    private StockApiConnection connection;
    public StockRepository() {
        if (TradingApplication.instance == null){
            System.err.println("Please instantiate the TradingApplication before calling this or any other class.");
            return;
        }
        connection = new StockApiConnection();
    }
    public void getStockViaSearch(String searchQueryValue, ContentPackage.ApiAsyncReturn stockApiAsyncReturn){
        try {
            connection.getStockViaSearch(searchQueryValue,stockApiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            stockApiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }
    public void getStockViaWkn(String searchQueryValue, ContentPackage.ApiAsyncReturn stockApiAsyncReturn){
        try {
            connection.getStockViaWkn(searchQueryValue,stockApiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            stockApiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }
    public void getStockViaIsin(String searchQueryValue, ContentPackage.ApiAsyncReturn stockApiAsyncReturn){
        try {
            connection.getStockViaIsin(searchQueryValue,stockApiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            stockApiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }

}
