package Positions;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PositionApiService {
    @GET("positions/")
    Call<ResponseBody> getPositions(@Header("Authorization") String s);
}
