package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/7
 */
public interface LoginServiceApi {
        //登录
    @FormUrlEncoded
    @POST("index.php?m=App&a=login")
    Observable<BaseResponse<String>> fetchLoginInfo(@Field("type") String type, @Field("apiToken")String token, @Field("username")String username,
                                                    @Field("password")String password);
}
