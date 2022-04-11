package Account;

import Address.Address;

public class Account {
    private long createdAt;
    private String accountId;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private Address address;
    private Address billingAddress;
    private String billingEmail;
    private String billingName;
    private String billingVat;
    private String mode;
    private String depositId;
    private long clientId;
    private long accountNumber;
    private String ibanBrokerage;
    private String ibanOrigin;
    private String bankNameOrigin;
    private Long balance;
    private Long cashToInvest;
    private Long cashToWithdraw;
    private Long amountBoughtIntraday;
    private Long amountSoldIntraday;
    private Long amountOpenOrders;
    private Long amountOpenWithdrawals;
    private Long amountEstimateTaxes;
    private Long approvedAt;
    private Plan tradingPlan;
    private Plan dataPlan;
    private Long taxAllowance;
    private Long taxAllowanceStart;
    private Long taxAllowanceEnd;

    public Account(long createdAt, String accountId, String firstName,
                   String lastName, String email, String number,
                   Address address, Address billingAddress,
                   String billingEmail, String billingName,
                   String billingVat, String mode, String depositId,
                   long clientId, long accountNumber,
                   String ibanBrokerage, String ibanOrigin,
                   String bankNameOrigin, Long balance, Long cashToInvest,
                   Long cashToWithdraw, Long amountBoughtIntraday,
                   Long amountSoldIntraday, Long amountOpenOrders,
                   Long amountOpenWithdrawals, Long amountEstimateTaxes,
                   Long approvedAt, Plan tradingPlan, Plan dataPlan,
                   Long taxAllowance, Long taxAllowanceStart,
                   Long taxAllowanceEnd) {
        this.createdAt = createdAt;
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.number = number;
        this.address = address;
        this.billingAddress = billingAddress;
        this.billingEmail = billingEmail;
        this.billingName = billingName;
        this.billingVat = billingVat;
        this.mode = mode;
        this.depositId = depositId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.ibanBrokerage = ibanBrokerage;
        this.ibanOrigin = ibanOrigin;
        this.bankNameOrigin = bankNameOrigin;
        this.balance = balance;
        this.cashToInvest = cashToInvest;
        this.cashToWithdraw = cashToWithdraw;
        this.amountBoughtIntraday = amountBoughtIntraday;
        this.amountSoldIntraday = amountSoldIntraday;
        this.amountOpenOrders = amountOpenOrders;
        this.amountOpenWithdrawals = amountOpenWithdrawals;
        this.amountEstimateTaxes = amountEstimateTaxes;
        this.approvedAt = approvedAt;
        this.tradingPlan = tradingPlan;
        this.dataPlan = dataPlan;
        this.taxAllowance = taxAllowance;
        this.taxAllowanceStart = taxAllowanceStart;
        this.taxAllowanceEnd = taxAllowanceEnd;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }

    public String getBillingName() {
        return billingName;
    }

    public void setBillingName(String billingName) {
        this.billingName = billingName;
    }

    public String getBillingVat() {
        return billingVat;
    }

