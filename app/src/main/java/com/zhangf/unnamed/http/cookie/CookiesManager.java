package com.zhangf.unnamed.http.cookie;

import android.util.Log;

import com.zhangf.unnamed.App;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

/** * 自动管理Cookies */
public class CookiesManager implements CookieJar {
    private List<Cookie> cookieStore = new ArrayList<>();
    private static final String TAG = "Cookie";
    @Override
    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//        Log.e(TAG, "saveFromResponse: *****************************");
//        for(int i = 0;i<cookies.size();i++){
//            Log.e(TAG, "saveFromResponse: "+cookies.get(i).name()+"   "+cookies.get(i).value());
//        }
        if(cookies.size() >0 ){
            App.getApp().saveCookie(cookies);
        }
    }

    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
//        Log.e(TAG, "loadForRequest: *****************************");
        Log.e(TAG, "loadForRequest: "+App.getApp().getCookie().size());

        return  App.getApp().getCookie().size() > 0 ? App.getApp().getCookie() : new ArrayList<Cookie>();
    }

//    private final PersistentCookieStore cookieStore = new PersistentCookieStore(App.getApp());

//    @Override
//    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//        if ( null != cookies && cookies.size() > 0) {
//            for (Cookie item : cookies) {
//                Log.e("TAG", "cookie: "+item.name()+"  "+item.value());
////                cookieStore.add(url, item);
//            }
//        }
//    }



//    @Override
//    public List<Cookie> loadForRequest(HttpUrl url) {
//        List<Cookie> cookies = cookieStore.get(url);
//        return cookies;
//    }
}
