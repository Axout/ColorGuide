package ru.axout.colorguide.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apis {

    private static final String BASE_URL = "http://192.168.1.153/flowers/public/";

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static FlowerApi getFlowerApi() {
        return getRetrofitInstance().create(FlowerApi.class);
    }
}
