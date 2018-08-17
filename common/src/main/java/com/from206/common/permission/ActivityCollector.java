package com.from206.common.permission;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目描述：微宏
 * 创建人：os.qiaogb
 * 类描述：
 * 日期：2017/1/23
 * 版权所有：
 */
public class ActivityCollector {
    private static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static Activity getTopActivity() {
        if (activityList.isEmpty()) {
            return null;
        } else {
            return activityList.get(activityList.size() - 1);
        }
    }
}
