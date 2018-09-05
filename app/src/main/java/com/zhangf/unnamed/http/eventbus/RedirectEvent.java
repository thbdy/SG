package com.zhangf.unnamed.http.eventbus;

/**
 * 重定向事件
 * Created by 75232 on 2018/8/24
 * Email：752323877@qq.com
 */
public class RedirectEvent {
    public String url;
    public RedirectEvent(String url) {
        this.url = url;
    }
}
