package com.from206.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;



/**
 * 创建人：zhangf
 * 类描述： --
 * 日期：2017/3/14
 * 版权所有：
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView(savedInstanceState);
        initToolBar(savedInstanceState);
        initData(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    /**
     * 初始化数据
     * @param savedInstanceState
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 初始化导航栏
     * @param savedInstanceState
     */
    protected abstract void initToolBar(Bundle savedInstanceState);

    /**
     * 初始化控件
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 设置布局
     * @return
     */
    protected abstract int getLayoutId();


}
