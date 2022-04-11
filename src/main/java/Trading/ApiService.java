package Trading;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {


    @POST("orders/")
    @FormUrlEncoded
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    Call<ResponseBody> placeOrder(@Field("isin") String isin,
                                  @Field("expires_at") String expiresAt,
                                  @Field("side") String side,
                                  @Field("quantity") String amount,
                                  @Field("venue") String venue,
                                  @Header("Authorization") String auth);


    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    @POST("orders/{id}/activate/")
    Call<ResponseBody> activateOrder(@Path("id") String id,@Header("Authorization") String s);
    @POST("positions/")
    Call<ResponseBody> getPositions(@Header("Authorization") String s);

    @GET("instruments/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getStockViaSearch(@Query("search") String search, @Header("Authorization") String authorization);

    @GET("account/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getAccount(@Header("Authorization")String s);
}
