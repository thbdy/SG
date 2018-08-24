package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.module.main.model.SendMessageResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public interface SendMessageApi {
    @FormUrlEncoded
    @POST("index.php?mobile=no&version=4&module=sendpm&pmsubmit=yes&charset=utf-8")
    Observable<SendMessageResult> fetchSendMessage(@Field("touid") String touid,
                                                                  @Field("formhash") String formhash,
                                                                  @Field("message") String message);
}
