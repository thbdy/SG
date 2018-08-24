package com.from206.common.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.from206.common.R;


/**
 * 创建人：suyx
 * 类描述：ProgressDialog
 * 日期：2016/11/2
 * 版权所有：
 */

public class ProgressDialog extends Dialog {

    private ImageView mProgress;
    private ProgressBar mProgressLoading;

    public ProgressDialog(Context context) {
        super(context);
        init(context);
    }

    public ProgressDialog(Context context, int theme) {
        super(context, theme);
        init(context);
    }

    protected ProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(false);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent)));
        this.setContentView(R.layout.progress_dialog);
        mProgressLoading = (ProgressBar) findViewById(R.id.progress_loading);
        if (android.os.Build.VERSION.SDK_INT > 22) {//android 6.0替换clip的加载动画
            final Drawable drawable = context.getApplicationContext().getResources().getDrawable(R.drawable.loading_06);
            mProgressLoading.setIndeterminateDrawable(drawable);
        }

//        mProgress = (ImageView) findViewById(R.id.progress);
//        mProgress.setVisibility(View.VISIBLE);
//        mDrawable = new MaterialProgressDrawable(context, mProgress);
//        mDrawable.setColorSchemeColors(context.getResources().getColor(R.color.green5C));
//        int width = context.getResources().getDimensionPixelSize(R.dimen.px_98);
//        mDrawable.updateSizes(width, width, context.getResources().getDimensionPixelSize(R.dimen.px_4));
//        mDrawable.setAlpha(255);
//        mDrawable.setStartEndTrim(0, 1f);
//        mProgress.setImageDrawable(mDrawable);
    }

    @Override
    public void show() {
        super.show();
//        mDrawable.start();

    }

}
