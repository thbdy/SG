package com.zhangf.unnamed.module.main.view;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.CheckPostResult;
import com.zhangf.unnamed.module.main.presenter.ThreadPresenter;
import com.zhangf.unnamed.module.main.presenter.ThreadPresenterImpl;
import com.zhangf.unnamed.utils.JsInteraction;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThreadActivity extends BaseActivity<ThreadPresenterImpl> implements ThreadPresenter.View {
    @BindView(R.id.web_view)
    WebView webView;
    private String mTid;
    private String URL = "http://bbs.sgamer.com/wap/post.php?tid=";

    @Override
    protected void initData() {
        mPresenter.fetchCheckPost();
        mPresenter.fetchThreadInfo(mTid);

    }

    @Override
    protected ThreadPresenterImpl initPresenter() {
        return new ThreadPresenterImpl(this);
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_thread;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mTid = getIntent().getStringExtra("tid");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.addJavascriptInterface(new JsInteraction(this), "android");
        webView.loadUrl(URL+mTid);
        Log.e("TAG", "initView: "+URL+mTid);
    }




    @Override
    public void showThreadInfo(BaseResponse2 result) {

    }

    @Override
    public void showCheckPost(BaseResponse2<CheckPostResult> result) {


//        CookieSyncManager.createInstance(this);
//        CookieManager cookieManager = CookieManager.getInstance();
//        String value = entry.getKey() + "=" + entry.getValue();// 键值对拼接成 value
//        cookieManager.setCookie("http://bbs.sgamer.com/", value);// 设置 Cookie

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initToolBar(Bundle savedInstanceState) {

    }
}
