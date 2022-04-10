package Stock;

import Exceptions.ApplicationNotInstantiated;
import Exceptions.StockBodyEmptyException;
import Exceptions.UnsuccessfulException;
import Trading.TradingApplication;
import Trading.TradingEnvironment;
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

}
