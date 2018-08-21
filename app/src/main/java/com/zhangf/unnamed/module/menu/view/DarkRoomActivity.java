package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.DarkRoomAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BasePresenter;
import com.zhangf.unnamed.module.menu.model.DarkRoomEntity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 小黑屋
 * Created by 75232 on 2018/8/21
 * Email：752323877@qq.com
 */
public class DarkRoomActivity extends BaseActivity {

    @BindView(R.id.rv_dark_room)
    RecyclerView rvDarkRoom;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    private String mUrl = "http://bbs.sgamer.com/forum.php?mod=misc&action=showdarkroom";

    private List<DarkRoomEntity> mDarkRoomEntityList = new ArrayList<>();

    private DarkRoomAdapter darkRoomAdapter;
    private MyHandler myHandler;


    @Override
    protected void initToolBar(Bundle savedInstanceState) {
        tvTitle.setText("小黑屋");
        ivBack.setVisibility(View.VISIBLE);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_dark_room;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        darkRoomAdapter = new DarkRoomAdapter(R.layout.item_dark_room, mDarkRoomEntityList);
        rvDarkRoom.setLayoutManager(new LinearLayoutManager(this));
        rvDarkRoom.setAdapter(darkRoomAdapter);

    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        this.finish();
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            darkRoomAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void initData() {
        myHandler = new MyHandler();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(mUrl).get();
                    Elements elements = doc.select("table").select("tr");

                    for (int i = 1; i < elements.size(); i++) {
                        DarkRoomEntity darkRoomEntity = new DarkRoomEntity();
                        darkRoomEntity.setUserName(elements.get(i).select("td").get(0).text());
                        darkRoomEntity.setAction(elements.get(i).select("td").get(1).text());
                        darkRoomEntity.setEndTime(elements.get(i).select("td").get(2).text());
                        darkRoomEntity.setActionTime(elements.get(i).select("td").get(3).text());
                        darkRoomEntity.setActionReason(elements.get(i).select("td").get(4).text());
                        mDarkRoomEntityList.add(darkRoomEntity);
                    }
                    myHandler.sendEmptyMessage(0);


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
