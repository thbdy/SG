package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.GetAllResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/17
 * Email：zhangfu@ylzinfo.com
 */
public interface GetAllApi {
    @FormUrlEncoded
    @POST("iyz_index.php?module=forumindex&version=1")
    Observable<BaseResponse2<GetAllResult>> fetchGetAll(@Field("fid") String fid, @Field("page")String page);
}
