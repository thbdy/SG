package com.zhangf.unnamed.http.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/17
 */
public interface TimeCodeApi {
    @GET("uc.php")
    Observable<String> fetchTimeCode(@Query("time") String time, @Query("code") String code);
}
