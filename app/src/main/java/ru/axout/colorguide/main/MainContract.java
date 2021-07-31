package ru.axout.colorguide.main;

import ru.axout.colorguide.model.Flower;

import java.util.List;

public interface MainContract {

    interface MainView {
        void showMessage(String message);
        void showAllFlowers(List<Flower> flowers);
    }

    interface MainPresenter {
        void getAllFlowers();
    }
}
