package com.zhangf.unnamed.module.main.view;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.maning.imagebrowserlibrary.MNImageBrowser;
import com.maning.imagebrowserlibrary.listeners.OnLongClickListener;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhangf.unnamed.R;
import com.zhangf.unnamed.adapter.ThemeListAdapter;
import com.zhangf.unnamed.base.BaseFragment;
import com.zhangf.unnamed.base.BaseResponse2;
import com.zhangf.unnamed.module.main.model.GetAllResult;
import com.zhangf.unnamed.module.main.model.SignResult;
import com.zhangf.unnamed.module.main.model.ThemeListResult;
import com.zhangf.unnamed.module.main.presenter.ForumPresenter;
import com.zhangf.unnamed.module.main.presenter.ForumPresenterImpl;
import com.zhangf.unnamed.utils.GlideImageEngine;
import com.zhangf.unnamed.utils.SaveImg;
import com.zhangf.unnamed.utils.ToastUtil;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 75232 on 2018/9/6
 * Email：752323877@qq.com
 */
public class ForumFragment extends BaseFragment<ForumPresenterImpl> implements ForumPresenter.View, OnLongClickListener, OnRefreshListener, OnLoadMoreListener {
    @BindView(R.id.rv_data)
    RecyclerView rvData;
    /**
     * 下拉刷新
     */
    @BindView(R.id.smart_refresh_layout)
    SmartRefreshLayout smartRefreshLayout;
    /**
     * 旋转动画
     */
    private ObjectAnimator mRotationAni;
    @BindView(R.id.fab_refresh)
    FloatingActionButton mFabRefresh;
    /**
     * 板块ID
     */
    private String mFid = "283";
    /**
     * 帖子图片数据源
     */
    private ArrayList<String> imageList = new ArrayList<>();
    /**
     * 适配器
     */
    private ThemeListAdapter themeListAdapter;
    /**
     * 数据源
     */
    private List<ThemeListResult.ForumThreadlistBean> threadlistBeanList = new ArrayList<>();
    private Bitmap mBitmap;
    private String mPicName;
    private static final int PERMISSION_REQUEST_CODE = 10086;
    /**
     * 当前页数
     */
    private int mPage = 1;


    @Override
    protected void initData() {
        mPresenter.fetchThemeList("283", String.valueOf(mPage));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_forum;
    }

