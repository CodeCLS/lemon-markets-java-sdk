package Order;

import Order.OrderTypes.FutureOrder;
import Stock.StockApiConnection;
import Trading.TradingApplication;
import Trading.TradingEnvironment;
import models.ContentPackage;

public class OrderRepository {
    private OrderApiConnection connection;
    public OrderRepository() {
        if (TradingApplication.instance == null){
            System.err.println("Please instantiate the TradingApplication before calling this or any other class.");
            return;
        }
        TradingApplication tradingApplication = TradingApplication.instance;

        connection = new OrderApiConnection();
    }
    public void placeOrder(FutureOrder futureOrder, ContentPackage.ApiAsyncReturn stockApiAsyncReturn){
        try {
            connection.placeOrder(futureOrder,stockApiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            stockApiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }

    public void activateOrder(String id, ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        try {
            connection.activateOrder(id,apiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            apiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }

}
