package com.zhangf.unnamed.utils;

public class TokenUtil {

    public static  final String TOKEN = "f73bf1a9039aa25284346175cb9fc285";

    /**
     * 获取实时token
     * @return
     */
    public static String getToken(){
        String time = String.valueOf(System.currentTimeMillis());

        return time.substring(0,3)+
                TOKEN.substring(0,16)+
                time.substring(3,6)+
                TOKEN.substring(16,32)+
                time.substring(6,10);
    }
}
