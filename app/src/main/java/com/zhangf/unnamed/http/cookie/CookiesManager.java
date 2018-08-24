package com.zhangf.unnamed.http.cookie;

import com.zhangf.unnamed.App;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/** * 自动管理Cookies */
public class CookiesManager implements CookieJar {
    private static final String TAG = "Cookie";
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
        if(cookies.size() >0 ){
            App.getApp().saveCookie(cookies);
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        if( null != App.getApp().getCookie() && App.getApp().getCookie().size() > 0){
            return  App.getApp().getCookie();
        }else{
            return new ArrayList<Cookie>();
        }
    }
}
