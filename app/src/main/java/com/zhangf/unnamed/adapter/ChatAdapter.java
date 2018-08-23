package com.zhangf.unnamed.adapter;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.module.main.model.ChatResult;
import com.zhangf.unnamed.weight.CircleImageView;

import java.util.List;

/**
 * Created by 75232 on 2018/8/23
 * Email：752323877@qq.com
 */
public class ChatAdapter extends BaseMultiItemQuickAdapter<ChatResult.ListBean,BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ChatAdapter(List<ChatResult.ListBean> data) {
        super(data);
        addItemType(ChatResult.ListBean.TYPE_1, R.layout.item_message_to);
        addItemType(ChatResult.ListBean.TYPE_2, R.layout.item_message_from);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChatResult.ListBean item) {

        CircleImageView ivHead = helper.getView(R.id.civ_head);

        Glide.with(mContext).load(item.getMsgfromid_avatar()).error(R.drawable.icon_default_head).into(ivHead);
        helper.setText(R.id.tv_content,item.getMessage());


    }
}
