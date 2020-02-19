package com.example.mobileapptask.data.retrofit;

import com.example.mobileapptask.data.models.MainModel;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RetrofitClient {

    @GET("home")
    Single<MainModel> getData();
}
