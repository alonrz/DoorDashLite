package com.rz.alon.doordashlite.models;

import java.net.URL;

public class RestaurantModel {
    private int id;
    private String name;
    private String description;
    private URL cover_img_url;
    private String status;
    private int delivery_fee;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public URL getCover_img_url() {
        return cover_img_url;
    }

    public String getStatus() {
        return status;
    }

    public int getDelivery_fee() {
        return delivery_fee;
    }
}
