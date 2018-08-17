package com.zhangf.unnamed.http.api;

import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.ThemeListResult;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 75232 on 2018/8/17
 * Email：zhangfu@ylzinfo.com
 */
public interface ThemeListApi {
    @POST("iyz_index.php?module=forumdisplay&version=1")
    Observable<BaseResponse2<ThemeListResult>> fetchThemeList(@Query("fid") String fid, @Query("page")String page);
}
