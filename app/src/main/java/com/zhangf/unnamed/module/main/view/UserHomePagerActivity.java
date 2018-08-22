package com.zhangf.unnamed.module.main.view;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.enums.LevelEnum;
import com.zhangf.unnamed.module.main.model.ProFileResult;
import com.zhangf.unnamed.module.main.presenter.UserHomePagerPresenter;
import com.zhangf.unnamed.module.main.presenter.UserHomePagerPresenterImpl;
import com.zhangf.unnamed.weight.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 用户主页
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class UserHomePagerActivity extends BaseActivity<UserHomePagerPresenterImpl> implements UserHomePagerPresenter.View {

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
    /**
     * 用户ID
     */
    private String mUid;

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

        Log.e(TAG, "showProfile: " + result.getVariables().getSpace().getGroup().getGrouptitle());
        int img = LevelEnum.getImgByLevel(result.getVariables().getSpace().getGroup().getGrouptitle());
        ivLevel.setBackgroundResource(img);

        tvGold.setText(result.getVariables().getSpace().getExtcredits().get(0).getValue());
        tvHonor.setText(result.getVariables().getSpace().getExtcredits().get(1).getValue());
        tvSuperDrug.setText(result.getVariables().getSpace().getExtcredits().get(2).getValue());
        tvHumanQi.setText(result.getVariables().getSpace().getExtcredits().get(3).getValue());

        tvPost.setText(result.getVariables().getSpace().getPosts());
        tvThreads.setText(result.getVariables().getSpace().getThreads());
        tvFriends.setText(result.getVariables().getSpace().getFriends());


    }

}
