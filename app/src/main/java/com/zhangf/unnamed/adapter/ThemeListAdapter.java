package com.zhangf.unnamed.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.module.main.model.ThemeListResult;

import java.util.List;

public class ThemeListAdapter extends BaseQuickAdapter<ThemeListResult.ForumThreadlistBean,BaseViewHolder>{

    public ThemeListAdapter(List<ThemeListResult.ForumThreadlistBean> data) {
        super(R.layout.item_theme_list,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ThemeListResult.ForumThreadlistBean item) {
        helper.setText(R.id.tv_title,item.getSubject());

    }
}
