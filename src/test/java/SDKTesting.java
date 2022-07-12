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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SDKTesting {

    public static void main(String args[]) {
        initTrading();
        //getStockViaSearch();
        //getPositions();
        //getAccount();
        //getOrders();


        //metaScenario();
        twitterScenario();
        //commerzScenario();


    }
    private static void commerzScenario() {
        new QuoteRepository().postGetRealTimeQuotes(null,new ContentPackage.ApiAsyncReturn() {
            Quote lastQuote = null;
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (System.currentTimeMillis() % 9 != 0){
                    return;
                }


                Quote quote = ((Quote) contentPackage.getValue());
                if (!quote.getIsin().equals("DE000CBK1001")){
                    return;
                }
                System.out.println("Commerz");
                if (lastQuote == null) {
                    lastQuote = quote;

                    return;
                }
                System.out.println(System.currentTimeMillis() +"Difference Volume: " + (quote.getAskVolume() - lastQuote.getBidVolume()) );

                if (quote.getAskVolume() > lastQuote.getBidVolume()){
                    System.err.println("BUY");
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(quote.getIsin())
                            .setAmountShares(10)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.BUY)
                            .setVenue(Venue.ofMic("XMUN"))
                            .create();
                    placeOrder(futureOrder);
                }
                else if(quote.getAskVolume() < lastQuote.getBidVolume()){
                    System.err.println("SELL");

                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(quote.getIsin())
                            .setAmountShares(10)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.SELL)
                            .setVenue(Venue.ofMic("XMUN"))
                            .create();
                    placeOrder(futureOrder);
                }


                System.out.println("RealTime1: " + ((Quote) contentPackage.getValue()).getAskPrice());

            }
        });
    }
    private static void twitterScenario() {
        new QuoteRepository().postGetRealTimeQuotes(null,new ContentPackage.ApiAsyncReturn() {
            Quote lastQuote = null;
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (System.currentTimeMillis() % 9 != 0){
                    return;
                }

                Quote quote = ((Quote) contentPackage.getValue());
                if (!quote.getIsin().equals("US90184L1026")){
                    return;
                }
                System.out.println("Twitter");
                if (lastQuote == null) {
                    lastQuote = quote;

                    return;
                }
                System.out.println(System.currentTimeMillis() +"Difference Volume: " + (quote.getAskVolume() - lastQuote.getBidVolume()) );

                if (quote.getAskVolume() > lastQuote.getBidVolume()){
                    System.err.println("BUY");
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(quote.getIsin())
                            .setAmountShares(10)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.BUY)
                            .setVenue(Venue.ofMic("XMUN"))
                            .create();
                    placeOrder(futureOrder);
                }
                else if(quote.getAskVolume() < lastQuote.getBidVolume()){
                    System.err.println("SELL");
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(quote.getIsin())
                            .setAmountShares(10)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.SELL)
                            .setVenue(Venue.ofMic("XMUN"))
                            .create();
                    placeOrder(futureOrder);
                }


                System.out.println("RealTime1: " + ((Quote) contentPackage.getValue()).getAskPrice());

            }
        });
    }

    private static void metaScenario() {
        new QuoteRepository().postGetRealTimeQuotes(null,new ContentPackage.ApiAsyncReturn() {
            Quote lastQuote = null;
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (System.currentTimeMillis() % 9 != 0){
                    return;
                }

                Quote quote = ((Quote) contentPackage.getValue());
                if (!quote.getIsin().equals("US30303M1027")){
                    return;
                }
                System.out.println("meta");

                if (lastQuote == null) {
                    lastQuote = quote;

                    return;
                }
                System.out.println(System.currentTimeMillis() +"Difference Volume: " + (quote.getAskVolume() - lastQuote.getBidVolume()) );

                if (quote.getAskVolume() > lastQuote.getBidVolume()){
                    System.err.println("BUY");
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(quote.getIsin())
                            .setAmountShares(10)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.BUY)
                            .setVenue(Venue.ofMic("XMUN"))
                            .create();
                    placeOrder(futureOrder);
                }
                else if(quote.getAskVolume() < lastQuote.getBidVolume()){
                    System.err.println("SELL");
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(quote.getIsin())
                            .setAmountShares(10)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.SELL)
                            .setVenue(Venue.ofMic("XMUN"))
                            .create();
                    placeOrder(futureOrder);
                }


                System.out.println("RealTime1: " + ((Quote) contentPackage.getValue()).getAskPrice());

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
    }public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }

    private static void getStockViaSearch() {
        new StockRepository().getStockViaSearch("Coinbase", new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null) {
                    //CREATE A FUTURE ORDER

                    //PLACE ORDER
                    //placeOrder(contentPackage);


                }
                else
                    System.out.println("Error: " + contentPackage.getException().getMessage());
            }
        });
    }

    private static void placeOrder(FutureOrder futureOrder) {
        new OrderRepository().placeOrder(futureOrder, new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                printBalance();
                if (contentPackage.getValue() != null) {
                    //ACTIVATE THE PRIOR ORDER
                    activateOrder(contentPackage);
                    System.out.println("Success placing order");

                }
                else{
                    if (contentPackage.getException() != null)
                        System.err.println("Failure placing order" + contentPackage.getException().getMessage());

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
                    printBalance();
                }
                else{
                    System.out.println("Failed to activate Order");

                }

            }
        });
    }

    private static void printBalance() {
        new PositionRepository().getPositions(new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null){
                    ArrayList<Position> positions = ((ArrayList<Position>) contentPackage.getValue());
                    long sum = 0;
                    for (Position position: positions){
                        sum+=position.getBuyPriceAverage()*position.getQuantity();
                    }
                    System.err.println("SUM_STOCK: " +sum);
                }
            }
        });
    }

    private static void initTrading() {
        TradingApplication tradingApplication = new TradingApplication.Builder()
                .setEnvironment(TradingEnvironment.PAPER)
                .setAccountId("acc_qyGJVBBffhzS3HZw0t2kPQPYHwhdyPngT6")
                .setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJsZW1vbi5tYXJrZXRzIiwiaXNzIjoibGVtb24ubWFya2V0cyIsInN1YiI6InVzcl9xeUdTUVZWZmZMNEZER1BRTHdEMHluRFB4Y1BOSzhQcFdiIiwiZXhwIjoxNjgxNDc0NTg1LCJpYXQiOjE2NDk5Mzg1ODUsImp0aSI6ImFwa19xeUdTUVZWZ2cxRFJuek5rc0RCdHFyUUs3SHE3Sld4TU1RIiwibW9kZSI6InBhcGVyIn0.DzNvc4tIojZCeMjBweaxncPx0cCPRkOFpWxJs0CXKZE");

    }

}