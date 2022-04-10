import Order.OrderRepository;
import Order.OrderTypes.FutureOrder;
import Order.OrderTypes.PlacedOrder;
import Order.Side;
import Positions.Position;
import Positions.PositionRepository;
import Stock.Stock;
import Stock.StockRepository;
import Trading.TradingApplication;
import Trading.TradingEnvironment;
import models.ContentPackage;

import java.util.ArrayList;

public class SDKTesting {
    public static void main(String args[]) {
        TradingApplication tradingApplication = new TradingApplication.Builder()
                .setEnvironment(TradingEnvironment.PAPER)
                .setToken("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJsZW1vbi5tYXJrZXRzIiwiaXNzIjoibGVtb24ubWFya2V0cyIsInN1YiI6InVzcl9xeUdKVkJCZmYzNDVqWkxHTWwxQzhKdGtRTDFoMTM2TW5wIiwiZXhwIjoxNjgwNzk2ODI1LCJpYXQiOjE2NDkyNjA4MjUsImp0aSI6ImFwa19xeUdKVkJCZ2dNS1hxMnBRWVI1MWdITkR5ZzRDdGc5bWRCIiwibW9kZSI6InBhcGVyIn0.SX0XjITYPGIOY-qPyxF_SWXYrrVchbuchJ-dNagFriw");
        new StockRepository().getStockViaSearch("Coinbase", new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null) {
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(((Stock)contentPackage.getValue()).getIsin())
                            .setAmountShares(100)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.BUY)
                            .setVenue(((Stock)contentPackage.getValue()).getVenues().get(0))
                            .create();
                    new OrderRepository().placeOrder(futureOrder, new ContentPackage.ApiAsyncReturn() {
                        @Override
                        public void getPackage(ContentPackage contentPackage) {
                            if (contentPackage.getValue() != null) {
                                new OrderRepository().activateOrder(((PlacedOrder)contentPackage.getValue()).getId(), new ContentPackage.ApiAsyncReturn() {
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
                                System.out.println("Success placing order");

                            }
                            else{
                                System.out.println("Failure placing order");

                            }

                        }
                    });


                }
                else
                    System.out.println("Error: " + contentPackage.getException().getMessage());
            }
        });


        new PositionRepository().getPositions(new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null){
                    if ( ((ArrayList<Position>)contentPackage.getValue()).size() != 0) {
                        System.out.println("Positions: " + ((ArrayList<Position>) contentPackage.getValue()).get(0));
                    }
                }

                else
                    System.out.println("Error: " + contentPackage.getException().getMessage());

            }
        });



    }

}
