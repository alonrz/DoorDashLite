package com.rz.alon.doordashlite.ui;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.rz.alon.doordashlite.R;
import com.rz.alon.doordashlite.utils.GlideApp;

import java.net.URL;

public class CustomBindingAdapter {

    @BindingAdapter("srcFromUrl")
    public static void setImageSrcFromUrl(ImageView imageView, URL url) {
        GlideApp.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.outline_broken_image_black_36)
                .into(imageView);
    }
}
