package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public interface HisFriendsApi {
    @GET("iyz_index.php")
    Observable<BaseResponse2<MyFriendsResult>> fetchHisFriends(@Query("version") String version,
                                                               @Query("module")String module,
                                                               @Query("view")String view,
                                                               @Query("from")String from,
                                                               @Query("uid")String uid);
}
