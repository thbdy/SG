package com.zhangf.unnamed.module.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.ViewPagerAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.enums.LevelEnum;
import com.zhangf.unnamed.module.main.model.ProFileResult;
import com.zhangf.unnamed.module.main.presenter.UserHomePagerPresenter;
import com.zhangf.unnamed.module.main.presenter.UserHomePagerPresenterImpl;
import com.zhangf.unnamed.module.menu.view.AddFriendActivity;
import com.zhangf.unnamed.weight.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 用户主页
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class UserHomePagerActivity extends BaseActivity<UserHomePagerPresenterImpl> implements UserHomePagerPresenter.View, ViewPager.OnPageChangeListener, TabLayout.OnTabSelectedListener {


//    https://bbs.sgamer.com/api/mobile/iyz_index.php?version=1&module=friend&charset=utf-8 获取我的好友列表
//    formhash=cb62d76a

//    https://bbs.sgamer.com/api/mobile/iyz_index.php?version=4&module=friend&view=me&from=space&uid=9088080 //获取别人的好友列表

    @BindView(R.id.iv_blur)
    ImageView ivBlur;
    @BindView(R.id.civ_head)
    CircleImageView civHead;
    @BindView(R.id.tv_nickname)
    TextView tvNickname;
    @BindView(R.id.iv_level)
    ImageView ivLevel;
    @BindView(R.id.rl_header)
    RelativeLayout rlHeader;
    @BindView(R.id.tv_gold)
    TextView tvGold;
    @BindView(R.id.tv_honor)
    TextView tvHonor;
    @BindView(R.id.tv_super_drug)
    TextView tvSuperDrug;
    @BindView(R.id.tv_human_qi)
    TextView tvHumanQi;
    @BindView(R.id.tv_post)
    TextView tvPost;
    @BindView(R.id.tv_threads)
    TextView tvThreads;
    @BindView(R.id.tv_friends)
    TextView tvFriends;
    @BindView(R.id.ll_uer_info_1)
    LinearLayout llUerInfo1;
    @BindView(R.id.tv_credits)
    TextView tvCredits;
    @BindView(R.id.iv_now_level)
    ImageView ivNowLevel;
    @BindView(R.id.iv_next_level)
    ImageView ivNextLevel;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    @BindView(R.id.iv_action)
    ImageView ivAction;
    @BindView(R.id.ll_credits)
    LinearLayout llCredits;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    /**
     * 用户ID
     */
    private String mUid;
    /**
     * 积分表
     */
    private int mCredits[] = {0, 10, 100, 400, 800, 1700, 2800, 4000, 6000, 9000, 15000, 25000, 50000, 100000, 200000, 500000};


    private HomeReplyFragment homeReplyFragment;
    private HomeThreadFragment homeThreadFragment;
    private HomeFriendFragment homeFriendFragment;
    private ViewPagerAdapter mViewPagerAdapter;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initToolBar(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        //取消状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        return R.layout.activity_user_home_pager;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mUid = getIntent().getStringExtra("uid");

        tabLayout.addTab(tabLayout.newTab().setText("TA的回复"));
        tabLayout.addTab(tabLayout.newTab().setText("TA的主题"));
        tabLayout.addTab(tabLayout.newTab().setText("TA的好友"));

        fragmentList.add(homeReplyFragment = new HomeReplyFragment());
        fragmentList.add(homeThreadFragment = new HomeThreadFragment());
        fragmentList.add(homeFriendFragment = new HomeFriendFragment());

        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),fragmentList);
        viewPager.setAdapter(mViewPagerAdapter);
        viewPager.addOnPageChangeListener(this);

        tabLayout.addOnTabSelectedListener(this);

        homeReplyFragment.setmUid(mUid);
        homeThreadFragment.setmUid(mUid);
        homeFriendFragment.setmUid(mUid);


    }

    @Override
    protected void initData() {
        mPresenter.fetchProFile(mUid, "profile", "4");
    }

    @Override
    protected UserHomePagerPresenterImpl initPresenter() {
        return new UserHomePagerPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @Override
    public void showProfile(BaseResponse2<ProFileResult> result) {

        showImageInfo(result);
        showBaseInfo(result);
        showCredits(Integer.valueOf(result.getVariables().getSpace().getCredits()));


    }

    /**
     * 显示头像的图像信息
     *
     * @param result
     */
    private void showImageInfo(BaseResponse2<ProFileResult> result) {
        Glide.with(mContext)
                .load(result.getVariables()
                        .getSpace().getAvatar())

                .error(R.drawable.icon_default_head)
                .into(civHead);


        //加载背景，
        Glide.with(mContext)
                .load(result.getVariables().getSpace().getAvatar())
                .error(R.drawable.icon_default_head)
                .dontAnimate()
                .bitmapTransform(new BlurTransformation(this, 2, 2))
                .into(ivBlur);

        tvNickname.setText(result.getVariables().getSpace().getUsername());

        int img = LevelEnum.getImgByLevel(result.getVariables().getSpace().getGroup().getGrouptitle());
        ivLevel.setBackgroundResource(img);
    }

    /**
     * 显示基本信息
     *
     * @param result
     */
    private void showBaseInfo(BaseResponse2<ProFileResult> result) {
        tvGold.setText(result.getVariables().getSpace().getExtcredits().get(0).getValue());
        tvHonor.setText(result.getVariables().getSpace().getExtcredits().get(1).getValue());
        tvSuperDrug.setText(result.getVariables().getSpace().getExtcredits().get(2).getValue());
        tvHumanQi.setText(result.getVariables().getSpace().getExtcredits().get(3).getValue());

        tvPost.setText(result.getVariables().getSpace().getPosts());
        tvThreads.setText(result.getVariables().getSpace().getThreads());
        tvFriends.setText(result.getVariables().getSpace().getFriends());

        //自己本人的空间
        if (result.getVariables().getSpace().getSelf().equals("1")) {
            ivAction.setVisibility(View.GONE);
        } else {
            ivAction.setVisibility(View.VISIBLE);
            if (result.getVariables().getSpace().getIs_my_friend().equals("1")) { //是我的朋友
                ivAction.setActivated(true);
            } else {
                ivAction.setActivated(false);
            }
        }

    }

    /**
     * 计算积分规则和显示
     *
     * @param credit 积分数
     */
    private void showCredits(Integer credit) {
        int level = 0;
        for (int i = 0; i < mCredits.length; i++) {
            if (mCredits[i] <= credit && credit < mCredits[i + 1]) {
                level = i;
                break;
            }
        }
        tvCredits.setText(credit + "/" + mCredits[level + 1]);
        ivNowLevel.setBackgroundResource(LevelEnum.getImgByLevel("LV" + level));
        ivNextLevel.setBackgroundResource(LevelEnum.getImgByLevel("LV" + (level + 1)));
        mProgressBar.setProgress(mCredits[level] * 100 / mCredits[level + 1]);

    }

    @OnClick({R.id.iv_action})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_action:
                //不是好友，跳转到添加好友页面
                if (!ivAction.isActivated()) {
                    Intent intent = new Intent(mContext, AddFriendActivity.class);
                    intent.putExtra("uid", mUid);
                    startActivity(intent);
                } else { //是好友，跳转到聊天界面


                }
                break;
        }

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabLayout.getTabAt(position).select();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
