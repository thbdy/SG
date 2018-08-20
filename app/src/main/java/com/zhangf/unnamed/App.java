package com.zhangf.unnamed;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.zhangf.unnamed.utils.SaveCookiesUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.Cookie;

public class App extends Application {
    private static final String TAG = "App";
    private static App app;
    private static List<Cookie> cookieList = new ArrayList<>();

    public static App getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        initSmartRefreshLayout();
    }


    /**
     * 存储cookie
     * @param cookies
     */
    public void saveCookie(List<Cookie> cookies) {
        for (int i = 0; i < cookies.size(); i++) {
            for (int k = 0; k < cookieList.size(); k++) {
                if (cookieList.get(k).name().equals(cookies.get(i).name())) {
                    cookieList.remove(k);
                }
            }
        }
        cookieList.addAll(cookies);
        for(Cookie cookie : cookieList){
            SaveCookiesUtils.put(this,cookie.name(), new Gson().toJson(cookie));
        }
    }

    /**
     * 获取cookie
     * @return
     */
    public List<Cookie> getCookie() {
        if(null == cookieList || cookieList.size() <= 0){
            Map<String,?> cookies =  SaveCookiesUtils.getAll(this);
            for (Object o : cookies.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                String val = (String) entry.getValue();
                cookieList.add(new Gson().fromJson(val,Cookie.class));
            }
        }
        return cookieList;
    }


    private void initSmartRefreshLayout() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                ClassicsHeader header = new ClassicsHeader(context);
                return header;//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                ClassicsFooter footer = new ClassicsFooter(context);
                return footer;
            }
        });
    }
}
