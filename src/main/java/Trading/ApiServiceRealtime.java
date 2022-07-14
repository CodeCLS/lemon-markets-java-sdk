package Trading;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiServiceRealtime {
    @POST("auth/")
    //@FormUrlEncoded
    @Headers({
            "Content-Type: application/json",
            "Accept: application/json",
    })
    Call<ResponseBody> requestRealTimeAuthToken(@Header("Authorization") String authorization);
}
