package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.CheckPostResult;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by 75232 on 2018/8/17
 * Email：zhangfu@ylzinfo.com
 */
public interface CheckPostApi {
        /**
     * 获取权限
     * @return
     */
    @GET("iyz_index.php?version=1&module=checkpost")
    Observable<BaseResponse2<CheckPostResult>> fetchCheckPost();
}
