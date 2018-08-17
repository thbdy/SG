package com.from206.common.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 作者：zf on 2016/8/10 09:03
 * 邮箱：752323877@qq.com
 */
public class ToastUtil {
    private static Toast toast;
    public static void showToast(Context context, String content)
    {
        if (toast == null)
        {
            toast = Toast.makeText(context, content, Toast.LENGTH_SHORT);
        } else {
            toast.setText(content);
        }
        toast.show();
    }
}
