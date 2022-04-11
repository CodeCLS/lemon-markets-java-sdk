package Account;

import Exceptions.ApplicationNotInstantiated;
import Exceptions.BodyEmptyException;
import Exceptions.UnsuccessfulException;
import Order.OrderConverter;
import Order.OrderTypes.FutureOrder;
import Tools.DateUtil;
import Trading.ApiService;
import Trading.TradingApplication;
import models.ContentPackage;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class AccountApiConnection {
    private String token;
    private ApiService service;
    public AccountApiConnection() {
        if (TradingApplication.instance == null){
            System.err.println(new ApplicationNotInstantiated().getMessage());
            return;
        }
        service = TradingApplication.instance.service;
        token =  TradingApplication.instance.token;
    }
    public void getAccount(ContentPackage.ApiAsyncReturn apiAsyncReturn)
    {
        ContentPackage contentPackage = new ContentPackage();
        service.getAccount("Bearer " + token).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if (response.isSuccessful()){
                    if (response.body() != null){
                        try {
                            String val = response.body().string();
                            contentPackage.setValue(new AccountConverter().convertJSON(val));
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
