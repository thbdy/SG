package com.zhangf.unnamed.module.menu.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhangf.unnamed.R;
import com.zhangf.unnamed.base.BaseActivity;
import com.zhangf.unnamed.base.BaseResponse;
import com.zhangf.unnamed.http.eventbus.RedirectEvent;
import com.zhangf.unnamed.module.menu.presenter.SearchPresenter;
import com.zhangf.unnamed.module.menu.presenter.SearchPresenterImpl;
import com.zhangf.unnamed.utils.SPUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

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
    private String url = "http://bbs.sgamer.com/search.php?mod=forum";
    private String formhash;
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

        formhash = (String) SPUtils.get(mContext, "formhash", "");



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
                String content = etSearchContent.getText().toString().trim();
                String postData = "formhash=" + formhash + "&srchtxt=" + content + "&searchsubmit=yes";
                mPresenter.fetchSearch(formhash,content,"yes");
                break;
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
                    Elements elements = doc.getElementById("threadlist").select("ul").select("li");

                } catch (IOException e) {
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
       connectUrl(url+event.url);
    }
}
