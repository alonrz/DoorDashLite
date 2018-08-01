package com.rz.alon.doordashlite.ui;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.rz.alon.doordashlite.R;
import com.rz.alon.doordashlite.databinding.ActivityDiscoverBinding;
import com.rz.alon.doordashlite.models.RestaurantModel;
import com.rz.alon.doordashlite.network.NetworkCalls;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestaurantListActivity extends AppCompatActivity {

    private final String TAG = "RestaurantListActivity";
    private ActivityDiscoverBinding mBinding;
    private RestaurantListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_discover);
        mAdapter = new RestaurantListAdapter(null);
        mBinding.rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvRestaurants.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mBinding.rvRestaurants.setAdapter(mAdapter);

        doGetRestaurantList();
    }

    private void doGetRestaurantList() {
        Resources resources = getResources();
        NetworkCalls.getRestaurantsList(
                getString(R.string.door_dash_lat), getString(R.string.door_dash_lng),
                resources.getInteger(R.integer.door_dash_offset),
                resources.getInteger(R.integer.door_dash_limit),
                new Callback<List<RestaurantModel>>() {
                    @Override
                    public void onResponse(Call<List<RestaurantModel>> call, Response<List<RestaurantModel>> response) {
                        Log.d(TAG, response.message());
                        mAdapter.updateList(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<RestaurantModel>> call, Throwable t) {
                        Log.e(TAG, t.getMessage());
                    }
                });
    }
}
