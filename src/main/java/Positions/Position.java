package Positions;

public class Position {
    private String isin;
    private String isinTitle;
    private int quantity;
    private Long buyPriceAverage;
    private Long estimatedPriceTotal;
    private Long estimatedPrice;

    public Position(String isin, String isinTitle, int quantity, Long buyPriceAverage, Long estimatedPriceTotal, Long estimatedPrice) {
        this.isin = isin;
        this.isinTitle = isinTitle;
        this.quantity = quantity;
        this.buyPriceAverage = buyPriceAverage;
        this.estimatedPriceTotal = estimatedPriceTotal;
        this.estimatedPrice = estimatedPrice;
    }

    public Position() {
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getIsinTitle() {
        return isinTitle;
    }

    public void setIsinTitle(String isinTitle) {
        this.isinTitle = isinTitle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getBuyPriceAverage() {
        return buyPriceAverage;
    }

    public void setBuyPriceAverage(Long buyPriceAverage) {
        this.buyPriceAverage = buyPriceAverage;
    }

    public Long getEstimatedPriceTotal() {
        return estimatedPriceTotal;
    }

    public void setEstimatedPriceTotal(Long estimatedPriceTotal) {
        this.estimatedPriceTotal = estimatedPriceTotal;
    }

    public Long getEstimatedPrice() {
        return estimatedPrice;
    }

    public void setEstimatedPrice(Long estimatedPrice) {
        this.estimatedPrice = estimatedPrice;
    }

    public static class Builder{
        private Position position;

        public Builder() {
            position = new Position();
        }
        public Builder setIsin(String isin) {
            position.setIsin(isin);
            return this;

        }

        public Builder setIsinTitle(String isinTitle) {
            position.setIsinTitle(isinTitle);
            return this;


        }

        public Builder setQuantity(int quantity) {
            position.setQuantity(quantity);
            return this;


        }

        public Builder setBuyPriceAverage(Long buyPriceAverage) {
            position.setBuyPriceAverage(buyPriceAverage);
            return this;

        }

        public Builder setEstimatedPriceTotal(Long estimatedPriceTotal) {
            position.setEstimatedPriceTotal(estimatedPriceTotal);
            return this;

        }

        public Builder setEstimatedPrice(Long estimatedPrice) {
            position.setEstimatedPrice(estimatedPrice);
            return this;
        }
        public Position create(){
            return position;
        }
    }

}
