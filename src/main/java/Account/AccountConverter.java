package Account;

import Address.Address;
import Tools.DateUtil;
import Trading.TradingEnvironment;
import org.json.JSONObject;

import java.util.Date;

public class AccountConverter {
    public Account convertJSON(String val) {
        JSONObject jsonObject = new JSONObject(val);
        JSONObject resultsObject = jsonObject.getJSONObject("results");
        Account.Builder builder = new Account.Builder()
                .setAccountId(resultsObject.get("account_id").toString())
                .setFirstName(resultsObject.get("firstname").toString())
                .setLastName(resultsObject.get("lastname").toString())
                .setIbanBrokerage(resultsObject.get("iban_brokerage").toString())
                .setIbanOrigin(resultsObject.get("iban_origin").toString())
                .setBalance(resultsObject.getLong("balance"))
                .setCashToInvest(resultsObject.getLong("cash_to_invest"))
                .setCashToWithdraw(resultsObject.getLong("cash_to_withdraw"))
                .setAmountBoughtIntraday(resultsObject.getLong("amount_bought_intraday"))
                .setAmountSoldIntraday(resultsObject.getLong("amount_sold_intraday"))
                .setAmountOpenOrders(resultsObject.getLong("amount_open_orders"))
                .setAmountOpenWithdrawals(resultsObject.getLong("amount_open_withdrawals"))
                .setMode(TradingEnvironment.of(resultsObject.get("mode").toString()))
                .setCreatedAt(DateUtil.convertDateToMillis(resultsObject.getString("created_at")))
                .setEmail(resultsObject.get("email").toString())
                .setNumber(resultsObject.get("phone").toString())
                .setBillingEmail(resultsObject.get("billing_email").toString())
                .setBillingName(resultsObject.get("billing_name").toString())
                .setBillingVat(resultsObject.get("billing_vat").toString())
                .setDepositId(resultsObject.get("deposit_id").toString())
                .setBankNameOrigin(resultsObject.get("bank_name_origin").toString())
                .setApprovedAt(DateUtil.convertDateToMillis(resultsObject.get("approved_at").toString()))
                .setTradingPlan(Plan.of(resultsObject.get("trading_plan").toString()))
                .setDataPlan(Plan.of(resultsObject.get("data_plan").toString()));

        try {
            String addressString = resultsObject.get("address").toString();
            Address address = new Address.Builder()
                    .setStreetNumber(addressString.split("\\s+")[0])
                    .setStreetNumber(addressString.split("\\s+")[1])
                    .setPostalCode(addressString.split("\\s+")[2])
                    .setCity(addressString.split("\\s+")[3])
                    .create();
            builder.setAddress(address);

        }catch (Exception e) {
        }
        try{
            String billingAddressString = resultsObject.get("billing_address").toString();
            Address billingAddress = new Address.Builder()
                    .setStreetNumber(billingAddressString.split("\\s+")[0])
                    .setStreetNumber(billingAddressString.split("\\s+")[1])
                    .setPostalCode(billingAddressString.split("\\s+")[2])
                    .setCity(billingAddressString.split("\\s+")[3]).create();
            builder.setBillingAddress(billingAddress);

        }catch (Exception e) {
        }

        try {
            builder.setClientId(Long.parseLong(resultsObject.get("client_id").toString()));
            builder.setAccountNumber(Long.parseLong(resultsObject.get("account_number").toString()));
            builder.setTaxAllowance(Long.parseLong(resultsObject.get("tax_allowance").toString()));
            builder.setTaxAllowanceStart(Long.parseLong(resultsObject.get("tax_allowance_start").toString()));
            builder.setTaxAllowanceEnd(Long.parseLong(resultsObject.get("tax_allowance_end").toString()));
        }catch (Exception e){
        }




        return builder.create();
    }
}
