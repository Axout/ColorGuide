package ru.axout.colorguide.main;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.axout.colorguide.model.Apis;
import ru.axout.colorguide.model.FlowerApi;
import ru.axout.colorguide.model.FlowerResponse;

public class MainPresenter implements MainContract.MainPresenter{

    private final MainContract.MainView view;
    private final FlowerApi flowerApi;

    public MainPresenter(MainContract.MainView view) {
        this.view = view;
        this.flowerApi = Apis.getFlowerApi();
    }

    @Override
    public void getAllFlowers() {
        flowerApi.getAllFlowers().enqueue(new Callback<FlowerResponse>() {
            @Override
            public void onResponse(@NonNull Call<FlowerResponse> call, @NonNull Response<FlowerResponse> response) {
                FlowerResponse flowerResponse = response.body();
                if (flowerResponse != null) {
                    view.showAllFlowers(flowerResponse.getResults());
                }
            }

            @Override
            public void onFailure(@NonNull Call<FlowerResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }
}
