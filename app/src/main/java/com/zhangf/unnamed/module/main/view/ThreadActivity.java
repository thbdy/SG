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
import android.widget.EditText;
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
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Cookie;

public class ThreadActivity extends BaseActivity<ThreadPresenterImpl> implements ThreadPresenter.View {

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.web_view)
    WebView webView;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private String mTid;
    private String URL = "http://bbs.sgamer.com/wap/post.php?tid=";
    private String formhash;
//    13814643
//    http://bbs.sgamer.com/forum.php?mod=post&action=reply&fid=283&tid=13829211&extra=page%3D1&replysubmit=yes&infloat=yes&handlekey=fastpost&inajax=1
//    https://bbs.sgamer.com/api/mobile/iyz_index.php?module=sendreply&version=1&replysubmit=yes&infloat=yes&handlekey=fastpost
//    message: 就跟去年IG和OG在野区中路和塔的护甲改版以后就菜了一样。。。冰娃就是恶心你，你有什么办法
//    posttime: 1535341553
//    formhash: 461eab3d
//    usesig: 1
//    subject:

    @Override
    protected void initData() {
        mPresenter.fetchCheckPost();
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
        formhash = (String) SPUtils.get(mContext, "formhash", "");
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
    public void showReply(String result) {
        etContent.setText("");
        ToastUtil.showToast(mContext,"发布成功");

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

    @OnClick({R.id.iv_back, R.id.btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_send:
                String content = etContent.getText().toString().trim();

                String time1 = String.valueOf(System.currentTimeMillis());
                String time = time1.substring(0,time1.length()-3);

                mPresenter.fetchReply("post",
                        "reply",
                        "283",
                        mTid,
                        "page=1",
                        "yes",
                        "yes",
                        "fastpost",
                        "1",
                        content,
                        time,
                        formhash,
                        "1",
                        "");
                break;
        }
    }
}
