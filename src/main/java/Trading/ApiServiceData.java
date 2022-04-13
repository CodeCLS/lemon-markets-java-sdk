package Trading;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiServiceData {
    @GET("instruments/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getStockViaSearch(@Query("search") String search, @Header("Authorization") String authorization);

    @GET("quotes/latest")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getLatestQuotes(String isin, String mic, String s);
}
