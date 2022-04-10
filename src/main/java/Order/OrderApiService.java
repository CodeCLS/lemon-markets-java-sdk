package Order;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface OrderApiService {
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
}
