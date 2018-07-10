package com.zhangf.unnamed.module.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.UserInfoManager;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.http.NetService;
import com.zhangf.unnamed.injector.component.DaggerNetServiceComponent;
import com.zhangf.unnamed.injector.module.NetServiceModule;
import com.zhangf.unnamed.module.login.presenter.LoginPresenter;
import com.zhangf.unnamed.module.login.presenter.LoginPresenterImpl;
import com.zhangf.unnamed.module.main.view.MainActivity;
import com.zhangf.unnamed.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginPresenterImpl> implements LoginPresenter.View {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private String username;
    private String password;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    protected void initInject() {
        DaggerNetServiceComponent.builder().netServiceModule(new NetServiceModule(NetService.BASE_URL)).build().injectLoginActivity(this);
    }

    @Override
    public void setState(String state, String msg) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
//        Boolean isLogin = (Boolean) SPUtils.get(App.getApp(),"login_state",false);
//        if(null != isLogin && isLogin){
            startActivity(new Intent(this,MainActivity.class));
//        }

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        login();

    }

    /**
     * 登录
     */
    private void login() {
        username = etUsername.getText().toString().trim();
        password = etPwd.getText().toString().trim();
        if(username.equals("") || password.equals("")){
            ToastUtil.showToast(this,"请填写好完整的信息");
            return;
        }
        mPresenter.fetchLogin("3", NetService.API_TOKEN,"thbdy","Zf872153");
    }

    @Override
    public void showLogin(BaseResponse<String> result) {
        ToastUtil.showToast(this,result.getErrorMsg());
        if(result.getError() == 0){
            UserInfoManager.getUserInfoManager().setLogin(true);
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
