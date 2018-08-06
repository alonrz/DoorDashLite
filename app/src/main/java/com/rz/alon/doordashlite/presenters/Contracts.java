package com.rz.alon.doordashlite.presenters;

import com.rz.alon.doordashlite.models.RestaurantModel;

import java.util.List;

public interface Contracts {
    interface RestaurantListAgent {
        void doGetRestaurantList(String baseUrl, String lat, String lng, int offset, int limit);
    }

    interface RestaurantListView {
        void updateRestaurantListUi(List<RestaurantModel> list);

        void showErrorUpdatingRestaurantList();
    }
}
