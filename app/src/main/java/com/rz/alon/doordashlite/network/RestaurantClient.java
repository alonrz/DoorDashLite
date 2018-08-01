package com.rz.alon.doordashlite.network;

import com.rz.alon.doordashlite.models.RestaurantModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestaurantClient {

    @GET("restaurant/")
    Call<List<RestaurantModel>> getRestaurants(@Query("lat") String lat,
                                               @Query("lng") String lng,
                                               @Query("offset") int offset,
                                               @Query("limit") int limit);
}
