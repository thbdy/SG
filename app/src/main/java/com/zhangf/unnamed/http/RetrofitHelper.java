package com.zhangf.unnamed.http;


import android.util.Log;

import com.from206.common.utils.CommonUtil;
import com.zhangf.unnamed.App;
import com.zhangf.unnamed.http.api.AddFriendApi;
import com.zhangf.unnamed.http.api.ChatApi;
import com.zhangf.unnamed.http.api.CheckPostApi;
import com.zhangf.unnamed.http.api.GetAllApi;
import com.zhangf.unnamed.http.api.HisFriendsApi;
import com.zhangf.unnamed.http.api.HisReplyApi;
import com.zhangf.unnamed.http.api.HisThreadApi;
import com.zhangf.unnamed.http.api.LoginServiceApi;
import com.zhangf.unnamed.http.api.MyFriendApi;
import com.zhangf.unnamed.http.api.NotificationApi;
import com.zhangf.unnamed.http.api.PrivateLetterApi;
import com.zhangf.unnamed.http.api.ProFileApi;
import com.zhangf.unnamed.http.api.SearchApi;
import com.zhangf.unnamed.http.api.SendMessageApi;
import com.zhangf.unnamed.http.api.ThemeListApi;
import com.zhangf.unnamed.http.api.ThreadInfoApi;
import com.zhangf.unnamed.http.api.TimeCodeApi;
import com.zhangf.unnamed.http.api.UserGoldApi;
import com.zhangf.unnamed.http.api.UserInfoApi;
import com.zhangf.unnamed.http.cookie.CookiesManager;
import com.zhangf.unnamed.http.eventbus.RedirectEvent;
import com.zhangf.unnamed.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 创建人：zhangf
 * 类描述： --
 * 日期：2017/3/14
 * 版权所有：
 */
public class RetrofitHelper {
    private static final String TAG = "RetrofitHelper";
    private static OkHttpClient mOkHttpClient;
    static {
        initOkHttpClient();
    }
    /**
     *登录
     * @return
     */
    public static LoginServiceApi getLoginApi() {
        return createApi2(ApiConstants.BASE_URL,LoginServiceApi.class);
    }
    /**
     *GetAll
     * @return
     */
    public static GetAllApi getAllApi() {
        return createApi2(ApiConstants.BASE_URL2,GetAllApi.class);
    }
    /**
     *获取主题列表
     * @return
     */
    public static ThemeListApi getThemeListApi() {
        return createApi2(ApiConstants.BASE_URL5,ThemeListApi.class);
    }
    /**
     *获取帖子详情
     * @return
     */
    public static ThreadInfoApi getThreadInfoApi() {
        return createApi2(ApiConstants.BASE_URL2,ThreadInfoApi.class);
    }
    /**
     *获取用户信息
     * @return
     */
    public static UserInfoApi getUserInfoApi() {
        return createApi2(ApiConstants.BASE_URL3,UserInfoApi.class);
    }

    /**
     *获取用户金币
     * @return
     */
    public static UserGoldApi getUserGoldApi() {
        return createApi2(ApiConstants.BASE_URL3,UserGoldApi.class);
    }
    /**
     *checkpost
     * @return
     */
    public static CheckPostApi checkPostApi() {
        return createApi2(ApiConstants.BASE_URL2,CheckPostApi.class);
    }
    /**
     *time&code
     * @return
     */
    public static TimeCodeApi TimeCodeApi() {
        return createApi2(ApiConstants.BASE_URL4,TimeCodeApi.class);
    }
    /**
     *我的消息
     * @return
     */
    public static NotificationApi notificationApi() {
        return createApi2(ApiConstants.BASE_URL3,NotificationApi.class);
    }

