package Order;

import Order.OrderTypes.PlacedOrder;
import Stock.Stock;
import Tools.DateUtil;
import Venue.Venue;
import Venue.VenueConverter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

public class OrderConverter {
    public PlacedOrder convertJSON(String string) {
        JSONObject jsonObject = new JSONObject(string);
        JSONObject jsonObject1 = jsonObject.getJSONObject("results");
        PlacedOrder.Builder builder =new PlacedOrder.Builder()
                .setIsin(jsonObject1.getString("isin"))
                .setExpiresAt(
                        DateUtil.convertDateToMillis(jsonObject1.getString("expires_at"))
                )
                .setSide(Side.of(jsonObject1.getString("side")))
                .setQuantity(jsonObject1.getInt("quantity"))
                .setVenue(Venue.ofMic(jsonObject1.getString("venue")))
                .setId(jsonObject1.getString("id"));

        try {
            builder.setStopPrice(Long.parseLong(jsonObject1.get("stop_price").toString()));
            builder.setLimitPrice(Long.parseLong(jsonObject1.get("limit_price").toString()));
        }catch (Exception e){
            System.err.println(e.getMessage());

        }
        return builder.create();





    }


    public ArrayList<PlacedOrder> convertArrayJSON(String json) {
        ArrayList<PlacedOrder> placedOrders = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i< jsonArray.length();i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            PlacedOrder.Builder builder = new PlacedOrder.Builder()
                    .setId(jsonObject1.getString("id"))
                    .setIsin(jsonObject1.getString("isin"))
                    .setExpiresAt(DateUtil.convertDateToMillis(jsonObject1.getString("expires_at")))
                    .setSide(Side.of(jsonObject1.getString("side")))
                    .setQuantity(jsonObject1.getInt("quantity"))
                    .setEstimatedPrice(jsonObject1.getLong("estimated_price"))
                    .setVenue(Venue.ofMic(jsonObject1.getString("venue")))
                    .setCharge(jsonObject1.getLong("charge"))
                    .setStatus(Status.of(jsonObject1.getString("status")))
                    .setType(Type.of(jsonObject1.getString("type")))
                    .setCreatedAt(DateUtil.convertDateToMillis(jsonObject1.getString("created_at")))
                    .setIsinTitle(jsonObject1.getString("isin_title"));
            try {
                builder.setStopPrice(jsonObject1.getLong("stop_price"));
                builder.setLimitPrice(jsonObject1.getLong("limit_price")); }
            catch (Exception e){}
            try{
                builder.setNotes(jsonObject1.getString("notes")); }
            catch (Exception e){}
            try{
                builder.setActivatedAt(DateUtil.convertDateToMillis((jsonObject1.getString("activated_at"))));
            }
            catch (Exception e){}
            try {
                builder.setExecutedAt(DateUtil.convertDateToMillis((jsonObject1.getString("executed_at"))));
            }
            catch (Exception e){}

            placedOrders.add(builder.create());

        }

        return placedOrders;
    }
}
