package Trading;

import Exceptions.ApplicationNotInstantiated;
import Order.OrderApiConnection;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TradingApplication {
    public static final String REALTIME_BASE_URL = "https://realtime.lemon.markets/v1/";
    public static final String DATA_BASE_URL = "https://data.lemon.markets/v1/";
    public static final String PAPER_BASE_URL = "https://paper-trading.lemon.markets/v1/";
    public static final String LIVE_BASE_URL = "https://trading.lemon.markets/v1/";
    public static String account;

    private Retrofit retrofit;

    public static TradingApplication instance;
    public String token;
    public ApiService service;
    private TradingEnvironment tradingEnvironment;
    private Retrofit retrofitData;
    public ApiServiceData serviceData;
    public ApiServiceRealtime serviceRealtime;
    private Retrofit retrofitAuth;
    public String realtimeAuthToken;
    private String ablyUid;

    public void setRealtimeAblyUid(String user_id) {
        instance.ablyUid = user_id;
    }

    public String getAblyUid() {
        return instance.ablyUid;
    }

    public static class Builder{
        private static String BASE_URL = "";
        private final TradingApplication application;


        public Builder() {
            this.application = new TradingApplication();
        }
        public Builder setEnvironment(TradingEnvironment tradingEnvironment){
            this.application.setTradingEnvironment(tradingEnvironment);
            BASE_URL
                    = tradingEnvironment == TradingEnvironment.PAPER
                    ? TradingApplication.PAPER_BASE_URL : TradingApplication.LIVE_BASE_URL;
            return this;
        }
        public TradingApplication setToken(String token){
            this.application.setToken(token);
            buildTradingEnv();

            return application;
        }

        private void buildTradingEnv() {
            instance = application;
            application.retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            application.retrofitData = new Retrofit.Builder()
                    .baseUrl(DATA_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            application.retrofitAuth = new Retrofit.Builder()
                    .baseUrl(REALTIME_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

            if (application.realtimeAuthToken == null){
                System.err.println(
                        "Don't forget: If you want to use RealtimeData you have to fetch the Auth token first and inform" +
                                " the TradingApplication about it by using the func..setRealtimeAuthToken()");
            }

            application.service = application.retrofit.create(ApiService.class);
            application.serviceData = application.retrofitData.create(ApiServiceData.class);
            application.serviceRealtime = application.retrofitAuth.create(ApiServiceRealtime.class);
        }

        /**
         * Optional setting
         * RealtimeRepo requires the account id
         * @param id account id
         * @return a builder
         */
        public Builder setAccountId(String id){
            this.application.setAccountId(id);
            return this;
        }
   }

    public TradingEnvironment getTradingEnvironment() {
        return tradingEnvironment;
    }

    public void setTradingEnvironment(TradingEnvironment tradingEnvironment) {
        this.tradingEnvironment = tradingEnvironment;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static String getAccountId() {
        return account;
    }

    public static void setAccountId(String account) {
        TradingApplication.account = account;
    }

    public String getRealtimeAuthToken() {
        return realtimeAuthToken;
    }

    public void setRealtimeAuthToken(String realtimeAuthToken) {
        System.out.println("Set Auth Token");
        instance.realtimeAuthToken = realtimeAuthToken;
    }
}
