package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by 75232 on 2018/8/24
 * Email：752323877@qq.com
 */
public interface SearchApi {
//    formhash: 886816e8
//    srchtxt: sss
//    searchsubmit: yes
//    http://bbs.sgamer.com/search.php?mod=forum
@FormUrlEncoded
@POST("search.php?mod=forum")
Observable<BaseResponse> fetchSearch(@Field("formhash") String formhash, @Field("srchtxt")String srchtxt, @Field("searchsubmit")String searchsubmit);

}
