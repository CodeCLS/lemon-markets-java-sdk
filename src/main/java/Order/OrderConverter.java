package Order;

import Order.OrderTypes.PlacedOrder;
import Stock.Stock;
import Tools.DateUtil;
import Venue.Venue;
import Venue.VenueConverter;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

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
            builder.setStopPrice(Integer.parseInt(jsonObject1.get("stop_price").toString()))
                    .setLimitPrice(Integer.parseInt(jsonObject1.get("limit_price").toString()));
        }catch (Exception e){
            System.err.println(e.getMessage());

        }
        return builder.create();





    }


}
