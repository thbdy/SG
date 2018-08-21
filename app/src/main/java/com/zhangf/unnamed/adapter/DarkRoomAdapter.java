package com.zhangf.unnamed.adapter;

import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.module.menu.model.DarkRoomEntity;

import java.util.List;

/**
 * Created by 75232 on 2018/8/21
 * Email：752323877@qq.com
 */
public class DarkRoomAdapter extends BaseQuickAdapter<DarkRoomEntity,BaseViewHolder>{
    public DarkRoomAdapter(int layoutResId, List<DarkRoomEntity> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DarkRoomEntity item) {
        LinearLayout llBg = helper.getView(R.id.ll_bg);
        if(helper.getPosition() % 2 == 0){
            llBg.setBackgroundColor(mContext.getResources().getColor(R.color.health_green));
        }else {
            llBg.setBackgroundColor(mContext.getResources().getColor(R.color.white));
        }
        helper.setText(R.id.tv_user_name,item.getUserName());
        helper.setText(R.id.tv_action,item.getAction());
        helper.setText(R.id.tv_end_time,item.getEndTime());
        helper.setText(R.id.tv_action_time,item.getActionTime());
        helper.setText(R.id.tv_action_reason,item.getActionReason());

    }
}
