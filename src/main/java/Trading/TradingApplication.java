package Trading;

import Order.OrderApiConnection;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class TradingApplication {
    public static final String DATA_BASE_URL = "https://data.lemon.markets/v1/";
    public static final String PAPER_BASE_URL = "https://paper-trading.lemon.markets/v1/";
    public static final String LIVE_BASE_URL = "https://trading.lemon.markets/v1/";

    private Retrofit retrofit;

    public static TradingApplication instance;
    public String token;
    public ApiService service;
    private TradingEnvironment tradingEnvironment;
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
            instance = application;
            application.retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            application.service = application.retrofit.create(ApiService.class);

            return application;
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
}
