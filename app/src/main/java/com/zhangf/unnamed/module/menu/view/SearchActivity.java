package com.zhangf.unnamed.module.menu.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.ThemeListAdapter;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.http.eventbus.RedirectEvent;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.view.ThreadActivity;
import com.zhangf.unnamed.module.main.view.UserHomePagerActivity;
import com.zhangf.unnamed.module.menu.presenter.SearchPresenter;
import com.zhangf.unnamed.module.menu.presenter.SearchPresenterImpl;
import com.zhangf.unnamed.utils.SPUtils;
import com.zhangf.unnamed.utils.ToastUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 75232 on 2018/8/20
 */
public class SearchActivity extends BaseActivity<SearchPresenterImpl> implements SearchPresenter.View {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.et_search_content)
    EditText etSearchContent;
    @BindView(R.id.btn_search)
    Button btnSearch;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;
    private String url = "http://bbs.sgamer.com/search.php?mod=forum";
    private MyHandler myHandler;
    private String avatarUrl[] = {"http://u.sgamer.com/uc_server/data/avatar/","_avatar_big.jpg"};
    private String formhash;
    /**
     * 适配器
     */
    private ThemeListAdapter themeListAdapter;
    /**
     * 数据源
     */
    private List<ThemeListResult.ForumThreadlistBean> threadlistBeanList = new ArrayList<>();

    @Override
    protected void initToolBar(Bundle savedInstanceState) {
        tvTitle.setText("搜索帖子");
        ivBack.setVisibility(View.VISIBLE);
        EventBus.getDefault().register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_my_focus;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        myHandler = new MyHandler();
        formhash = (String) SPUtils.get(mContext, "formhash", "");

        rvSearch.setLayoutManager(new LinearLayoutManager(this));

        themeListAdapter = new ThemeListAdapter(threadlistBeanList);
        rvSearch.setAdapter(themeListAdapter);

        themeListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ThreadActivity.class);
                intent.putExtra("tid", threadlistBeanList.get(position).getTid());
                startActivity(intent);
            }
        });
        themeListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if(view.getId() == R.id.iv_head){
                    Intent intent = new Intent(mContext,UserHomePagerActivity.class);
                    intent.putExtra("uid",threadlistBeanList.get(position).getAuthorid());
                    startActivity(intent);
                }
                return false;
            }
        });
    }


    @Override
    protected void initData() {

    }

    @Override
    protected SearchPresenterImpl initPresenter() {
        return new SearchPresenterImpl(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_search, R.id.iv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.btn_search:
                showLoadingDialog("正在搜索");
                String content = etSearchContent.getText().toString().trim();
                String postData = "formhash=" + formhash + "&srchtxt=" + content + "&searchsubmit=yes";
                mPresenter.fetchSearch(formhash,content,"yes");
                break;
        }
    }

    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            dismissLoadingDialog();
            if(msg.what == 0){
                themeListAdapter.notifyDataSetChanged();
                rvSearch.smoothScrollToPosition(0);
            }else {
                ToastUtil.showToast(mContext,"没有查询到相关内容");
            }
        }
    }




    /**
     * 请求搜索链接
     */
    private void connectUrl(final String url) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(url).get();
                    Element element = doc.getElementById("threadlist");
                    if(null != element){
                        Elements elements = element.select("ul").select("li");
                        threadlistBeanList.clear();
                        for(int i=0;i<elements.size();i++){
                            ThemeListResult.ForumThreadlistBean bean = new ThemeListResult.ForumThreadlistBean();
                            bean.setTid(elements.get(i).id());
                            String viewAndReply = elements.get(i).select("p").get(0).text();
                            String reply = viewAndReply.split(" 个回复")[0];
                            String views = viewAndReply.split(" 个回复 - ")[1].split(" 次查看")[0];
                            bean.setViews(views);
                            bean.setReplies(reply);
                            bean.setLastpost(elements.get(i).select("span").get(0).text());
                            bean.setSubject(elements.get(i).select("a").get(0).text());
                            bean.setAuthor(elements.get(i).select("a").get(1).text());

                            String avar = elements.get(i).select("a").get(1).attr("href");
                            String uid = avar.split("space-uid-")[1].split(".html")[0];
                            bean.setAuthorid(uid);
                            for(int j = uid.length();j<9;j++){
                                uid = "0"+uid;
                            }
                            StringBuilder  sb = new StringBuilder (uid);
                            sb.insert(3,"/");
                            sb.insert(6,"/");
                            sb.insert(9,"/");
                            String realUrl = avatarUrl[0]+sb.toString()+avatarUrl[1];
                            bean.setAvatar(realUrl);
                            threadlistBeanList.add(bean);
                        }
                        myHandler.sendEmptyMessage(0);
                    }else {
                        myHandler.sendEmptyMessage(1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    @Override
    public void showSearch(BaseResponse result) {


    }
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void messageEventBus(RedirectEvent event){
        Log.i(TAG, "重定向的地址:  "+url+event.url);
       connectUrl(url+event.url);
    }
}
