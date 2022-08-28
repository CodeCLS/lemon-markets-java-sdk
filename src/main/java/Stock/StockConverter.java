package Stock;
import Venue.VenueConverter;
import org.json.JSONArray;
import org.json.JSONObject;
public class StockConverter {
    public StockConverter() {

    }

    public Stock convertJSON(String string) {
        JSONObject jsonObject = new JSONObject(string);
        JSONArray jsonArray = jsonObject.getJSONArray("results");
        JSONObject jsonObject1 = jsonArray.optJSONObject(0);
        return new Stock.Builder()
                .setIsin(jsonObject1.getString("isin"))
                .setWkn(!jsonObject1.has("wkn") ? "" : jsonObject1.getString("wkn"))
                .setName(!jsonObject1.has("name")? "" : jsonObject1.getString("name"))
                .setTitle(!jsonObject1.has("title") ? "" : jsonObject1.getString("title"))
                .setSymbol(!jsonObject1.has("symbol") ? " " : jsonObject1.getString("symbol"))
                .setType(!jsonObject1.has("type") ? " " : jsonObject1.getString("type"))
                .setVenues(!jsonObject1.has("venues") ? null : new VenueConverter().convertJSONArray(jsonObject1.getJSONArray("venues")))
               .create();



    }
}
