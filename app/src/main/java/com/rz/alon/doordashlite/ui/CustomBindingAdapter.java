package com.rz.alon.doordashlite.ui;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;
import com.rz.alon.doordashlite.R;
import com.rz.alon.doordashlite.utils.GlideApp;

import java.net.URI;
import java.net.URISyntaxException;
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
