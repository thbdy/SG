package com.zhangf.unnamed.module.main.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.zhangf.unnamed.App;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.UserInfoManager;
import com.zhangf.unnamed.adapter.ViewPagerAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.login.view.LoginActivity;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.SignResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.presenter.MainPresenter;
import com.zhangf.unnamed.module.main.presenter.MainPresenterImpl;
import com.zhangf.unnamed.module.menu.view.DarkRoomActivity;
import com.zhangf.unnamed.module.menu.view.MyFriendsActivity;
import com.zhangf.unnamed.module.menu.view.MyMessageActivity;
import com.zhangf.unnamed.module.menu.view.SearchActivity;
import com.zhangf.unnamed.utils.ImageBlurUtil;
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.SaveCookiesUtils;
import com.zhangf.unnamed.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainPresenter.View, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

//    /**
//     * 导航栏
//     */
//    @BindView(R.id.tab_layout)
//    TabLayout tabLayout;
    /**
     * 昵称
     */
    @BindView(R.id.tv_nickname)
    TextView tvNickName;

    /**
     * 导航栏数据源
     */
    private List<GetAllResult.ForumlistBean> tabList = new ArrayList<>();

    @BindView(R.id.iv_blur)
    ImageView ivBlur;
    /**
     * 金币数量
     */
    @BindView(R.id.tv_gold)
    TextView tvGold;
    /**
     * 消息提示
     */
    @BindView(R.id.tv_message_tip)
    TextView tvMsgTip;

    /**
     * 签到按钮
     */
    @BindView(R.id.btn_daily_click)
    Button btnDailyClick;

    private List<Fragment> fragmentList;

    private ForumFragment forumFragment;

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.rg_nav)
    RadioGroup rgNav;

    private ViewPagerAdapter mViewPagerAdapter;

    SecondFragment secondFragment;
    ThirdFragment thirdFragment;


    @Override
    protected void initData() {

    }

    @Override
    protected MainPresenterImpl initPresenter() {
        return new MainPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initLeftMenuData();


        fragmentList = new ArrayList<>();
        fragmentList.add(forumFragment = new ForumFragment());
        fragmentList.add(secondFragment = new SecondFragment());
        fragmentList.add(thirdFragment = new ThirdFragment());

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(mViewPagerAdapter);

        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        rgNav.setOnCheckedChangeListener(this);


    }

    /**
     * 初始化侧边栏数据
     */
    private void initLeftMenuData() {

        Bitmap mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.icon_default_head);
        Bitmap rsBitmap = ImageBlurUtil.rsBlur(this, mBitmap, 0.4f, 2);
        ivBlur.setImageBitmap(rsBitmap);

        tvNickName.setText(UserInfoManager.getUserInfoManager().getNickname());  //昵称
        tvGold.setText(String.valueOf(UserInfoManager.getUserInfoManager().getGold())); //金币
        tvMsgTip.setText("11"); //消息提示

    }




    @Override
    public void showGetAll(BaseResponse2<GetAllResult> result) {
//        if (result.getRequest_id().equals("0")) {
//
//            List<GetAllResult.ForumlistBean> tempList = new ArrayList<>();
//            tempList.addAll(result.getVariables().getForumlist());
//            for (int i = 0; i < tempList.size(); i++) {
//                if (tempList.get(i).getName().toUpperCase().equals("刀塔")) {
//                    tempList.remove(i);
//                    tempList.add(0, result.getVariables().getForumlist().get(i));
//                }
//            }
//            tabList.clear();
//            tabList.addAll(tempList);
//
//            for (GetAllResult.ForumlistBean forumlistBean : tabList) {
//                tabLayout.addTab(tabLayout.newTab().setText(forumlistBean.getName()));
//            }
//        }
    }

    @Override
    public void showThemeList(BaseResponse2<ThemeListResult> result) {


    }

    @Override
    public void showSign(SignResult result) {
        btnDailyClick.setEnabled(false);
        btnDailyClick.setText("已签");
        btnDailyClick.setAlpha(0.5f);
        ToastUtil.showToast(mContext, result.getErrorMSG());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void initToolBar(Bundle savedInstanceState) {

    }





    @OnClick({ R.id.btn_login_out, R.id.miv_my_focus, R.id.miv_my_message, R.id.miv_my_thread,
            R.id.miv_my_friends, R.id.miv_my_settings, R.id.miv_dark_room, R.id.btn_daily_click, R.id.iv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            //退出登录
            case R.id.btn_login_out:
                //清楚cookie数据
                SaveCookiesUtils.clear(mContext);
                UserInfoManager.getUserInfoManager().setLogin(false);
                UserInfoManager.getUserInfoManager().destroy();
                SPUtils.clear(mContext);
                CookieManager.getInstance().removeAllCookie();
                App.getApp().clearCookies();

                Intent intent = new Intent(mContext, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
                startActivity(intent);
//                ToastUtil.showToast(mContext, "退出登录成功");
                break;
            //我的关注
            case R.id.miv_my_focus:
                startActivity(new Intent(mContext, SearchActivity.class));
                break;
            //我的消息
            case R.id.miv_my_message:
                startActivity(new Intent(mContext, MyMessageActivity.class));
                break;
            //我的好友
            case R.id.miv_my_friends:
                startActivity(new Intent(mContext, MyFriendsActivity.class));
                break;
            //小黑屋
            case R.id.miv_dark_room:
                startActivity(new Intent(mContext, DarkRoomActivity.class));
                break;
            //签到
            case R.id.btn_daily_click:
//                https://bbs.sgamer.com/plugin.php?id=dsu_paulsign:sign&operation=qiandao&infloat=0&inajax=1&api=sign
                String formhash = (String) SPUtils.get(mContext, "formhash", "");
                String apiToken = (String) SPUtils.get(mContext, "apiToken", "");
                mPresenter.fetchSign(apiToken, formhash);

                break;
            //点击自己头像
            case R.id.iv_head:
                intent = new Intent(mContext, UserHomePagerActivity.class);
                intent.putExtra("uid", UserInfoManager.getUserInfoManager().getUcid());
                startActivity(intent);
                break;

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.rb_2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.rb_3:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        rgNav.getChildAt(position).setSelected(true);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
