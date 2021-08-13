package ru.axout.colorguide.main;

import androidx.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.axout.colorguide.model.Apis;
import ru.axout.colorguide.model.FlowerApi;
import ru.axout.colorguide.model.FlowerResponse;

// Общение между View и Presenter,
// а так же между Presenter и Model осуществляется через интерфейс MainContract
public class MainPresenter implements MainContract.MainPresenter {

    private final MainContract.MainView view;
    private final FlowerApi flowerApi;

    // в конструкторе Presenter идёт подготовка обращения к Model для получения данных
    public MainPresenter(MainContract.MainView view) {
        this.view = view;
        this.flowerApi = Apis.getFlowerApi();
    }

    // здесь выполняется запрос к серверу и получение данных
    @Override
    public void getAllFlowers() {
        flowerApi.getAllFlowers().enqueue(new Callback<FlowerResponse>() {
            @Override
            public void onResponse(@NonNull Call<FlowerResponse> call, @NonNull Response<FlowerResponse> response) {
                FlowerResponse flowerResponse = response.body();
                // если запрос успешный и данные получены, то передаём эти данные View для их отображения
                if (flowerResponse != null) {
                    view.showAllFlowers(flowerResponse.getResults());
                }
            }

            // если запрос неудачный, то даём указания View выдать сообщение об ошибки
            @Override
            public void onFailure(@NonNull Call<FlowerResponse> call, @NonNull Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }
}
