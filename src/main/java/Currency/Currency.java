package Currency;

public class Currency {
    private CurrencyType currencyId;

    public Currency(CurrencyType currency) {
        this.currencyId = currency;
    }

    public Currency() {
    }

    public CurrencyType getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(CurrencyType currencyId) {
        this.currencyId = currencyId;
    }

    public class Builder{
        private Currency currency;
        public Builder() {
            this.currency = new Currency();
        }
        public Builder setCurrencyId(CurrencyType id){
            currency.setCurrencyId(id);
            return this;
        }
    }
}
