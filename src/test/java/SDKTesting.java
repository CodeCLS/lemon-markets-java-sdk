import Account.Account;
import Account.AccountRepository;
import Order.OrderRepository;
import Order.OrderTypes.FutureOrder;
import Order.OrderTypes.PlacedOrder;
import Order.Side;
import Positions.Position;
import Positions.PositionRepository;
import Quotes.Quote;
import Quotes.QuoteApiConnection;
import Quotes.QuoteRepository;
import RealtimeInstruments.RealtimeRepo;
import Stock.Stock;
import Stock.StockRepository;
import Trading.TradingApplication;
import Trading.TradingEnvironment;
import Venue.Venue;
import models.ContentPackage;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;

public class SDKTesting {
    public static void main(String args[]) {
        initTrading();
        //getStockViaSearch();
        //getPositions();
        //getAccount();
        //getOrders();
        new QuoteRepository().postGetRealTimeQuotes(null, new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                System.out.println("RealTime: " + ((Quote) contentPackage.getValue()).getAskPrice());

            }
        });


    }

    private static void getOrders() {
        new OrderRepository().getOrders(new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null){
                    System.out.println("Orders: " + ((ArrayList<PlacedOrder>)contentPackage.getValue()).get(0).getIsin());
                }
                else{
                    System.out.println(contentPackage.getException().getMessage());
                }
            }
        });
    }

    private static void getPositions() {
        new PositionRepository().getPositions(new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null){
                    if ( ((ArrayList<Position>)contentPackage.getValue()).size() != 0) {
                        System.out.println("Positions: " + ((ArrayList<Position>) contentPackage.getValue()).get(0).getQuantity());
                    }
                    else
                        System.out.println("Positions: None ");

                }
                else
                    System.out.println("Error: " + contentPackage.getException().getMessage());

            }
        });
    }

    private static void getAccount() {
        new AccountRepository().getAccount(new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null){
                    System.out.println("Account: " + ((Account) contentPackage.getValue()).getAccountId());

                }

                else
                    System.err.println("ErrorGetAccount: " + contentPackage.getException().getMessage());

            }
        });
    }

    private static void getStockViaSearch() {
        new StockRepository().getStockViaSearch("Coinbase", new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null) {
                    //CREATE A FUTURE ORDER

                    //PLACE ORDER
                    placeOrder(contentPackage);


                }
                else
                    System.out.println("Error: " + contentPackage.getException().getMessage());
            }
        });
    }

    private static void placeOrder(ContentPackage contentPackage) {
        FutureOrder futureOrder = new FutureOrder.Builder()
                .setIsin(((Stock)contentPackage.getValue()).getIsin())
                .setAmountShares(100)
                .setExpiresAt(System.currentTimeMillis() + 10000000)
                .setSide(Side.BUY)
                .setVenue(Venue.ofMic("ALLDAY"))
                .create();
        new OrderRepository().placeOrder(futureOrder, new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null) {
                    //ACTIVATE THE PRIOR ORDER
                    activateOrder(contentPackage);
                    System.out.println("Success placing order");

                }
                else{
                    System.out.println("Failure placing order" + contentPackage.getException().getMessage());

                }

            }
        });
    }

    private static void activateOrder(ContentPackage contentPackage) {
        new OrderRepository().activateOrder(((PlacedOrder) contentPackage.getValue()).getId(), new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null) {
                    System.out.println("Activated Order");
                }
                else{
                    System.out.println("Failed to activate Order");

                }

            }
        });
    }

    private static void initTrading() {
        TradingApplication tradingApplication = new TradingApplication.Builder()
                .setEnvironment(TradingEnvironment.PAPER)
                .setAccountId("ACCOUNT")
                .setToken("TOKEN");

    }

}
