package com.zhangf.unnamed.utils;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JsInteraction {
    private Context mContext;

    public JsInteraction(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * 回复评论
     * @param message {"repquote":54569156,"datatype":"reply"}
     */
    @JavascriptInterface
    public void onSumResult_reply(String message) {
        Log.e("TAG", "onSumResult_reply: "+message);
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    /**
     * 举报
     * @param message  {"rid":54569156,"fid":44,"uid":8971583,"rtype":"post","datatype":"report"}
     */
    @JavascriptInterface
    public void onSumResult_report(String message) {
        Log.e("TAG", "onSumResult_reply: "+message);
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }
    @JavascriptInterface
    public void onSumResult(String message) {
        Log.e("TAG", "onSumResult_reply: "+message);
    }
}
