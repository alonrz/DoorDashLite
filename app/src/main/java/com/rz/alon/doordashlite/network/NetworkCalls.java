package com.rz.alon.doordashlite.network;

import com.rz.alon.doordashlite.models.RestaurantModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkCalls {

    private static String TAG = "NetworkCalls";
    private static String BASE_URL = "https://api.doordash.com/v2/";

    /**
     * No need to create an object
     */
    private NetworkCalls() {
    }

    /**
     * This can be called on the main thread. The method will trigger Retrofit to enqueue on
     * another thread
     */
    public static void getRestaurantsList(String lat, String lng, int offset, int limit,
                                          Callback<List<RestaurantModel>> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestaurantClient client = retrofit.create(RestaurantClient.class);
        Call<List<RestaurantModel>> call = client.getRestaurants(lat, lng, offset, limit);
        call.enqueue(callback);
    }
}
