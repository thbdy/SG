package com.zhangf.unnamed.http.api;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/27
 * Email：752323877@qq.com
 */
public interface ReplyApi {
    @FormUrlEncoded
    @POST("forum.php")
    Observable<String> fetchReply(@Query("mod") String mod,
                                        @Query("action")String action,
                                        @Query("fid")String fid,
                                        @Query("tid")String tid,
                                        @Query("extra")String extra,
                                        @Query("replysubmit")String replysubmit,
                                        @Query("infloat")String infloat,
                                        @Query("handlekey")String handlekey,
                                        @Query("inajax")String inajax,
                                        @Field("message") String message,
                                        @Field("posttime") String posttime,
                                        @Field("formhash") String formhash,
                                        @Field("usesig") String usesig,
                                        @Field("subject") String subject);



}
