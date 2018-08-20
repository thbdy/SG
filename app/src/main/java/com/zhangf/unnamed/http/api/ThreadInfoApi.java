package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/17
 */
public interface ThreadInfoApi {
    @FormUrlEncoded
    @POST("index.php?module=viewthread&version=4")
    Observable<BaseResponse2> fetchThreadInfo(@Field("tid") String tid);
}
