package com.zhangf.unnamed.http.api;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/27
 * Email：752323877@qq.com
 */
public interface PostNewApi {
    @GET("forum.php")
    Observable<String> fetchPostNew(@Query("mod") String mod,
                                  @Query("tid") String tid,
                                  @Query("viewpid") String pid,
                                  @Query("from") String from,
                                  @Query("inajax") String inajax,
                                  @Query("ajaxtarget") String ajaxtarget);



}
