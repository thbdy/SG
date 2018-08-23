package com.zhangf.unnamed.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.module.main.model.HisReplyResult;
import com.zhangf.unnamed.weight.CircleImageView;

import java.util.List;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class HisReplyAdapter extends BaseQuickAdapter<HisReplyResult.DataBean,BaseViewHolder>{


    public HisReplyAdapter(int layoutResId, List<HisReplyResult.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HisReplyResult.DataBean item) {
        helper.addOnClickListener(R.id.iv_head);
        helper.setText(R.id.tv_title,item.getSubject());

        CircleImageView ivHead = helper.getView(R.id.iv_head);
//        Glide.with(mContext).load(item.ge).error(R.drawable.icon_default_head).into(ivHead);
        helper.setText(R.id.tv_nickname,item.getAuthor());
        helper.setText(R.id.tv_time,item.getLastpost());
        ImageView ivIndex = (ImageView) helper.getView(R.id.iv_index);
        ivIndex.setVisibility(View.GONE);
//        if(item.getAttachment_urls().size() > 0){
//            ivIndex.setVisibility(View.VISIBLE);
//            Glide.with(mContext).load(item.getAttachment_urls().get(0)).error(R.mipmap.ic_launcher).into(ivIndex);
//        }else {
//            ivIndex.setVisibility(View.INVISIBLE);
//            ivIndex.setImageResource(R.color.white);
//        }
        helper.addOnClickListener(R.id.iv_index);
        helper.setText(R.id.tv_comment,item.getReplies());
        helper.setText(R.id.tv_views,item.getViews());

        int i = Integer.parseInt(item.getReplies());
        if(i <= 20){
            helper.setImageResource(R.id.iv_comment,R.drawable.icon_comment);
            helper.setTextColor(R.id.tv_comment,mContext.getResources().getColor(R.color.black_40));
        }else if(i<= 50){
            helper.setImageResource(R.id.iv_comment,R.drawable.icon_comment_1);
            helper.setTextColor(R.id.tv_comment,mContext.getResources().getColor(R.color.comment_1));
        }else {
            helper.setImageResource(R.id.iv_comment,R.drawable.icon_comment_2);
            helper.setTextColor(R.id.tv_comment,mContext.getResources().getColor(R.color.comment_2));
        }

        int j = Integer.parseInt(item.getViews());
        if(j <= 2000){
            helper.setImageResource(R.id.iv_views,R.drawable.icon_views);
            helper.setTextColor(R.id.tv_views,mContext.getResources().getColor(R.color.black_40));
        }else if (j <= 5000){
            helper.setImageResource(R.id.iv_views,R.drawable.icon_views_1);
            helper.setTextColor(R.id.tv_views,mContext.getResources().getColor(R.color.comment_1));
        }else {
            helper.setImageResource(R.id.iv_views,R.drawable.icon_views_2);
            helper.setTextColor(R.id.tv_views,mContext.getResources().getColor(R.color.comment_2));
        }


        helper.setText(R.id.tv_message,item.getDetails().get(0).getMessage());

        CircleImageView ivReplyHead = helper.getView(R.id.civ_reply_head);

    }


}
