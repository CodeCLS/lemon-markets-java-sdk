package Positions;

import Order.OrderApiConnection;
import Trading.TradingApplication;
import Trading.TradingEnvironment;
import models.ContentPackage;

public class PositionRepository {
    private PositionApiConnection connection;
    public PositionRepository() {
        if (TradingApplication.instance == null){
            System.err.println("Please instantiate the TradingApplication before calling this or any other class.");
            return;
        }
        connection = new PositionApiConnection();
    }



    public void getPositions(ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        try {
            connection.getPositions(apiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            apiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }
}
