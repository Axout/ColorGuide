package ru.axout.colorguide.model;

import retrofit2.Call;
import retrofit2.http.GET;

// В данном интерфейсе задаются команды-запросы для сервера.
public interface FlowerApi {
    @GET("flowers")
    Call<FlowerResponse> getAllFlowers();
}
