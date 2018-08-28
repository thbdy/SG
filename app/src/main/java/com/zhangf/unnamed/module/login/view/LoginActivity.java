package com.zhangf.unnamed.module.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.zhangf.unnamed.App;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.UserInfoManager;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.base.BaseResponse3;
import com.zhangf.unnamed.module.login.presenter.LoginPresenter;
import com.zhangf.unnamed.module.login.presenter.LoginPresenterImpl;
import com.zhangf.unnamed.module.main.model.CheckPostResult;
import com.zhangf.unnamed.module.main.model.UserGoldResult;
import com.zhangf.unnamed.module.main.model.UserInfoResult;
import com.zhangf.unnamed.module.main.view.MainActivity;
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.ToastUtil;
import com.zhangf.unnamed.utils.TokenUtil;

import java.net.URLDecoder;

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
    private String apiToken;

    private String time;
    private String code;

    @Override
    protected void initData() {

    }

    @Override
    protected LoginPresenterImpl initPresenter() {
        return new LoginPresenterImpl(this);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
        Boolean isLogin = UserInfoManager.getUserInfoManager().getLogin();
        if (null != isLogin && isLogin) {
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        }

    }

    @Override
    protected void initToolBar(Bundle savedInstanceState) {

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
        if(TextUtils.isEmpty(username)){
            ToastUtil.showToast(mContext,"用户名不能为空");
        }
        if(TextUtils.isEmpty(password)){
            ToastUtil.showToast(mContext,"密码不能为空");
        }

        showLoadingDialog("正在登录");
        apiToken = TokenUtil.getToken();
        mPresenter.fetchLogin("3", apiToken, username, password);
    }

    @Override
    public void showLogin(BaseResponse<String> result) {
        if (result.getError() == 0) {
            UserInfoManager.getUserInfoManager().setToken(result.getErrorMsg());
            SPUtils.put(App.getApp(), "token", result.getErrorMsg());
            SPUtils.put(App.getApp(), "apiToken", apiToken);


            code = result.getExtra().split("&code=")[1];
            time = result.getExtra().split("&code=")[0].split("time=")[1];

//            https://bbs.sgamer.com/api/mobile/index.php?g=app&m=user&a=getuserinfo
//            https://betapi.sgamer.com/index.php?g=app&m=user&a=getuserinfo
            mPresenter.fetchUserInfo(result.getErrorMsg(), apiToken);
//            mPresenter.fetchUserGold(result.getErrorMsg(),apiToken);


//            mPresenter.fettchCheckPost();

        }else {
            dismissLoadingDialog();
        }
    }

    @Override
    public void showUserInfo(BaseResponse3<UserInfoResult> result) {

        if (result.getError() == 0) {
            UserInfoManager.getUserInfoManager().setUserData(new Gson().toJson(result.getItems()));
//            Log.e(TAG, "showUserInfo: "+result.getItems().toString());
//            Intent intent = new Intent(this,MainActivity.class);
//            startActivity(intent);
            mPresenter.fetchTimeCode(time, URLDecoder.decode(code));
        }else {
            dismissLoadingDialog();
        }
    }

    @Override
    public void showUserGold(BaseResponse3<UserGoldResult> result) {
        if (result.getError() == 0) {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void showCheckPost(BaseResponse2<CheckPostResult> result) {
        dismissLoadingDialog();
        ToastUtil.showToast(mContext,"登录成功");
        UserInfoManager.getUserInfoManager().setLogin(true);
        SPUtils.put(mContext,"formhash",result.getVariables().getFormhash());
        this.finish();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void showTimeCode(String s) {
        mPresenter.fettchCheckPost();

    }

    @OnClick({R.id.btn_login})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
        }
    }


}
