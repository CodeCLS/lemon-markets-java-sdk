package Order.OrderTypes;

import Order.Side;
import Venue.Venue;
import org.json.JSONObject;

public class FutureOrder {
    private String isin;
    private Long expiresAt;
    private Side side;
    private int amountShares;
    private Venue venue;



    public FutureOrder(String isin, Long expiresAt, Side side, int shares, Venue venue) {
        this.isin = isin;
        this.expiresAt = expiresAt;
        this.side = side;
        this.amountShares = shares;
        this.venue = venue;
    }

    public FutureOrder() {
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(Long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public int getAmountShares() {
        return amountShares;
    }

    public void setAmountShares(int shares) {
        this.amountShares = shares;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isin",isin);
        jsonObject.put("expires_at",expiresAt);
        jsonObject.put("side",side.toString().toLowerCase());
        jsonObject.put("quantity",amountShares);
        jsonObject.put("venue",venue.getMic());
        System.out.println("orderjson: " + jsonObject.toString());

        return jsonObject;
    }

    public static class Builder{
        private FutureOrder futureOrder;

        public Builder() {
            futureOrder = new FutureOrder();
        }
        public Builder setIsin(String isin){
            futureOrder.setIsin(isin);
            return this;

        }
        public Builder setExpiresAt(Long time){
            futureOrder.setExpiresAt(time);

            return this;

        }
        public Builder setSide(Side side){
            futureOrder.setSide(side);
            return this;

        }
        public Builder setAmountShares(int amount){
            futureOrder.setAmountShares(amount);

            return this;

        }
        public Builder setVenue(Venue venue){
            futureOrder.setVenue(venue);
            return this;

        }
        public FutureOrder create(){
            return futureOrder;
        }
    }

}
