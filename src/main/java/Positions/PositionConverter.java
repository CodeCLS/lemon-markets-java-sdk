package Positions;

import Order.OrderTypes.PlacedOrder;
import Order.Side;
import Tools.DateUtil;
import Venue.Venue;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class PositionConverter {
    public Position convertJSON(String string) {
        JSONObject jsonObject = new JSONObject(string);
        JSONObject jsonObject1 = jsonObject.getJSONObject("results");
        Position.Builder builder =new Position.Builder()
                .setIsin(jsonObject1.getString("isin"))
                .setIsinTitle(jsonObject1.getString("isin_title"))
                .setBuyPriceAverage(jsonObject1.getLong("buy_price_avg"))
                .setQuantity(jsonObject1.getInt("quantity"))
                .setEstimatedPrice(jsonObject1.getLong("estimated_price"))
                .setEstimatedPriceTotal(jsonObject1.getLong("estimated_price_total"));

        return builder.create();
    }
    public ArrayList<Position> convertArray(String val) {
        ArrayList<Position> arrayList = new ArrayList<>();
        System.out.println("convertarray: " + val);
        JSONObject jsonObject = new JSONObject(val);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i< jsonArray.length(); i++){
            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
            arrayList.add(convertJSON(jsonObject1.toString()));
        }
        return arrayList;
    }

}
