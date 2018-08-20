package com.zhangf.unnamed.http.api;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/20
 * Email：752323877@qq.com
 */
public interface NotificationApi {
    @FormUrlEncoded
    @POST("index.php?g=app&m=extra&a=notification")
    Observable<String> fetchNotification(@Field("token") String token, @Field("apiToken")String apiToken, @Field("type")String type);
}
