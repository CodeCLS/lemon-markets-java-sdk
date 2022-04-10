package Positions;

import Exceptions.StockBodyEmptyException;
import Exceptions.UnsuccessfulException;
import Order.OrderConverter;
import Trading.ApiService;
import Trading.TradingApplication;
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
    private final String token;
    private ApiService service;
    public PositionApiConnection() {
        service = TradingApplication.instance.service;
        token =  TradingApplication.instance.token;
    }
    public void getPositions(ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        ContentPackage contentPackage = new ContentPackage();
        service.getPositions("Bearer " + token ).enqueue(new Callback<ResponseBody>() {
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
