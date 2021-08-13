package ru.axout.colorguide.main;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.axout.colorguide.R;
import ru.axout.colorguide.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView {

    RecyclerView recyclerView;
    FlowerAdapter flowerAdapter;
    MainContract.MainPresenter presenter;
    ArrayList<Flower> flowerArrayList = new ArrayList<Flower>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_flowers);

        flowerAdapter = new FlowerAdapter(this, flowerArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(flowerAdapter);

        // запрашиваем данные у модели, но через Presenter
        // создавая объект presenter, мы в конструкторе делаем запрос к серверу
        presenter = new MainPresenter(this);
        presenter.getAllFlowers();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAllFlowers(List<Flower> flowers) {
        flowerAdapter.setFlowers(flowers);
    }
}