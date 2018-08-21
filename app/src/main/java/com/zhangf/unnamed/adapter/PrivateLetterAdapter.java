package com.zhangf.unnamed.adapter;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.from206.common.utils.DateUtils;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.module.menu.model.PrivateLetterResult;
import com.zhangf.unnamed.weight.CircleImageView;

import java.util.List;

/**
 * Created by 75232 on 2018/8/20
 * Email：752323877@qq.com
 */
public class PrivateLetterAdapter extends BaseQuickAdapter<PrivateLetterResult.ListBean,BaseViewHolder>{

    public PrivateLetterAdapter(int layoutResId, List<PrivateLetterResult.ListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PrivateLetterResult.ListBean item) {
        CircleImageView civHead = helper.getView(R.id.civ_head);
        Glide.with(mContext).load(item.getMsgfromid_avatar()).error(R.drawable.icon_default_head).into(civHead);
        helper.setText(R.id.tv_nickname,item.getMsgfrom());
        helper.setText(R.id.tv_time, DateUtils.getDateToString(Long.valueOf(item.getLastdateline())));
        helper.setText(R.id.tv_content,item.getSubject());


    }
}
