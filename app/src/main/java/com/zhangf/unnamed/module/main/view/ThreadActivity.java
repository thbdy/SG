package com.zhangf.unnamed.module.main.view;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.App;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.CheckPostResult;
import com.zhangf.unnamed.module.main.presenter.ThreadPresenter;
import com.zhangf.unnamed.module.main.presenter.ThreadPresenterImpl;
import com.zhangf.unnamed.utils.JsInteraction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Cookie;

public class ThreadActivity extends BaseActivity<ThreadPresenterImpl> implements ThreadPresenter.View {


    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private String mTid;
    private String URL = "http://bbs.sgamer.com/wap/post.php?tid=";

    @Override
    protected void initData() {
//        mPresenter.fetchCheckPost();
//        mPresenter.fetchThreadInfo(mTid);

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

        setWebviewCookie(); //设置cookie
        mTid = getIntent().getStringExtra("tid");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setBlockNetworkImage(false);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {

                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        webView.addJavascriptInterface(new JsInteraction(this), "android");
        webView.loadUrl(URL + mTid);
        Log.e("TAG", "initView: " + URL + mTid);
    }

    /**
     * 设置cookie
     */
    private void setWebviewCookie() {

        //得到Cookie对象
//        String cookie = SharedPreferencesUtils.getStr(this, "cookie");
//        Log.d("tag", "setWebviewCookie: "+cookie);
        CookieSyncManager.createInstance(this);
        //得到CookieManager对象
        CookieManager cookieManager = CookieManager.getInstance();
        //移除当前的消息
        cookieManager.removeAllCookie();
        //设置支持cookie
        cookieManager.setAcceptCookie(true);
        //进行设置cookie 参数一：登录接口的网址  参数二： 获取的cookie
        for (Cookie cookie : App.getApp().getCookie()) {
            cookieManager.setCookie("http://bbs.sgamer.com/wap/post.php", cookie.name() + "=" + cookie.value() + ";domain=" + "bbs.sgamer.com" + ";path=/");
        }
        //进行开始同步操作
        CookieSyncManager.getInstance().sync();
    }


    @Override
    public void showThreadInfo(BaseResponse2 result) {

    }

    @Override
    public void showCheckPost(BaseResponse2<CheckPostResult> result) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initToolBar(Bundle savedInstanceState) {
        ivBack.setVisibility(View.VISIBLE);
        tvTitle.setText("内容");

    }

    @OnClick({R.id.iv_back,R.id.btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_send:

                break;
        }
    }
}
