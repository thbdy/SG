package com.zhangf.unnamed;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import java.util.ArrayList;
import java.util.List;

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


    public void saveCookie(List<Cookie> cookies) {

        for (int i = 0; i < cookies.size(); i++) {
            for (int k = 0; k < cookieList.size(); k++) {
                if (cookieList.get(k).name().equals(cookies.get(i).name())) {
                    cookieList.remove(k);
                }
            }
        }

        cookieList.addAll(cookies);
        Log.e(TAG, "saveCookie: **********************************************");
        for (int i = 0; i < cookieList.size(); i++) {
            Log.e(TAG, "saveCookie: " + cookieList.get(i).name() + "   " + cookieList.get(i).value());
        }
    }

    public List<Cookie> getCookie() {
        return cookieList;
    }


    private void initSmartRefreshLayout() {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                ClassicsHeader header = new ClassicsHeader(context);
//                layout.setHeaderHeight(76);
//                header.setAccentColor(context.getResources().getColor(R.color.color_686873));//设置强调颜色
//                header.setPrimaryColor(context.getResources().getColor(R.color.color_eeeeee));//设置主题颜色
//                header.setTextSizeTitle(12);//设置标题文字大小（sp单位）
//                header.setEnableLastTime(false);//是否显示时间
//                header.setFinishDuration(0);//设置刷新完成显示的停留时间
//                header.setDrawableSize(21);//同时设置箭头和图片的大小（dp单位）
////              header.setDrawableArrowSize(21);//设置箭头的大小（dp单位）
////              header.setDrawableProgressSize(21);//设置图片的大小（dp单位）
//                header.setDrawableMarginRight(10);//设置图片和箭头和文字的间距（dp单位）
//                header.setArrowResource(R.drawable.icon_pull);//设置箭头资源
//                header.setProgressResource(R.drawable.list_loading);
//                header.setSpinnerStyle(SpinnerStyle.Translate);//设置状态（不支持：MatchLayout）
                return header;//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @NonNull
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                ClassicsFooter footer = new ClassicsFooter(context);
//                layout.setFooterHeight(70);
//                footer.setAccentColor(context.getResources().getColor(R.color.color_686873));//设置强调颜色
//                footer.setPrimaryColor(context.getResources().getColor(R.color.color_eeeeee));//设置主题颜色
//                footer.setTextSizeTitle(20);//设置标题文字大小（sp单位）
//                footer.setFinishDuration(0);//设置刷新完成显示的停留时间
//                footer.setDrawableSize(21);//同时设置箭头和图片的大小（dp单位）
//                footer.setDrawableMarginRight(10);//同上-像素单位
//                footer.setProgressResource(R.drawable.list_loading);//设置图片资源
//                footer.setSpinnerStyle(SpinnerStyle.Translate);//设置状态（不支持：MatchLayout）
                return footer;
            }
        });
    }
}