    /**
     *私信
     * @return
     */
    public static PrivateLetterApi getPrivateLetterApi() {
        return createApi2(ApiConstants.BASE_URL2,PrivateLetterApi.class);
    }
    /**
     *个人主页
     * @return
     */
    public static ProFileApi getProFileApi() {
        return createApi2(ApiConstants.BASE_URL2,ProFileApi.class);
    }
    /**
     *我的好友
     * @return
     */
    public static MyFriendApi getMyFriendsApi() {
        return createApi2(ApiConstants.BASE_URL2,MyFriendApi.class);
    }

    /**
     *添加好友申请
     * @return
     */
    public static AddFriendApi getAddFriendApi() {
        return createApi2(ApiConstants.BASE_URL2,AddFriendApi.class);
    }
    /**
     *TA的好友
     * @return
     */
    public static HisFriendsApi getHisFriendsApi() {
        return createApi2(ApiConstants.BASE_URL2,HisFriendsApi.class);
    }
    /**
     *TA的主题
     * @return
     */
    public static HisThreadApi getHisThreadApi() {
        return createApi2(ApiConstants.BASE_URL2,HisThreadApi.class);
    }
    /**
     *TA的回复
     * @return
     */
    public static HisReplyApi getHisReplyApi() {
        return createApi2(ApiConstants.BASE_URL2,HisReplyApi.class);
    }
    /**
     *聊天信息
     * @return
     */
    public static ChatApi getChatApi() {
        return createApi2(ApiConstants.BASE_URL2,ChatApi.class);
    }

    /**
     *发送私信
     * @return
     */
    public static SendMessageApi getSendMessageApi() {
        return createApi2(ApiConstants.BASE_URL2,SendMessageApi.class);
    }
    /**
     *搜索
     * @return
     */
    public static SearchApi getSearchApi() {
        return createApi(SearchApi.class);
    }




    private static void initOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {
                    //设置Http缓存
                    Cache cache = new Cache(new File(App.getApp()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 10);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(interceptor) //日志
                            .cookieJar(new CookiesManager())
//                            .addInterceptor(header) //添加消息头
//                            .addNetworkInterceptor(new CacheInterceptor()) //缓存
                            .addNetworkInterceptor(new Http302Interceptor())
//                            .addNetworkInterceptor(new StethoInterceptor()) //调试
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
//                            .addInterceptor(new UserAgentInterceptor()) //拦截器
                            .build();
                }
            }
        }
    }
    /**
     * 添加消息头
     */
    private static Interceptor header = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            String token = (String) SPUtils.get(App.getApp(),"token","");
            String apiToken = (String) SPUtils.get(App.getApp(),"apiToken","");
            Request request = chain.request().newBuilder()
                    .addHeader("token",token) //添加消息头
                    .addHeader("apiToken",apiToken) //添加消息头
                    .build();

            return chain.proceed(request);
        }
    };

    private static class Http302Interceptor implements Interceptor{
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            if(response.isRedirect()){
                Log.e("TAG", "intercept: " );
                EventBus.getDefault().post(new RedirectEvent(response.header("location")));
            }
            return response;
        }
    }

    /**
     * 为okhttp添加缓存，这里是考虑到服务器不支持缓存时，从而让okhttp支持缓存
     */
    private static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {

            // 有网络时 设置缓存超时时间1个小时
            int maxAge = 60 * 60;
            // 无网络时，设置超时为1天
            int maxStale = 60 * 60 * 24;
            Request request = chain.request();
            if (CommonUtil.isNetworkAvailable(App.getApp())) {
                //有网络时只从网络获取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            } else {
                //无网络时只从缓存中读取
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            Response response = chain.proceed(request);
            if (CommonUtil.isNetworkAvailable(App.getApp())) {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, max-age=" + maxAge)
                        .build();
            } else {
                response = response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
            return response;
        }
    }
    /**
     * 根据传入的api创建retrofit
     */
    private static <T> T createApi(Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL6)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }
    /**
     * 根据传入的baseUrl，和api创建retrofit
     */
    private static <T> T createApi2(String baseUrl,Class<T> clazz) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(clazz);
    }
}