    public void setBillingVat(String billingVat) {
        this.billingVat = billingVat;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDepositId() {
        return depositId;
    }

    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getIbanBrokerage() {
        return ibanBrokerage;
    }

    public void setIbanBrokerage(String ibanBrokerage) {
        this.ibanBrokerage = ibanBrokerage;
    }

    public String getIbanOrigin() {
        return ibanOrigin;
    }

    public void setIbanOrigin(String ibanOrigin) {
        this.ibanOrigin = ibanOrigin;
    }

    public String getBankNameOrigin() {
        return bankNameOrigin;
    }

    public void setBankNameOrigin(String bankNameOrigin) {
        this.bankNameOrigin = bankNameOrigin;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getCashToInvest() {
        return cashToInvest;
    }

    public void setCashToInvest(Long cashToInvest) {
        this.cashToInvest = cashToInvest;
    }

    public Long getCashToWithdraw() {
        return cashToWithdraw;
    }

    public void setCashToWithdraw(Long cashToWithdraw) {
        this.cashToWithdraw = cashToWithdraw;
    }

    public Long getAmountBoughtIntraday() {
        return amountBoughtIntraday;
    }

    public void setAmountBoughtIntraday(Long amountBoughtIntraday) {
        this.amountBoughtIntraday = amountBoughtIntraday;
    }

    public Long getAmountSoldIntraday() {
        return amountSoldIntraday;
    }

    public void setAmountSoldIntraday(Long amountSoldIntraday) {
        this.amountSoldIntraday = amountSoldIntraday;
    }

    public Long getAmountOpenOrders() {
        return amountOpenOrders;
    }

    public void setAmountOpenOrders(Long amountOpenOrders) {
        this.amountOpenOrders = amountOpenOrders;
    }

    public Long getAmountOpenWithdrawals() {
        return amountOpenWithdrawals;
    }

    public void setAmountOpenWithdrawals(Long amountOpenWithdrawals) {
        this.amountOpenWithdrawals = amountOpenWithdrawals;
    }

    public Long getAmountEstimateTaxes() {
        return amountEstimateTaxes;
    }

    public void setAmountEstimateTaxes(Long amountEstimateTaxes) {
        this.amountEstimateTaxes = amountEstimateTaxes;
    }

    public Long getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(Long approvedAt) {
        this.approvedAt = approvedAt;
    }

    public Plan getTradingPlan() {
        return tradingPlan;
    }

    public void setTradingPlan(Plan tradingPlan) {
        this.tradingPlan = tradingPlan;
    }

    public Plan getDataPlan() {
        return dataPlan;
    }

    public void setDataPlan(Plan dataPlan) {
        this.dataPlan = dataPlan;
    }

    public Long getTaxAllowance() {
        return taxAllowance;
    }

    public void setTaxAllowance(Long taxAllowance) {
        this.taxAllowance = taxAllowance;
    }

    public Long getTaxAllowanceStart() {
        return taxAllowanceStart;
    }

    public void setTaxAllowanceStart(Long taxAllowanceStart) {
        this.taxAllowanceStart = taxAllowanceStart;
    }

    public Long getTaxAllowanceEnd() {
        return taxAllowanceEnd;
    }

    public void setTaxAllowanceEnd(Long taxAllowanceEnd) {
        this.taxAllowanceEnd = taxAllowanceEnd;
    }

    public Account() {
    }

    public static class Builder{
        private Account account;
        public Builder() {
            account = new Account();

        }
        public Builder setCreatedAt(long createdAt) {
            account.createdAt = createdAt;
            return this;

        }

        public Builder setAccountId(String accountId) {
            account.accountId = accountId;
            return this;

        }

        public Builder setFirstName(String firstName) {
            account.firstName = firstName;
            return this;

        }

        public Builder setLastName(String lastName) {
            account.lastName = lastName;
            return this;

        }

        public Builder setEmail(String email) {
            account.email = email;
            return this;

        }

        public Builder setNumber(String number) {
            account.number = number;
            return this;

        }

        public Builder setAddress(Address address) {
            account.address = address;
            return this;

        }

        public Builder setBillingAddress(Address billingAddress) {
            account.billingAddress = billingAddress;
            return this;

        }

        public Builder setBillingEmail(String billingEmail) {
            account.billingEmail = billingEmail;
            return this;

        }

        public Builder setBillingName(String billingName) {
            account.billingName = billingName;
            return this;

        }

        public Builder setBillingVat(String billingVat) {
            account.billingVat = billingVat;
            return this;

        }

        public Builder setMode(String mode) {
            account.mode = mode;
            return this;

        }

        public Builder setDepositId(String depositId) {
            account.depositId = depositId;
            return this;

        }

        public Builder setClientId(long clientId) {
            account.clientId = clientId;
            return this;

        }

        public Builder setAccountNumber(long accountNumber) {
            account.accountNumber = accountNumber;
            return this;

        }

        public Builder setIbanBrokerage(String ibanBrokerage) {
            account.ibanBrokerage = ibanBrokerage;
            return this;

        }

        public Builder setIbanOrigin(String ibanOrigin) {
            account.ibanOrigin = ibanOrigin;
            return this;

        }

        public Builder setBankNameOrigin(String bankNameOrigin) {
            account.bankNameOrigin = bankNameOrigin;
            return this;

        }

        public Builder setBalance(Long balance) {
            account.balance = balance;
            return this;

        }

        public Builder setCashToInvest(Long cashToInvest) {
            account.cashToInvest = cashToInvest;
            return this;

        }

        public Builder setCashToWithdraw(Long cashToWithdraw) {
            account.cashToWithdraw = cashToWithdraw;
            return this;

        }

        public Builder setAmountBoughtIntraday(Long amountBoughtIntraday) {
            account.amountBoughtIntraday = amountBoughtIntraday;
            return this;

        }

        public Builder setAmountSoldIntraday(Long amountSoldIntraday) {
            account.amountSoldIntraday = amountSoldIntraday;
            return this;

        }

        public Builder setAmountOpenOrders(Long amountOpenOrders) {
            account.amountOpenOrders = amountOpenOrders;
            return this;

        }

        public Builder setAmountOpenWithdrawals(Long amountOpenWithdrawals) {
            account.amountOpenWithdrawals = amountOpenWithdrawals;
            return this;

        }

        public Builder setAmountEstimateTaxes(Long amountEstimateTaxes) {
            account.amountEstimateTaxes = amountEstimateTaxes;
            return this;

        }

        public Builder setApprovedAt(Long approvedAt) {
            account.approvedAt = approvedAt;
            return this;

        }

        public Builder setTradingPlan(Plan tradingPlan) {
            account.tradingPlan = tradingPlan;
            return this;

        }

        public Builder setDataPlan(Plan dataPlan) {
            account.dataPlan = dataPlan;
            return this;

        }

        public Builder setTaxAllowance(Long taxAllowance) {
            account.taxAllowance = taxAllowance;
            return this;

        }

        public Builder setTaxAllowanceStart(Long taxAllowanceStart) {
            account.taxAllowanceStart = taxAllowanceStart;
            return this;

        }

        public Builder setTaxAllowanceEnd(Long taxAllowanceEnd) {
            account.taxAllowanceEnd = taxAllowanceEnd;
            return this;
        }
        public Account create(){
            return account;
        }

    }
}
