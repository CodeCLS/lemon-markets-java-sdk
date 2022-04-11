package Order.OrderTypes;

import Order.Side;
import Order.Status;
import Order.Type;
import Venue.Venue;

public class PlacedOrder {
    private String isin;
    private Long expiresAt;
    private Side side;
    private int quantity;
    private Long stopPrice;
    private Long limitPrice;
    private Long estimatedPrice;
    private Long charge;
    private String id;
    private Status status;
    private Type type;
    private String isinTitle;
    private Long activatedAt;
    private Long executedAt;
    private String notes;
    private Long createdAt;

    public PlacedOrder(String isin, Long expiresAt, Side side, int quantity, Long stopPrice, Long limitPrice, Long estimatedPrice, Long charge, String id, Status status, Type type, String isinTitle, Long activatedAt, Long executedAt, String notes, Long createdAt, Venue venue) {
        this.isin = isin;
        this.expiresAt = expiresAt;
        this.side = side;
        this.quantity = quantity;
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
        this.estimatedPrice = estimatedPrice;
        this.charge = charge;
        this.id = id;
        this.status = status;
        this.type = type;
        this.isinTitle = isinTitle;
        this.activatedAt = activatedAt;
        this.executedAt = executedAt;
        this.notes = notes;
        this.createdAt = createdAt;
        this.venue = venue;
    }

    public PlacedOrder() {
    }

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



    public Long getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Long estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public Long getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(Long stopPrice) {
        this.stopPrice = stopPrice;
    }

    public Long getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(Long limitPrice) {
        this.limitPrice = limitPrice;
    }

    public Long getCharge() {
        return charge;
    }

    public void setCharge(Long charge) {
        this.charge = charge;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getIsinTitle() {
        return isinTitle;
    }

    public void setIsinTitle(String isinTitle) {
        this.isinTitle = isinTitle;
    }

    public Long getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(Long activatedAt) {
        this.activatedAt = activatedAt;
    }

    public Long getExecutedAt() {
        return executedAt;
    }

    public void setExecutedAt(Long executedAt) {
        this.executedAt = executedAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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

        public PlacedOrder getPlacedOrder() {
            return placedOrder;
        }

        public void setPlacedOrder(PlacedOrder placedOrder) {
            this.placedOrder = placedOrder;
        }

        public Builder setStopPrice(Long stopPrice){
            placedOrder.setStopPrice(stopPrice);
            return this;

        }
        public Builder setLimitPrice(Long limitPrice){
            placedOrder.setLimitPrice(limitPrice);
            return this;

        }
        public Builder setEstimatedPrice(Long estimatedPrice){
            placedOrder.setEstimatedPrice(estimatedPrice);
            return this;

        }
        public Builder setCharge(Long charge){
            placedOrder.setCharge(charge);
            return this;

        }

        public Builder setStatus(Status status){
            placedOrder.setStatus(status);
            return this;
        }
        public Builder setType(Type type){
            placedOrder.setType(type);
            return this;
        }
        public Builder setCreatedAt(Long time){
            placedOrder.setCreatedAt(time);
            return this;
        }
        public Builder setIsinTitle(String isinTitle){
            placedOrder.setIsinTitle(isinTitle);
            return this;
        }
        public Builder setActivatedAt(Long time){
            placedOrder.setActivatedAt(time);
            return this;
        }
        public Builder setExecutedAt(Long time){
            placedOrder.setExecutedAt(time);
            return this;
        }
        public Builder setNotes(String notes){
            placedOrder.setNotes(notes);
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
