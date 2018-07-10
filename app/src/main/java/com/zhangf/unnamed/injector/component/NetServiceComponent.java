package com.zhangf.unnamed.injector.component;


import com.zhangf.unnamed.injector.module.NetServiceModule;
import com.zhangf.unnamed.module.login.view.LoginActivity;
import com.zhangf.unnamed.module.main.view.MainActivity;
import com.zhangf.unnamed.module.main.view.ThreadActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetServiceModule.class})
public interface NetServiceComponent {

    void injectLoginActivity(LoginActivity activity);
    void injectMainActivity(MainActivity activity);
    void injectThreadActivity(ThreadActivity activity);
}