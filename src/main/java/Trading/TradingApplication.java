package Trading;

public class TradingApplication {
    public static final String DATA_BASE_URL = "https://data.lemon.markets/v1/";
    public static final String PAPER_BASE_URL = "https://paper-trading.lemon.markets/v1/";
    public static final String LIVE_BASE_URL = "https://trading.lemon.markets/v1/";

    public static TradingApplication instance;
    public String token;
    private TradingEnvironment tradingEnvironment;
    public static class Builder{
        private final TradingApplication application;

        public Builder() {
            this.application = new TradingApplication();
        }
        public Builder setEnvironment(TradingEnvironment tradingEnvironment){
            this.application.setTradingEnvironment(tradingEnvironment);
            return this;
        }
        public TradingApplication setToken(String token){
            this.application.setToken(token);
            instance = application;
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
