package com.zhangf.unnamed.injector.module;


import com.zhangf.unnamed.http.IConverJsonFactory;
import com.zhangf.unnamed.http.NetService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

@Module
public class NetServiceModule {
    private String mBaseUrl;

    public NetServiceModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor();
    }

    @Singleton
    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder provideOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder, HttpLoggingInterceptor loggingInterceptor) {
        //设置超时
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);
//        builder.addInterceptor(new Interceptor() {
//            @Override
//            public Response intercept(Chain chain) throws IOException {
//                Request originalRequest = chain.request();
////                if (DataManager.getUserDbHandler().isUserValid()) {
////                    Request newRequest = originalRequest.newBuilder().header("token", DataManager.getUserDbHandler().getRecentUserInfo().getToken()).build();
////                    return chain.proceed(newRequest);
////                }
//                return chain.proceed(originalRequest);
//            }
//        });
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }


    protected Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .addConverterFactory(IConverJsonFactory.create())
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideNetRetrofit(Retrofit.Builder builder, OkHttpClient client) {
        return createRetrofit(builder, client, mBaseUrl);
    }


    @Singleton
    @Provides
    NetService provideNetService(Retrofit retrofit) {
        return retrofit.create(NetService.class);
    }

}
