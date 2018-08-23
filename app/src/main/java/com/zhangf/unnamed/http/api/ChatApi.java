package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.ChatResult;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public interface ChatApi {
    //https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=mypm&charset=utf-8&subop=view&formhash=168f8289&touid=8793833
    @GET("iyz_index.php")
    Observable<BaseResponse2<ChatResult>> fetchChat(@Query("version") String iyzmobile,
                                                    @Query("module")String module,
                                                    @Query("charset")String version,
                                                    @Query("subop")String type,
                                                    @Query("formhash")String uid,
                                                    @Query("touid")String touid);
}
