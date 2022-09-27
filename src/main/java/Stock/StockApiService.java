package Stock;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface StockApiService {
    @GET("instruments/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getStockViaSearch(@Query("search") String search, @Header("Authorization") String authorization);
    Call<ResponseBody> getStockViaIsin(@Query("isin") String search, @Header("Authorization") String authorization);
    Call<ResponseBody> getStockViaWkn(@Query("wkn") String search, @Header("Authorization") String authorization);

}
