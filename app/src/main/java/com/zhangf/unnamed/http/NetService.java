package com.zhangf.unnamed.http;


import com.zhangf.unnamed.bean.request.LoginRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface NetService {

    public static final String BASE_URL = "https://passport1.sgamer.com/index.php";

    //登录
    @POST("")
    Call<ResponseBody> fetchLoginInfo(@Body LoginRequest request);
}
