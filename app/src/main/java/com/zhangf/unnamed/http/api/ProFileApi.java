package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.ProFileResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public interface ProFileApi {
    @GET("iyz_index.php")
    Observable<BaseResponse2<ProFileResult>> fetchProFile(@Query("uid") String uid, @Query("module") String module, @Query("version")String version);

}
