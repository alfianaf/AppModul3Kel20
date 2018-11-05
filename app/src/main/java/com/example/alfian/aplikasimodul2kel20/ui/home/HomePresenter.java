package com.example.alfian.aplikasimodul2kel20.ui.home;

import android.util.Log;

import com.example.alfian.aplikasimodul2kel20.data.network.RetrofitClient;
import com.example.alfian.aplikasimodul2kel20.data.model.DataCar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter {

    private HomeView homeView;

    public HomePresenter (HomeView homeView){
        this.homeView = homeView;
    }

    public void getAllCar(){
        final String tag = "Home-getAllCar";
        RetrofitClient.getInstance()
                .getApi()
                .getAllCar()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.isSuccessful()){
                            JsonObject body = response.body();
                            JsonArray array = body.get("result").getAsJsonArray();  //Json array nya namanya 'result'
                            Type type = new TypeToken<List<DataCar>>(){}.getType();
                            List<DataCar> dataCars = new Gson().fromJson(array, type);
                            homeView.successShowCar(dataCars);              //interface yg nghubungin presenter sama activity
                            Log.e(tag, response.body().toString());         //buat debugging
                        } else {
                            homeView.failedShowCar("Maaf terjadi kesalahan");  //masalah dengan Jsonnya / datanya
                            Log.e(tag, response.errorBody().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) { //masalah dengan koneksi internet / servernya
                        homeView.failedShowCar("Maaf terjadi kesalahan");
                        Log.d(tag, t.getMessage().toString());
                    }
                });
    }
}
