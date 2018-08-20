package com.from206.common.permission;

import java.util.List;

/**
 * 创建人：zhangf
 * 类描述：
 * 日期：2017/1/23
 * 版权所有：
 */
public interface PermissionListener {

    void onGranted();

    void onDenied(List<String> deniedPermission);
}
