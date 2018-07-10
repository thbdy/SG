package com.zhangf.unnamed.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.view.CircleImageView;

import java.util.List;

public class ThemeListAdapter extends BaseQuickAdapter<ThemeListResult.ForumThreadlistBean,BaseViewHolder>{

    public ThemeListAdapter(List<ThemeListResult.ForumThreadlistBean> data) {
        super(R.layout.item_theme_list,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ThemeListResult.ForumThreadlistBean item) {
        helper.setText(R.id.tv_title,item.getSubject());
        CircleImageView ivHead = helper.getView(R.id.iv_head);
        Glide.with(mContext).load(item.getAvatar()).error(R.mipmap.ic_launcher).into(ivHead);
        helper.setText(R.id.tv_nickname,item.getAuthor());
        helper.setText(R.id.tv_time,item.getLastpost());
        ImageView ivIndex = (ImageView) helper.getView(R.id.iv_index);
        if(item.getAttachment_urls().size() > 0){
            ivIndex.setVisibility(View.VISIBLE);
            Glide.with(mContext).load(item.getAttachment_urls().get(0)).error(R.mipmap.ic_launcher).into(ivIndex);
        }else {
            ivIndex.setVisibility(View.INVISIBLE);
            ivIndex.setImageResource(R.color.white);
        }
        helper.addOnClickListener(R.id.iv_index);


    }
}
