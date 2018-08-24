package com.zhangf.unnamed.module.main.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.UserInfoManager;
import com.zhangf.unnamed.adapter.ChatAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.ChatResult;
import com.zhangf.unnamed.module.main.model.SendMessageResult;
import com.zhangf.unnamed.module.main.presenter.ChatPresenter;
import com.zhangf.unnamed.module.main.presenter.ChatPresenterImpl;
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class ChatActivity extends BaseActivity<ChatPresenterImpl> implements ChatPresenter.View {
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.rv_chat)
    RecyclerView rvChat;
    private String mNickName;
    private String mUid;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_content)
    EditText etContent;
    private String mContent;

    private ChatAdapter chatAdapter;
    private List<ChatResult.ListBean> mMsgList = new ArrayList<>();


    //发送私信内容
//    https://bbs.sgamer.com/api/mobile/index.php?mobile=no&version=4&module=sendpm&pmsubmit=yes&charset=utf-8

//    touid=8793833&formhash=168f8289&message=222


    @Override
    protected void initToolBar(Bundle savedInstanceState) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_chat;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        mNickName = getIntent().getStringExtra("nickname");
        mUid = getIntent().getStringExtra("uid");

        tvTitle.setText(mNickName);
        ivBack.setVisibility(View.VISIBLE);

        rvChat.setLayoutManager(new LinearLayoutManager(mContext));
        chatAdapter = new ChatAdapter(mMsgList);
        rvChat.setAdapter(chatAdapter);
    }

    @Override
    protected void initData() {
        String formhash = (String) SPUtils.get(mContext, "formhash", "");
        mPresenter.fetchChat("1", "mypm", "utf-8", "view", formhash, mUid);

    }

    @Override
    protected ChatPresenterImpl initPresenter() {
        return new ChatPresenterImpl(this);
    }

    @OnClick({R.id.iv_back,R.id.btn_send})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_send:
                mContent = etContent.getText().toString().trim();
                String formhash = (String) SPUtils.get(mContext, "formhash", "");
                mPresenter.fetchSendMessage(mUid,formhash,mContent);
                break;
        }
    }

    @Override
    public void showChat(BaseResponse2<ChatResult> result) {
        if(result.getRequest_id().equals("0")){
            if(result.getVariables().getList().size() > 0){
                mMsgList.clear();
                mMsgList.addAll(result.getVariables().getList());
                chatAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void showSendMessage(SendMessageResult  result) {
        if(result.getMessage().getMessageval().equals("do_success")){
            etContent.setText("");
            ChatResult.ListBean addbean = new ChatResult.ListBean();
            String myUid = UserInfoManager.getUserInfoManager().getUcid();
            addbean.setAuthorid(myUid);
            addbean.setMsgfromid_avatar("s");
            addbean.setMsgtoid_avatar("s");
            addbean.setMessage(mContent);
            mMsgList.add(addbean);
            chatAdapter.notifyDataSetChanged();
        }else {
            //发送失败
            ToastUtil.showToast(mContext,result.getMessage().getMessagestr());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
