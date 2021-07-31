package ru.axout.colorguide.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class FlowerResponse {

    // Аннотация @Expose указывает, что данный член должен быть доступен для сериализации.
    @SerializedName("result")
    @Expose
    private List<Flower> results;

    public FlowerResponse(List<Flower> results) {
        this.results = results;
    }
     public List<Flower> getResults() {
        return results;
     }
}
