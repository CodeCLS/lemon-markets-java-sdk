# Lemon-Markets-Java-SDK
[![](https://jitpack.io/v/CodeCLS/Lemon-Markets-Java-SDK.svg)](https://jitpack.io/#CodeCLS/Lemon-Markets-Java-SDK)

Hey there,
this SDK is not developed by lemon.markets and the company is not afiliated with me.
However, I enjoyed the API so much, that I decided to create a simple SDK for Java. 
I hope you enjoy it.


<H3>build.gradle implementation(Jitpack):</H3>

<H4>Jitpack implementation</H4>

```groovy

Gradle.. 

allprojects {
repositories {
    maven { url 'https://jitpack.io' }
    }
}
```



```groovy

or...Maven...

<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>

```


<H4>Repo implementation</H4>


```groovy
Gradle...

dependencies {
    implementation 'com.github.CodeCLS:Lemon-Markets-Java-SDK:1.0.0.0'
}
```


```groovy

or...Maven...

<dependency>
	    <groupId>com.github.CodeCLS</groupId>
	    <artifactId>Lemon-Markets-Java-SDK</artifactId>
	    <version>Tag</version>
</dependency>
```

<H3>Setup Environment & Token</H3>

1. __Choose your environment (Paper/Live)__

```Java

TradingEnvironment.PAPER
TradingEnvironment.LIVE

   ```     
2. __Enter your token__

```java

TradingApplication tradingApplication = new TradingApplication.Builder()
    .setEnvironment(TradingEnvironment.PAPER)
    .setToken("<TOKEN>");

   ```
3. __Start coding__
   
   __*PositionsRepository*__ > Retrieve all your positions

   __*StockRepository*__ > Endpoints regarding stocks
   
   __*OrderRepository*__ > Buying and selling/Activating 

   __*QuoteRepository*__ > Retrieving data for Stocks *UNFINISHED*

   __*AccountRepository*__ > Retrieving data regarding your account

__Example Code__

```Java

public class SDKTesting {
    public static void main(String args[]) {
        //SETUP APPLICATION
        TradingApplication tradingApplication = new TradingApplication.Builder()
                .setEnvironment(TradingEnvironment.PAPER)
                .setToken("TOKEN");
        
        //GET STOCK VIA NAME
        new StockRepository().getStockViaSearch("Coinbase", new ContentPackage.ApiAsyncReturn() {
            @Override
            public void getPackage(ContentPackage contentPackage) {
                if (contentPackage.getValue() != null) {
                    //CREATE A FUTURE ORDER
                    FutureOrder futureOrder = new FutureOrder.Builder()
                            .setIsin(((Stock)contentPackage.getValue()).getIsin())
                            .setAmountShares(100)
                            .setExpiresAt(System.currentTimeMillis() + 10000000)
                            .setSide(Side.BUY)
                            .setVenue(((Stock)contentPackage.getValue()).getVenues().get(0))
                            .create();
                    //PLACE ORDER
                    new OrderRepository().placeOrder(futureOrder, new ContentPackage.ApiAsyncReturn() {
                        @Override
                        public void getPackage(ContentPackage contentPackage) {
                            if (contentPackage.getValue() != null) {
                                //ACTIVATE THE PRIOR ORDER
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

//GET POSITIONS
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

```

<a href='https://ko-fi.com/CodeC' target='_blank'><img height='35' style='border:0px;height:46px;' src='https://az743702.vo.msecnd.net/cdn/kofi3.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' />





