package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse3;
import com.zhangf.unnamed.module.main.model.UserGoldResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/17
 * Email：zhangfu@ylzinfo.com
 */
public interface UserGoldApi {
    //    index.php?g=app&m=user&a=getusergold
    @FormUrlEncoded
    @POST("index.php?g=app&m=user&a=getusergold")
    Observable<BaseResponse3<UserGoldResult>> fetchUserGold(@Field("token") String token, @Field("apiToken") String apiToken);
}
