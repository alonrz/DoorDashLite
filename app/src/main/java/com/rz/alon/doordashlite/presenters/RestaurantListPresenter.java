package com.rz.alon.doordashlite.presenters;

import android.util.Log;

import com.rz.alon.doordashlite.models.RestaurantModel;
import com.rz.alon.doordashlite.network.RestaurantClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestaurantListPresenter implements Contracts.RestaurantListAgent {

    private static String TAG = "RestaurantListPresenter";
    private Contracts.RestaurantListView mRestaurantListView;

    @Override
    public void doGetRestaurantList(String baseUrl, String lat, String lng, int offset, int limit) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestaurantClient client = retrofit.create(RestaurantClient.class);
        Call<List<RestaurantModel>> call = client.getRestaurants(lat, lng, offset, limit);
        call.enqueue(
                new Callback<List<RestaurantModel>>() {
                    @Override
                    public void onResponse(Call<List<RestaurantModel>> call, Response<List<RestaurantModel>> response) {
                        Log.d(TAG, response.message());
                        if (mRestaurantListView != null) {
                            mRestaurantListView.updateRestaurantListUi(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<RestaurantModel>> call, Throwable t) {
                        Log.e(TAG, t.getMessage());
                        if (mRestaurantListView != null) {
                            mRestaurantListView.showErrorUpdatingRestaurantList();
                        }
                    }
                }
        );
    }

    public void bind(Contracts.RestaurantListView view) {
        mRestaurantListView = view;
    }

    public void unbind() {
        mRestaurantListView = null;
    }
}
