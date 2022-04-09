package Venue;
import Currency.CurrencyType;
import Currency.Currency;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.function.Consumer;

public class VenueConverter {
    public VenueConverter() {

    }

    public Venue convertJSON(String string) {
        JSONObject jsonObject = new JSONObject(string);
        return new Venue.Builder()
                .setName(jsonObject.getString("name"))
                .setTitle(jsonObject.getString("title"))
                .setMic(jsonObject.getString("mic"))
                .setOpen(jsonObject.getBoolean("is_open"))
                .setTradable(jsonObject.getBoolean("tradable"))
                .setCurrency(new Currency(CurrencyType.of(jsonObject.getString("currency"))))
                .create();
    }

    public ArrayList<Venue> convertJSONArray(JSONArray venues) {
        ArrayList<Venue> list = new ArrayList<Venue>();
        System.out.println("venues: " +venues);
        for (int i = 0; i < venues.length(); i++) {
            JSONObject jsonObject = venues.getJSONObject(i);
            System.out.println(jsonObject);
            list.add(new Venue.Builder()
                    .setName(jsonObject.getString("name"))
                    .setTitle(jsonObject.getString("title"))
                    .setMic(jsonObject.getString("mic"))
                    .setOpen(jsonObject.getBoolean("is_open"))
                    .setTradable(jsonObject.getBoolean("tradable"))
                    .setCurrency(new Currency(CurrencyType.of(jsonObject.getString("currency"))))
                    .create());
        }
        return list;
    }
}
