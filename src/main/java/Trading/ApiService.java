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

    @GET("positions/")
    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    Call<ResponseBody> getPositions(@Header("Authorization") String s);

    @GET("account/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getAccount(@Header("Authorization")String s);
    @FormUrlEncoded
    @POST("withdrawals/")
    Call<ResponseBody> withdrawal(@Field("amount") Long amount,@Field("pin") int pin,@Header("Authorization") String s);
    @GET("orders/")
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> getOrders(@Header("Authorization") String s);
}
