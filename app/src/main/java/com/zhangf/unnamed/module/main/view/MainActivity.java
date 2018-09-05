package com.zhangf.unnamed.module.main.view;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.maning.imagebrowserlibrary.MNImageBrowser;
import com.maning.imagebrowserlibrary.listeners.OnLongClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhangf.unnamed.App;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.UserInfoManager;
import com.zhangf.unnamed.adapter.ThemeListAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.login.view.LoginActivity;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.presenter.MainPresenter;
import com.zhangf.unnamed.module.main.presenter.MainPresenterImpl;
import com.zhangf.unnamed.module.menu.view.DarkRoomActivity;
import com.zhangf.unnamed.module.menu.view.MyFriendsActivity;
import com.zhangf.unnamed.module.menu.view.MyMessageActivity;
import com.zhangf.unnamed.module.menu.view.SearchActivity;
import com.zhangf.unnamed.utils.GlideImageEngine;
import com.zhangf.unnamed.utils.ImageBlurUtil;
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.SaveCookiesUtils;
import com.zhangf.unnamed.utils.SaveImg;
import com.zhangf.unnamed.utils.ToastUtil;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<MainPresenterImpl> implements MainPresenter.View, OnRefreshListener, OnLoadMoreListener, TabLayout.OnTabSelectedListener, OnLongClickListener {
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    /**
     * 下拉刷新
     */
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    /**
     * 导航栏
     */
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    /**
     * 昵称
     */
    @BindView(R.id.tv_nickname)
    TextView tvNickName;
    /**
     * 当前页数
     */
    private int mPage = 1;
    /**
     * 适配器
     */
    private ThemeListAdapter themeListAdapter;
    /**
     * 数据源
     */
    private List<ThemeListResult.ForumThreadlistBean> threadlistBeanList = new ArrayList<>();
    /**
     * 帖子图片数据源
     */
    private ArrayList<String> imageList = new ArrayList<>();
    /**
     * 导航栏数据源
     */
    private List<GetAllResult.ForumlistBean> tabList = new ArrayList<>();
    /**
     * 板块ID
     */
    private String mFid = "0";

    @BindView(R.id.fab_refresh)
    FloatingActionButton mFabRefresh;
    @BindView(R.id.iv_blur)
    ImageView ivBlur;
    /**
     * 旋转动画
     */
    private ObjectAnimator mRotationAni;
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
    private static final int PERMISSION_REQUEST_CODE = 10086;

    private Bitmap mBitmap;
    private String mPicName;

    @Override
    protected void initData() {
        mPresenter.fetchGetAll("44", "1");
    }

    @Override
    protected MainPresenterImpl initPresenter() {
        return new MainPresenterImpl(this);
    }


    private boolean checkPermission() {
        List<String> permissionLists = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionLists.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionLists.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionLists.isEmpty()) {//说明肯定有拒绝的权限
            ActivityCompat.requestPermissions(this, permissionLists.toArray(new String[permissionLists.size()]), PERMISSION_REQUEST_CODE);
            return false;
        }
        return true;
    }


    /**
     * 图片浏览弹窗
     *
     * @param position
     */
    private void showImageBrowseDialog(int position) {
        ArrayList<String> mImageList = new ArrayList<>();
        imageList.clear();
        imageList.addAll(threadlistBeanList.get(position).getAttachment_urls());
        for (String entity : threadlistBeanList.get(position).getAttachment_urls()) {
            if (entity.contains("url=")) {
                mImageList.add(URLDecoder.decode(entity.split("url=")[1]));
            } else {
                mImageList.add(entity);
            }
        }
        for (String s : mImageList) {
            Log.e(TAG, "原图地址: " + s);
        }

        MNImageBrowser.with(this)
                .setCurrentPosition(0)
                .setImageEngine(new GlideImageEngine())
                .setOnLongClickListener(this)
                .setImageList(mImageList)
                .setIndicatorHide(false)
                .show(rvData);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

        initAni();
        initLeftMenuData();

        rvData.setLayoutManager(new LinearLayoutManager(this));
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
        //tab可滚动
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addOnTabSelectedListener(this);


        themeListAdapter = new ThemeListAdapter(threadlistBeanList);
        themeListAdapter.bindToRecyclerView(rvData);


        themeListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_head) {
                    Intent intent = new Intent(mContext, UserHomePagerActivity.class);
                    intent.putExtra("uid", threadlistBeanList.get(position).getAuthorid());
                    startActivity(intent);
                }
                if (view.getId() == R.id.iv_index) {
                    showImageBrowseDialog(position);
                }
                return false;
            }
        });
        themeListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(MainActivity.this, ThreadActivity.class);
                intent.putExtra("tid", threadlistBeanList.get(position).getTid());
                startActivity(intent);
            }
        });
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

    /**
     * 初始化动画
     */
    private void initAni() {
        mRotationAni = ObjectAnimator.ofFloat(mFabRefresh, "rotation", 0, 360);
        mRotationAni.setDuration(500);
        mRotationAni.setRepeatCount(ValueAnimator.INFINITE);//无限循环
    }


    @Override
    public void showGetAll(BaseResponse2<GetAllResult> result) {
        if (result.getRequest_id().equals("0")) {

            List<GetAllResult.ForumlistBean> tempList = new ArrayList<>();
            tempList.addAll(result.getVariables().getForumlist());
            for (int i = 0; i < tempList.size(); i++) {
                if (tempList.get(i).getName().toUpperCase().equals("刀塔")) {
                    tempList.remove(i);
                    tempList.add(0, result.getVariables().getForumlist().get(i));
                }
            }
            tabList.clear();
            tabList.addAll(tempList);

            for (GetAllResult.ForumlistBean forumlistBean : tabList) {
                tabLayout.addTab(tabLayout.newTab().setText(forumlistBean.getName()));
            }
        }
    }

    @Override
    public void showThemeList(BaseResponse2<ThemeListResult> result) {
        if (mPage == 1) {
            mRotationAni.cancel();
            smartRefreshLayout.finishRefresh(0);
        } else {
            smartRefreshLayout.finishLoadMore();
        }
        if (result.getRequest_id().equals("0") && result.getVariables().getForum_threadlist().size() > 0) {
            if (mPage == 1) {
                threadlistBeanList.clear();
            }
            threadlistBeanList.addAll(result.getVariables().getForum_threadlist());




            int index = 0;
            for (int i = 0; i < threadlistBeanList.size(); i++) {
                if (threadlistBeanList.get(i).getTypeid().equals("2")) {
                    index = i;
                }
            }
            //移除置顶
            if (mPage == 1) {
                for (int i = 0; i <= index; i++) {
                    threadlistBeanList.remove(0);
                }
            }
            themeListAdapter.notifyDataSetChanged();
            if (mPage == 1) {
                rvData.smoothScrollToPosition(0);
            }
        } else {
            mPage--;
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
        }

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

    /**
     * 下拉刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        mPresenter.fetchThemeList(mFid, String.valueOf(mPage));

    }

    /**
     * 上拉加载更多
     *
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        mPresenter.fetchThemeList(mFid, String.valueOf(mPage));

    }

    /**
     * 导航栏滚动监听
     *
     * @param tab
     */
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mFid = tabList.get(tab.getPosition()).getFid();
        mPresenter.fetchThemeList(tabList.get(tab.getPosition()).getFid(), String.valueOf(mPage));
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @OnClick({R.id.fab_refresh, R.id.btn_login_out, R.id.miv_my_focus, R.id.miv_my_message, R.id.miv_my_thread,
            R.id.miv_my_friends, R.id.miv_my_settings, R.id.miv_dark_room, R.id.btn_daily_click, R.id.iv_head})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //刷新
            case R.id.fab_refresh:

                mRotationAni.start();
                mPage = 1;
                mPresenter.fetchThemeList(mFid, String.valueOf(mPage));
                break;
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
    public void onLongClick(FragmentActivity fragmentActivity, ImageView imageView, int i, final String s) {

        //处理GIF
        if (s.endsWith(".gif")) {
            ToastUtil.showToast(mContext, "暂时不支持保存GIF图片");
        } else {
            Glide.with(mContext).load(s).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    mPicName = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    mBitmap = resource;
                    if (checkPermission()) { //有读写权限
                        boolean hasSaved = SaveImg.saveImg(resource, mPicName, mContext);
                        if (hasSaved) {
                            ToastUtil.showToast(mContext, "已保存至相册^.^");
                        }
                    }

                }
            });
        }


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    for (int grantResult : grantResults) {
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
//                            Toast.makeText(this, "某一个权限被拒绝了", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    boolean hasSaved = SaveImg.saveImg(mBitmap, mPicName, mContext);
                    if (hasSaved) {
                        ToastUtil.showToast(mContext, "已保存至相册^.^");
                    }
                }
                break;
            default:
                break;
        }
    }
}
