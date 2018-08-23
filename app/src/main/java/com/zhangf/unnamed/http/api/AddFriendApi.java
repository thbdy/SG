package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.AddFriendResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public interface AddFriendApi {
    @FormUrlEncoded
    @POST("iyz_index.php?iyzmobile=1&module=addfriend&version=4")
    Observable<BaseResponse2<AddFriendResult>> fetchMyFriends(@Field("uid") String uid,
                                                              @Field("note") String note,
                                                              @Field("formhash") String formhash);
}
