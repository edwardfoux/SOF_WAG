package com.example.user.stackoverflowapiproject.repository;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    public static final String SITE = "site";
    public static final String STACKOVERFLOW = "stackoverflow";

    private Retrofit retrofit = null;
    private DataModel api = null;

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.stackexchange.com")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public DataModel getDataModel() {
        if (api == null) {
            api = getRetrofit().create(DataModel.class);
        }
        return api;
    }
}
