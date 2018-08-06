package com.rz.alon.doordashlite.ui.restaurantList;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.rz.alon.doordashlite.databinding.MinimizedRestaurantBinding;
import com.rz.alon.doordashlite.models.RestaurantModel;

import java.net.URISyntaxException;

class RestaurantMinimizedViewHolder extends RecyclerView.ViewHolder {

    private MinimizedRestaurantBinding mBinding;

    public RestaurantMinimizedViewHolder(MinimizedRestaurantBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public static RestaurantMinimizedViewHolder inflate(LayoutInflater inflater, int layout, ViewGroup parent, boolean attachToParent) {
        MinimizedRestaurantBinding binding = DataBindingUtil.inflate(inflater, layout, parent, attachToParent);
        return new RestaurantMinimizedViewHolder(binding);
    }

    public void bind(final RestaurantModel restaurantModel) throws URISyntaxException {
        mBinding.setVariable(BR.viewModel, restaurantModel);
        mBinding.executePendingBindings();
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mBinding.getRoot().getContext(), restaurantModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void unbind() {
        mBinding.ivCoverImgUrl.setImageDrawable(null);
        mBinding.getRoot().setOnClickListener(null);
    }
}
