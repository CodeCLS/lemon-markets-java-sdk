package Trading;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

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
    Call<ResponseBody> getStockViaIsin(@Query("isin") String search, @Header("Authorization") String authorization);
    Call<ResponseBody> getStockViaWkn(@Query("wkn") String wkn, @Header("Authorization") String authorization);

    Call<ResponseBody> getLatestQuotes(@Query("isin") String isin,@Query("mic") String mic,@Query("decimals")String  decimal, @Header("Authorization")String s);
}
