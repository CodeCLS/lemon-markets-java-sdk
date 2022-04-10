package Stock;

import Exceptions.StockBodyEmptyException;
import Exceptions.UnsuccessfulException;
import Trading.ApiService;
import Trading.ApiServiceData;
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

public class StockApiConnection {
    private final String token;
    private ApiServiceData service;
    public StockApiConnection() {
        service = TradingApplication.instance.serviceData;
        token =  TradingApplication.instance.token;

    }
    public void getStockViaSearch(String query,ContentPackage.ApiAsyncReturn apiAsyncReturn)
            throws StockBodyEmptyException, UnsuccessfulException{
        ContentPackage contentPackage = new ContentPackage();
        service.getStockViaSearch(query,"Bearer " + token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response + " " + response.body());
                if (response.isSuccessful()){
                    if (response.body() != null){

                        try {
                            String val = response.body().string();
                            System.out.println("Convert: " + val);
                            contentPackage.setValue(new StockConverter().convertJSON(val));
                        } catch (IOException e) {
                            contentPackage.setException(e);
                            e.printStackTrace();
                        }
                    }
                    else{
                        contentPackage.setException(new StockBodyEmptyException());

                    }
                }
                else{
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
