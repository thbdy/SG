package com.zhangf.unnamed.utils;

import android.content.Context;
import android.util.Log;

import com.afollestad.materialdialogs.MaterialDialog;
import com.zhangf.unnamed.R;


/**
 * Created by HKC on 2018/4/26.
 */

public class DialogManager {
    private static final String TAG = "DialogManager";

    private static DialogManager dialogManager;

    public static DialogManager getInstance() {
        if (dialogManager == null) {
            return new DialogManager();
        }
        return dialogManager;
    }

    private  MaterialDialog mDialog;

    //    private Context mContext;
    private Boolean showMinMax = false;

    /**
     * 显示网络请求的对话框
     * @param mContext
     */
    public MaterialDialog showNetWorkDialog(Context mContext) {
        mDialog = new MaterialDialog.Builder(mContext)
                .title(R.string.progress_dialog)
                .content(R.string.please_wait)
                .widgetColor(mContext.getResources().getColor(R.color.colorPrimary))
                .progress(true, 100, showMinMax)
                .show();
        return mDialog;
    }
    /**
     * 显示网络请求的对话框
     * @param mContext
     */
    public MaterialDialog showNetWorkDialog(Context mContext,String content) {
        mDialog = new MaterialDialog.Builder(mContext)
                .title(R.string.progress_dialog)
                .content(content)
                .widgetColor(mContext.getResources().getColor(R.color.colorPrimary))
                .progress(true, 100, showMinMax)
                .show();
        return mDialog;
    }

    /**
     * 显示提示框
     *
     * @param mContext
     */
    public MaterialDialog showTipDialog(Context mContext, String title, String content) {
        mDialog = new MaterialDialog.Builder(mContext)
                .title(title)
                .content(content)
                .widgetColor(mContext.getResources().getColor(R.color.colorPrimary))
                .progress(true, 100, showMinMax)
                .show();
        return mDialog;

    }

    /**
     * 显示普通的对话框
     *
     * @param context
     * @param title
     * @param content
     */
    public MaterialDialog showCommonDialog(Context context, String title, String content, MaterialDialog.SingleButtonCallback listener) {
        mDialog = new MaterialDialog.Builder(context)
                .title(R.string.progress_dialog)
                .content(R.string.please_wait)
                .widgetColor(context.getResources().getColor(R.color.colorPrimary))
                .title(title)
                .content(content)
                .onNegative(listener)
                .negativeText("取消")
                .positiveText("确定")
                .positiveColor(context.getResources().getColor(R.color.colorPrimary))
                .onPositive(listener)
                .show();
        return mDialog;

    }

    /**
     * 显示普通的对话框
     *
     * @param context
     * @param title
     * @param content
     */
    public MaterialDialog showCommonDialog2(Context context, String title, String content) {
        mDialog = new MaterialDialog.Builder(context)
                .title(R.string.progress_dialog)
                .content(R.string.please_wait)
                .widgetColor(context.getResources().getColor(R.color.colorPrimary))
                .title(title)
                .content(content)
                .positiveColor(context.getResources().getColor(R.color.colorPrimary))
                .show();
        return mDialog;

    }


    public void disMissDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            Log.e(TAG, "弹窗消失");
        }

    }

    public void setCoontent(String s) {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.setContent(s);
        }
    }
}
