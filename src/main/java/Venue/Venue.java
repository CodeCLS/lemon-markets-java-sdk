package Venue;


import Currency.Currency;

public class Venue {
    private String name;
    private String title;
    private String mic;
    private boolean isOpen;
    private boolean isTradable;
    private Currency currency;

    private Venue(String name, String title, String mic, boolean isOpen, boolean isTradable, Currency currency) {
        this.name = name;
        this.title = title;
        this.mic = mic;
        this.isOpen = isOpen;
        this.isTradable = isTradable;
        this.currency = currency;
    }

    private Venue() {
    }

    public static Venue ofMic(String venue1) {
        Venue venue = new Venue();
        venue.setMic(venue1);
        return venue;
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

    public String getMic() {
        return mic;
    }

    public void setMic(String mic) {
        this.mic = mic;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isTradable() {
        return isTradable;
    }

    public void setTradable(boolean tradable) {
        isTradable = tradable;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public static class Builder{
        private Venue venue;
        public Builder() {
            this.venue = new Venue();
        }
        public Builder setName(String name){
            venue.setName(name);
            return this;
        }
        public Builder setTitle(String title){
            venue.setTitle(title);

            return this;
        }
        public Builder setMic(String mic){
            venue.setMic(mic);

            return this;
        }
        public Builder setOpen(boolean isOpen){
            venue.setOpen(isOpen);

            return this;
        }
        public Builder setTradable(boolean isTradable){
            venue.setTradable(isTradable);

            return this;
        }
        public Builder setCurrency(Currency currency){
            venue.setCurrency(currency);

            return this;
        }

        public Venue create() {
            return venue;
        }
    }


}
