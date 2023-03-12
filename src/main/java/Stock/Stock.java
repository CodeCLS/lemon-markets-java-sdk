package Stock;

import Venue.Venue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.Map;

public class Stock {
    private String isin;
    private String wkn;
    private String name;
    private String title;
    private String symbol;
    private String type;
    private ArrayList<Venue> venues = new ArrayList<Venue>();

    private Stock(String isin, String wkn, String name, String title, String symbol, String type) {
        this.isin = isin;
        this.wkn = wkn;
        this.name = name;
        this.title = title;
        this.symbol = symbol;
        this.type = type;
    }
    public String getIsin() {
        return isin;
    }
    public void setIsin(String isin) {
        this.isin = isin;
    }
    public String getWkn() {
        return wkn;
    }
    public void setWkn(String wkn) {
        this.wkn = wkn;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSymbol() {
        return symbol;
    }
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ArrayList<Venue> getVenues() {
        return venues;
    }
    public void setVenues(ArrayList<Venue> venues) {
        this.venues = venues;
    }

    public Stock() {
    }

    @Override
    public String toString() {
        return " " + isin + " " + wkn + " " + name + " " +title;
    }

    public static class Builder{
        private final Stock stock;

        public Builder() {
            this.stock = new Stock();
        }
        public Builder setIsin(String isin){
            stock.setIsin(isin);
            return this;

        }
        public Builder setWkn(String wkn){
            stock.setWkn(wkn);

            return this;


        }
        public Builder setName(String name){
            stock.setName(name);

            return this;


        }
        public Builder setTitle(String title){
            stock.setTitle(title);

            return this;


        }
        public Builder setSymbol(String symbol){
            stock.setSymbol(symbol);
            return this;
        }
        public Builder setType(String type){
            stock.setType(type);
            return this;


        }

        public Builder setVenues(ArrayList<Venue> venues){
            stock.setVenues(venues);
            return this;
        }
        public Stock getStock(){
            return stock;
        }

        public Stock create() {
            return stock;
        }
    }
}
