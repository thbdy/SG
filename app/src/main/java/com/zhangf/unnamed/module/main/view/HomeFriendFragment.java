package com.zhangf.unnamed.module.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.MyFriendsAdapter;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.presenter.HomeFriendPresenter;
import com.zhangf.unnamed.module.main.presenter.HomeFriendPresenterImpl;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 个人主页-TA的回复
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class HomeFriendFragment extends BaseFragment<HomeFriendPresenterImpl> implements HomeFriendPresenter.View {
    @BindView(R.id.rv_friends)
    RecyclerView rvFriends;
    Unbinder unbinder;
    private MyFriendsAdapter mAdapter;
    private List<MyFriendsResult.ListBean> mDataList = new ArrayList<>();
//    https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=mythread2&version=4&type=thread&uid=8793833
//    https://bbs.sgamer.com/api/mobile/iyz_index.php?iyzmobile=1&module=mythread2&version=4&type=reply&uid=8793833
    @Override
    protected void initData() {
        mPresenter.fetchHisFriends("4", "friend", "me", "space", mUid);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_friend;
    }

    @Override
    protected void initView() {
        mAdapter = new MyFriendsAdapter(R.layout.item_my_friend,mDataList);
        rvFriends.setLayoutManager(new LinearLayoutManager(mContext));
        rvFriends.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position){
                Intent intent = new Intent(mContext,UserHomePagerActivity.class);
                intent.putExtra("uid",mDataList.get(position).getUid());
                startActivity(intent);
            }
        });
        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_chat){
                    Intent intent = new Intent(mContext,ChatActivity.class);
                    intent.putExtra("uid",mDataList.get(position).getUid());
                    intent.putExtra("nickname",mDataList.get(position).getUsername());
                    startActivity(intent);
                }
                return false;
            }
        });
    }

    @Override
    protected HomeFriendPresenterImpl initPresenter() {
        return new HomeFriendPresenterImpl(this);
    }

    @Override
    public void showHisFriends(BaseResponse2<MyFriendsResult> result) {
        if (result.getRequest_id().equals("0")) {
            if(result.getVariables().getList().size() > 0){
                mDataList.clear();
                mDataList.addAll(result.getVariables().getList());
                mAdapter.notifyDataSetChanged();
            }

        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
