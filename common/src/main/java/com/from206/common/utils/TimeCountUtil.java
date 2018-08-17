package com.from206.common.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 作者：zf on 2016/11/10 16:02
 * 邮箱：752323877@qq.com
 * 倒计时工具类
 */

public class TimeCountUtil extends CountDownTimer {
    private TextView tv;

    public TimeCountUtil(long millisInFuture, long countDownInterval, TextView tv) {
        super(millisInFuture, countDownInterval);
        this.tv=tv;
    }

    @Override
    public void onFinish() {
        tv.setText("重新验证");
        tv.setClickable(true);
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tv.setClickable(false);
        tv.setText(millisUntilFinished / 1000 + "秒");
    }
}