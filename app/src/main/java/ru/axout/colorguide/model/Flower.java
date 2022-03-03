package ru.axout.colorguide.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Flower implements Serializable {

    @SerializedName("flower_id")
    @Expose
    private long flower_id;

    @SerializedName("flower_img")
    @Expose
    private String flower_img;

    @SerializedName("flower_rus")
    @Expose
    private String flower_rus;

    @SerializedName("flower_lat")
    @Expose
    private String flower_lat;

    @SerializedName("flower_desc")
    @Expose
    private String flower_desc;

    public long getFlower_id() {
        return flower_id;
    }

    public String getFlower_img() {
        return flower_img;
    }

    public String getFlower_rus() {
        return flower_rus;
    }

    public String getFlower_lat() {
        return flower_lat;
    }

    public String getFlower_desc() {
        return flower_desc;
    }

    public void setFlower_id(long flower_id) {
        this.flower_id = flower_id;
    }

    public void setFlower_img(String flower_img) {
        this.flower_img = flower_img;
    }

    public void setFlower_rus(String flower_rus) {
        this.flower_rus = flower_rus;
    }

    public void setFlower_lat(String flower_lat) {
        this.flower_lat = flower_lat;
    }

    public void setFlower_desc(String flower_desc) {
        this.flower_desc = flower_desc;
    }
}
