package Quotes;

import Exceptions.ApplicationNotInstantiated;
import Exceptions.BodyEmptyException;
import Exceptions.UnsuccessfulException;
import Stock.StockConverter;
import Trading.ApiServiceData;
import Trading.TradingApplication;
import models.ContentPackage;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

public class QuoteApiConnection {
    private ApiServiceData service = null;
    private String token = null;

    public QuoteApiConnection() {
        if (TradingApplication.instance == null){
            System.err.println(new ApplicationNotInstantiated().getMessage());
            return;
        }
        service = TradingApplication.instance.serviceData;
        token =  TradingApplication.instance.token;
    }

    public void getLatestQuotes(String isin, String mic, ContentPackage.ApiAsyncReturn apiAsyncReturn) {
        ContentPackage contentPackage = new ContentPackage();
        service.getLatestQuotes(isin,mic,"false","Bearer " + token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                System.out.println(response + " " + response.body());
                if (response.isSuccessful()){
                    if (response.body() != null){

                        try {
                            String val = response.body().string();
                            System.out.println("Convert: " + val);
                            contentPackage.setValue(new QuoteConverter().convertJSON(val));
                        } catch (IOException e) {
                            contentPackage.setException(e);
                            e.printStackTrace();
                        }
                    }
                    else{
                        contentPackage.setException(new BodyEmptyException());

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
