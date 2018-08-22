package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public interface MyFriendApi {
    @FormUrlEncoded
    @POST("iyz_index.php?version=1&module=friend&charset=utf-8")
    Observable<BaseResponse2<MyFriendsResult>> fetchMyFriends(@Field("formhash") String formhash);
}
