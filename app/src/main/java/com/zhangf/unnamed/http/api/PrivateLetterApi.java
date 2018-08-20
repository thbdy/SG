package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/20
 * Email：752323877@qq.com
 */
public interface PrivateLetterApi {
    @GET("iyz_index.php")
    Observable<BaseResponse2<PrivateLetterResult>> fetchPrivateLetter(@Query("version") String version,
                                                                      @Query("module")String module,
                                                                      @Query("charset")String charset,
                                                                      @Query("formhash")String formhash);
}