    @Override
    protected void initView() {
        initAni();

        rvData.setLayoutManager(new LinearLayoutManager(mContext));
        smartRefreshLayout.setOnRefreshListener(this);
        smartRefreshLayout.setOnLoadMoreListener(this);
//        //tab可滚动
//        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
//        tabLayout.addOnTabSelectedListener(this);


        themeListAdapter = new ThemeListAdapter(threadlistBeanList);
        themeListAdapter.bindToRecyclerView(rvData);


        themeListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public boolean onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_head) {
                    Intent intent = new Intent(mContext, UserHomePagerActivity.class);
                    intent.putExtra("uid", threadlistBeanList.get(position).getAuthorid());
                    startActivity(intent);
                }
                if (view.getId() == R.id.iv_index) {
                    showImageBrowseDialog(position);
                }
                return false;
            }
        });
        themeListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(mContext, ThreadActivity.class);
                intent.putExtra("tid", threadlistBeanList.get(position).getTid());
                startActivity(intent);
            }
        });
    }

    @Override
    protected ForumPresenterImpl initPresenter() {
        return new ForumPresenterImpl(this);
    }

    @Override
    public void showGetAll(BaseResponse2<GetAllResult> result) {

    }

    @Override
    public void showThemeList(BaseResponse2<ThemeListResult> result) {
        if (mPage == 1) {
            mRotationAni.cancel();
            smartRefreshLayout.finishRefresh(0);
        } else {
            smartRefreshLayout.finishLoadMore();
        }
        if (result.getRequest_id().equals("0") && result.getVariables().getForum_threadlist().size() > 0) {
            if (mPage == 1) {
                threadlistBeanList.clear();
            }
            threadlistBeanList.addAll(result.getVariables().getForum_threadlist());

//            for(ThemeListResult.ForumThreadlistBean t: threadlistBeanList){
//                Log.e(TAG, "showThemeList: "+t.toString());
//                Log.e(TAG, "********************************************" );
//            }
            int index = 0;
            for (int i = 0; i < threadlistBeanList.size(); i++) {
                if (threadlistBeanList.get(i).getTypeid().equals("2") ||
                        threadlistBeanList.get(i).getHighlight() != null) {
                    index = i;
                }
            }
            //移除置顶
            if (mPage == 1) {
                for (int i = 0; i <= index; i++) {
                    threadlistBeanList.remove(0);
                }
            }
            themeListAdapter.notifyDataSetChanged();
            if (mPage == 1) {
                rvData.smoothScrollToPosition(0);
            }
        } else {
            mPage--;
            Toast.makeText(mContext, "错误", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showSign(SignResult result) {

    }

    private boolean checkPermission() {
        List<String> permissionLists = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionLists.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionLists.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionLists.isEmpty()) {//说明肯定有拒绝的权限
            ActivityCompat.requestPermissions(getActivity(), permissionLists.toArray(new String[permissionLists.size()]), PERMISSION_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * 图片浏览弹窗
     *
     * @param position
     */
    private void showImageBrowseDialog(int position) {
        ArrayList<String> mImageList = new ArrayList<>();
        imageList.clear();
        imageList.addAll(threadlistBeanList.get(position).getAttachment_urls());
        for (String entity : threadlistBeanList.get(position).getAttachment_urls()) {
            if (entity.contains("url=")) {
                mImageList.add(URLDecoder.decode(entity.split("url=")[1]));
            } else {
                mImageList.add(entity);
            }
        }
        for (String s : mImageList) {
            Log.e(TAG, "原图地址: " + s);
        }

        MNImageBrowser.with(mContext)
                .setCurrentPosition(0)
                .setImageEngine(new GlideImageEngine())
                .setOnLongClickListener(this)
                .setImageList(mImageList)
                .setIndicatorHide(false)
                .show(rvData);
    }

    @Override
    public void onLongClick(FragmentActivity fragmentActivity, ImageView imageView, int i, String s) {
        //处理GIF
        if (s.endsWith(".gif")) {
            ToastUtil.showToast(mContext, "暂时不支持保存GIF图片");
        } else {
            Glide.with(mContext).load(s).asBitmap().into(new SimpleTarget<Bitmap>() {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    mPicName = String.valueOf(System.currentTimeMillis()) + ".jpeg";
                    mBitmap = resource;
                    if (checkPermission()) { //有读写权限
                        boolean hasSaved = SaveImg.saveImg(resource, mPicName, mContext);
                        if (hasSaved) {
                            ToastUtil.showToast(mContext, "已保存至相册^.^");
                        }
                    }

                }
            });
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0) {
                    for (int grantResult : grantResults) {
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
//                            Toast.makeText(this, "某一个权限被拒绝了", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    boolean hasSaved = SaveImg.saveImg(mBitmap, mPicName, mContext);
                    if (hasSaved) {
                        ToastUtil.showToast(mContext, "已保存至相册^.^");
                    }
                }
                break;
            default:
                break;
        }
    }
    /**
     * 初始化动画
     */
    private void initAni() {
        mRotationAni = ObjectAnimator.ofFloat(mFabRefresh, "rotation", 0, 360);
        mRotationAni.setDuration(500);
        mRotationAni.setRepeatCount(ValueAnimator.INFINITE);//无限循环
    }
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPage = 1;
        mPresenter.fetchThemeList(mFid, String.valueOf(mPage));
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        mPage++;
        mPresenter.fetchThemeList(mFid, String.valueOf(mPage));
    }

    @OnClick({R.id.fab_refresh})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.fab_refresh:
                mRotationAni.start();
                mPage = 1;
                mPresenter.fetchThemeList(mFid, String.valueOf(mPage));
                break;
        }

    }
}
