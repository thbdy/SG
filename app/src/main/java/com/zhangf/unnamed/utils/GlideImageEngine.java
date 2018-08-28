package com.zhangf.unnamed.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.maning.imagebrowserlibrary.ImageEngine;

//Glide
public class GlideImageEngine implements ImageEngine {
    private static final String TAG = "GlideImageEngine";
    @Override
    public void loadImage(Context context, String url, ImageView imageView){
            Glide.with(context).load(url).asBitmap().into(imageView);
    }

}