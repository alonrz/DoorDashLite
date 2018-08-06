package com.rz.alon.doordashlite.ui.restaurantList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.rz.alon.doordashlite.R;
import com.rz.alon.doordashlite.databinding.ActivityDiscoverBinding;
import com.rz.alon.doordashlite.models.RestaurantModel;
import com.rz.alon.doordashlite.presenters.RestaurantListPresenter;
import com.rz.alon.doordashlite.presenters.Contracts;

import java.util.List;

public class RestaurantListActivity extends AppCompatActivity implements Contracts.RestaurantListView {

    private final String TAG = "RestaurantListActivity";
    private ActivityDiscoverBinding mBinding;
    private RestaurantListAdapter mAdapter;
    private RestaurantListPresenter restaurantListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantListPresenter = new RestaurantListPresenter();
        restaurantListPresenter.bind(this);
        mAdapter = new RestaurantListAdapter(null);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_discover);
        mBinding.rvRestaurants.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvRestaurants.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        mBinding.rvRestaurants.setAdapter(mAdapter);
        restaurantListPresenter.doGetRestaurantList(
                getString(R.string.base_url),
                getString(R.string.door_dash_lat),
                getString(R.string.door_dash_lng),
                getResources().getInteger(R.integer.door_dash_offset),
                getResources().getInteger(R.integer.door_dash_limit)
        );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        restaurantListPresenter.unbind();
    }

    @Override
    public void updateRestaurantListUi(List<RestaurantModel> list) {
        mBinding.tvErrorMessage.setVisibility(View.GONE);
        mBinding.rvRestaurants.setVisibility(View.VISIBLE);
        if (mAdapter == null) {
            mAdapter = new RestaurantListAdapter(list);
        } else {
            mAdapter.updateList(list);
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showErrorUpdatingRestaurantList() {
        mBinding.rvRestaurants.setVisibility(View.GONE);
        mBinding.tvErrorMessage.setVisibility(View.VISIBLE);
    }
}
