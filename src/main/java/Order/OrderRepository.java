package Order;

import Exceptions.UnsuccessfulException;
import Order.OrderTypes.FutureOrder;
import Order.OrderTypes.PlacedOrder;
import Stock.StockApiConnection;
import Trading.TradingApplication;
import Trading.TradingEnvironment;
import models.ContentPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

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
            //getOrders(new ContentPackage.ApiAsyncReturn() {
            //    @Override
            //    public void getPackage(ContentPackage contentPackage) {
            //        ArrayList<PlacedOrder> placedOrders = ((ArrayList<PlacedOrder>) contentPackage.getValue());
            //        PlacedOrder placedOrderFound =placedOrders.stream().filter(placedOrder -> placedOrder.getIsin().equals(futureOrder.getIsin())
            //                && placedOrder.getQuantity() == (futureOrder.getAmountShares())).findAny().orElse(null);
//
            //        if (placedOrderFound == null){
            //            connection.placeOrder(futureOrder,stockApiAsyncReturn);
            //            ContentPackage contentPackage1 = new ContentPackage();
            //            contentPackage.setException(new UnsuccessfulException());
            //            stockApiAsyncReturn.getPackage(contentPackage1);
            //        }
            //        else{
            //            ContentPackage contentPackage1 = new ContentPackage();
            //            contentPackage.setValue(placedOrderFound);
            //            stockApiAsyncReturn.getPackage(contentPackage1);
//
            //        }
            //    }
            //});

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
    public void getOrders(ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        try {
            connection.getOrders(apiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            apiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }

}
