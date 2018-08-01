package com.rz.alon.doordashlite.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rz.alon.doordashlite.R;
import com.rz.alon.doordashlite.models.RestaurantModel;

import java.net.URISyntaxException;
import java.util.List;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantMinimizedViewHolder> {

    private List<RestaurantModel> mRestaurants;

    public RestaurantListAdapter(List<RestaurantModel> restaurants) {
        mRestaurants = restaurants;
    }

    public void updateList(List<RestaurantModel> restaurants) {
        mRestaurants = restaurants;
        notifyDataSetChanged();
    }

    @Override
    public RestaurantMinimizedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return RestaurantMinimizedViewHolder.inflate(inflater, R.layout.minimized_restaurant, parent, false);
    }

    @Override
    public void onBindViewHolder(RestaurantMinimizedViewHolder holder, int position) {
        try {
            holder.bind(mRestaurants.get(position));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onViewRecycled(@NonNull RestaurantMinimizedViewHolder holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return mRestaurants != null ? mRestaurants.size() : 0;
    }
}
