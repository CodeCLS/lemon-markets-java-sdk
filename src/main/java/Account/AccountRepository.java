package Account;

import Order.OrderApiConnection;
import Order.OrderTypes.FutureOrder;
import Trading.TradingApplication;
import models.ContentPackage;

public class AccountRepository {

    private AccountApiConnection connection;
    public AccountRepository() {
        if (TradingApplication.instance == null){
            System.err.println("Please instantiate the TradingApplication before calling this or any other class.");
            return;
        }
        TradingApplication tradingApplication = TradingApplication.instance;

        connection = new AccountApiConnection();
    }
    public void getAccount(ContentPackage.ApiAsyncReturn stockApiAsyncReturn){
        try {
            connection.getAccount(stockApiAsyncReturn);
        } catch (Exception e) {
            ContentPackage contentPackage = new ContentPackage();
            contentPackage.setException(e);
            stockApiAsyncReturn.getPackage(contentPackage);
            e.printStackTrace();
        }
    }
}
