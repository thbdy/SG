package com.zhangf.unnamed.utils;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.maning.imagebrowserlibrary.ImageEngine;

//Glide
public class GlideImageEngine implements ImageEngine {
    private static final String TAG = "GlideImageEngine";
    @Override
    public void loadImage(Context context, String url, ImageView imageView){
        if(url.endsWith(".gif")){
//            Log.e(TAG, "GIF: "+ url);
            Glide.with(context).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
        }else {
            Log.e(TAG, "PNG: "+ url);
            Glide.with(context).load(url).asBitmap().into(imageView);
        }
    }

}