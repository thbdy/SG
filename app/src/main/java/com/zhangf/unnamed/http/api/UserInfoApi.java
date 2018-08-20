package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse3;
import com.zhangf.unnamed.module.main.model.UserInfoResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/17
 */
public interface UserInfoApi {
    //    /**
//     * 获取用户信息
//     * @return
//     */
    @FormUrlEncoded
    @POST("index.php?g=app&m=user&a=getuserinfo")
    Observable<BaseResponse3<UserInfoResult>> fetchUserInfo(@Field("token") String token, @Field("apiToken") String apiToken);
}
