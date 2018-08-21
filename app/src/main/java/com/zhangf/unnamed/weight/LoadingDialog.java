package com.zhangf.unnamed.weight;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zhangf.unnamed.R;


/**
 * Created on 2017/12/13.
 */

public class LoadingDialog extends Dialog {
    private Context mContext;
    private AnimationDrawable frameAnim;
    private ImageView imageView;

    public LoadingDialog(@NonNull Context context) {
        super(context, R.style.CommonDialogTheme);
        mContext = context;
        init(context);
    }
    private void init(Context context){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_loading,null);
        imageView = (ImageView) view.findViewById(R.id.loading_img);
        // 通过逐帧动画的资源文件获得AnimationDrawable示例
        frameAnim=(AnimationDrawable) mContext.getResources().getDrawable(R.drawable.loading_anim);
        // 把AnimationDrawable设置为ImageView的背景
        imageView.setBackgroundDrawable(frameAnim);
//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.loading_dialog_anim);
//        imageView.startAnimation(animation);
        setCanceledOnTouchOutside(true);
        setContentView(view);
        setCancelable(true);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);


    }

    @Override
    public void show() {
        super.show();
        frameAnim.start();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        frameAnim.stop();
    }
}
