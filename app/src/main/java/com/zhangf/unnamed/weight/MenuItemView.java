package com.zhangf.unnamed.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhangf.unnamed.R;


/**
 * Created on 2017/10/25.
 */

public class MenuItemView extends LinearLayout {
    private TextView tvMessageTip;
    ImageView itemImageView;
    TextView itemNameView;
    private Context mContext;

    public MenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_menu_layout, this, true);
        itemImageView = view.findViewById(R.id.item_img);
        itemNameView = view.findViewById(R.id.item_name);
        tvMessageTip = view.findViewById(R.id.tv_message_tip);
        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.MineItemView);

        String itemName = typedArray.getString(R.styleable.MineItemView_title);
        int drawableId = typedArray.getResourceId(R.styleable.MineItemView_img_res, R.mipmap.ic_launcher);
        boolean showTip = typedArray.getBoolean(R.styleable.MineItemView_showTip,false);
        if(showTip){
            tvMessageTip.setVisibility(VISIBLE);
        }else {
            tvMessageTip.setVisibility(GONE);
        }


        itemImageView.setBackgroundResource(drawableId);
        itemNameView.setText(itemName);
        typedArray.recycle();
    }

}
