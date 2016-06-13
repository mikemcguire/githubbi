package com.overexposeddesign.githubbi.utility;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class CustomBindings {
    @BindingAdapter("bind:imageUrl")
        public static void loadImage(ImageView imageView, String url) {
            Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

}
