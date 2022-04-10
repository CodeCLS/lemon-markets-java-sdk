package Positions;

import Exceptions.StockBodyEmptyException;
import Exceptions.UnsuccessfulException;
import Order.OrderConverter;
import models.ContentPackage;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

public class PositionApiConnection {
    public static String BASE_URL = "https://data.lemon.markets/v1/";
    private static String API_TOKEN;
    private final Retrofit retrofit;
    private PositionApiService service;
    public PositionApiConnection(String token) {
        API_TOKEN = token;
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        service = retrofit.create(PositionApiService.class);

    }
    public void getPositions(ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        ContentPackage contentPackage = new ContentPackage();
        service.getPositions("Bearer " + API_TOKEN).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        try {
                            String val = response.body().string();
                            contentPackage.setValue(new PositionConverter().convertArray(val));
                        } catch (IOException e) {
                            contentPackage.setException(e);
                            e.printStackTrace();
                        }
                    } else {
                        contentPackage.setException(new StockBodyEmptyException());

                    }
                } else {
                    contentPackage.setException(new UnsuccessfulException());
                }
                apiAsyncReturn.getPackage(contentPackage);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                contentPackage.setException(new Exception(t.getMessage()));
                apiAsyncReturn.getPackage(contentPackage);

            }
        });
    }

}
