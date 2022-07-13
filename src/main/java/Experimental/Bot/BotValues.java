package Experimental.Bot;

import Stock.Stock;
import Trading.TradingApplication;

import java.util.ArrayList;
import java.util.Arrays;

class BotValues {
    public ArrayList<String> stocks;
    public TradingPattern pattern;

    public BotValues(ArrayList<String> stocks, TradingPattern pattern) {
        this.stocks = stocks;
        this.pattern = pattern;
    }

    public ArrayList<String> getStocks() {
        return stocks;
    }

    public void setStocks(ArrayList<String> stocks) {
        this.stocks = stocks;
    }

    public TradingPattern getPattern() {
        return pattern;
    }

    public void setPattern(TradingPattern pattern) {
        this.pattern = pattern;
    }
}
