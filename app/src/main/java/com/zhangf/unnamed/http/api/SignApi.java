package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.module.main.model.SignResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/9/5
 * Email：752323877@qq.com
 */
public interface SignApi {
    @FormUrlEncoded
    @POST("plugin.php?id=dsu_paulsign:sign&operation=qiandao&infloat=0&inajax=1&api=sign")
    Observable<SignResult> fetchSign(@Field("token") String token,
                                     @Field("formhash")String formhash);
}
