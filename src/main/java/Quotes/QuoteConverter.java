package Quotes;

import Tools.DateUtil;
import Venue.Venue;
import org.json.JSONObject;

public class QuoteConverter {
    public Quote convertJSON(String toString) {
        System.out.println("json: " + toString);
        JSONObject jsonObject = new JSONObject(toString);
        try {
            jsonObject = jsonObject.getJSONArray("results").getJSONObject(0);
        }catch (Exception e){
        }
        Quote.Builder builder = new Quote.Builder()
                .setIsin(jsonObject.get("isin").toString())
                .setAskPrice(Long.parseLong(jsonObject.get("a").toString()))
                .setBidPrice(Long.parseLong(jsonObject.get("b").toString()))
                .setTime(DateUtil.convertDateToMillis(jsonObject.get("t").toString()))
                .setVenue(Venue.ofMic(jsonObject.get("mic").toString()))
                .setAskVolume(Long.parseLong(jsonObject.get("a_v").toString()))
                .setBidVolume(Long.parseLong(jsonObject.get("b_v").toString()));
        return builder.create();
    }
}
