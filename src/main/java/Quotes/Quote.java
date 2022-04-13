package Quotes;

import Venue.Venue;

public class Quote {
    private String isin;
    private Venue venue;
    private Long bidVolume;
    private Long askVolume;
    private Long bidPrice;
    private Long askPrice;
    private Long time;

    public Quote(String isin, Venue venue, Long bidVolume, Long askVolume, Long bidPrice, Long askPrice, Long time) {
        this.isin = isin;
        this.venue = venue;
        this.bidVolume = bidVolume;
        this.askVolume = askVolume;
        this.bidPrice = bidPrice;
        this.askPrice = askPrice;
        this.time = time;
    }

    public Quote() {

    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Long getBidVolume() {
        return bidVolume;
    }

    public void setBidVolume(Long bidVolume) {
        this.bidVolume = bidVolume;
    }

    public Long getAskVolume() {
        return askVolume;
    }

    public void setAskVolume(Long askVolume) {
        this.askVolume = askVolume;
    }

    public Long getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Long bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Long getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(Long askPrice) {
        this.askPrice = askPrice;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public static class Builder{
        private final Quote quote;

        public Builder() {
            this.quote = new Quote();
        }
        public Builder setIsin(String isin) {
            quote.isin = isin;
            return this;
        }

        public Builder setVenue(Venue venue) {
            quote.venue = venue;
            return this;

        }

        public Builder setBidVolume(Long bidVolume) {
            quote.bidVolume = bidVolume;
            return this;

        }

        public Builder setAskVolume(Long askVolume) {
            quote.askVolume = askVolume;
            return this;

        }

        public Builder setBidPrice(Long bidPrice) {
            quote.bidPrice = bidPrice;
            return this;

        }

        public Builder setAskPrice(Long askPrice) {
            quote.askPrice = askPrice;
            return this;

        }

        public Builder setTime(Long time) {
            quote.time = time;
            return this;

        }
        public Quote create(){
            return quote;
        }
    }
}
