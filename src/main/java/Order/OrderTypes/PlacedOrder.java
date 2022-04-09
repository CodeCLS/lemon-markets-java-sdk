package Order.OrderTypes;

import Order.Side;
import Venue.Venue;

public class PlacedOrder {
    private String isin;
    private Long expiresAt;
    private Side side;
    private int quantity;
    private int stopPrice;
    private int limitPrice;
    private int estimatedPrice;
    private int charge;
    private String id;

    private Venue venue;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(int stopPrice) {
        this.stopPrice = stopPrice;
    }

    public int getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(int limitPrice) {
        this.limitPrice = limitPrice;
    }

    public int getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(int estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public static class Builder{
        private PlacedOrder placedOrder;

        public Builder() {
            placedOrder = new PlacedOrder();
        }
        public Builder setIsin(String isin){
            placedOrder.setIsin(isin);
            return this;

        }
        public Builder setExpiresAt(Long time){
            placedOrder.setExpiresAt(time);
            return this;

        }
        public Builder setSide(Side side){
            placedOrder.setSide(side);
            return this;

        }
        public Builder setQuantity(int amount){
            placedOrder.setQuantity(amount);
            return this;

        }
        public Builder setVenue(Venue venue){
            placedOrder.setVenue(venue);
            return this;

        }
        public Builder setStopPrice(int stopPrice){
            placedOrder.setStopPrice(stopPrice);
            return this;

        }
        public Builder setLimitPrice(int limitPrice){
            placedOrder.setLimitPrice(limitPrice);
            return this;

        }
        public Builder setEstimatedPrice(int estimatedPrice){
            placedOrder.setEstimatedPrice(estimatedPrice);
            return this;

        }
        public Builder setCharge(int charge){
            placedOrder.setCharge(charge);
            return this;

        }
        public Builder setId(String id){
            placedOrder.setId(id);
            return this;

        }
        public PlacedOrder create(){
            return placedOrder;
        }

    }

}
