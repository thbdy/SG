package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.menu.model.AddFriendResult;
import com.zhangf.unnamed.module.menu.presenter.AddFriendPresenter;
import com.zhangf.unnamed.module.menu.presenter.AddFriendPresenterImpl;
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class AddFriendActivity extends BaseActivity<AddFriendPresenterImpl> implements AddFriendPresenter.View {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.et_content)
    EditText etContent;

    private String mUid;

    //https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=addfriend&version=4
    //uid=8756567&note=%E6%8B%96%E6%8B%89%E6%9C%BA&formhash=168f8289
    @Override
    protected void initToolBar(Bundle savedInstanceState) {
        tvTitle.setText("添加好友");
        ivBack.setVisibility(View.VISIBLE);
        tvRight.setText("发送");
        tvRight.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_friend;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mUid = getIntent().getStringExtra("uid");


    }

    @Override
    protected void initData() {


    }

    @Override
    protected AddFriendPresenterImpl initPresenter() {
        return new AddFriendPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.iv_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.tv_right:
                String formhash = (String) SPUtils.get(mContext, "formhash", "");
                String note = etContent.getText().toString().trim();
                mPresenter.fetchAddFriend(mUid,note,formhash);
                break;
        }
    }

    @Override
    public void showAddFriend(BaseResponse2<AddFriendResult> result) {
        if(result.getRequest_id().equals("0")){
            if(result.getVariables().getStatus().equals("0")){
                ToastUtil.showToast(mContext,result.getVariables().getShow_message());
                this.finish();
            }else {
                ToastUtil.showToast(mContext,"发送好友申请失败");
            }
        }
    }
}
