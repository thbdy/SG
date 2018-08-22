package com.zhangf.unnamed.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.enums.LevelEnum;
import com.zhangf.unnamed.module.menu.model.MyFriendsResult;
import com.zhangf.unnamed.weight.CircleImageView;

import java.util.List;

/**
 * Created by 75232 on 2018/8/22
 * Email：752323877@qq.com
 */
public class MyFriendsAdapter extends BaseQuickAdapter<MyFriendsResult.ListBean,BaseViewHolder>{

    public MyFriendsAdapter(int layoutResId, List<MyFriendsResult.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyFriendsResult.ListBean item) {
        helper.setText(R.id.tv_nickname,item.getUsername());
        CircleImageView civHead = helper.getView(R.id.civ_head);
        Glide.with(mContext).load(item.getAvatar()).error(R.drawable.icon_default_head).into(civHead);
        ImageView ivLevel = helper.getView(R.id.iv_level);
        ivLevel.setBackgroundResource(LevelEnum.getImgByLevel(item.getGroupname()));


    }
}
