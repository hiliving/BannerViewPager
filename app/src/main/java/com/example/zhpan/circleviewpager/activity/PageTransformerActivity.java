package com.example.zhpan.circleviewpager.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.zhpan.circleviewpager.R;
import com.example.zhpan.circleviewpager.bean.DataBean;
import com.example.zhpan.circleviewpager.viewholder.DataViewHolder;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.transform.BookFlipPageFadePageTransformer;
import com.zhpan.bannerview.transform.DepthPageTransformer;
import com.zhpan.bannerview.transform.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class PageTransformerActivity extends AppCompatActivity {

    private BannerViewPager<DataBean, DataViewHolder> mViewpager;
    private List<DataBean> mDataList = new ArrayList<>();
    private String[] picUrls = {"http://pic31.nipic.com/20130801/11604791_100539834000_2.jpg",
            "http://pic37.nipic.com/20140115/7430301_100825571157_2.jpg",
            "http://pic29.nipic.com/20130507/8952533_183922555000_2.jpg",
            "http://b-ssl.duitang.com/uploads/item/201706/10/20170610095055_G5LM8.jpeg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_transformer);
        setTitle(R.string.title_view_pager);
        initData();
        initViewPager();
    }

    private void initViewPager() {
        mViewpager = findViewById(R.id.viewpager);
        mViewpager.showIndicator(false)
                .setCanLoop(false)
                .setAutoPlay(false)
                .setScrollDuration(1000)
                .setData(mDataList)
                .setPageTransformer(new BookFlipPageFadePageTransformer())
                .setHolderCreator(DataViewHolder::new)
                .setOnPageClickListener(position -> Toast.makeText(PageTransformerActivity.this,
                        "点击了图片" + position, Toast.LENGTH_SHORT).show())
                .create();
    }

    private void initData() {
        for (int i = 0; i < picUrls.length; i++) {
            DataBean dataBean = new DataBean(picUrls[i]);
            mDataList.add(dataBean);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViewpager.stopLoop();
    }
}
