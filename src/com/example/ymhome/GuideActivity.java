package com.example.ymhome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.ymhome.utils.Util;

import java.util.ArrayList;

/**
 * Created by Jyan on 2015/11/30.
 * Mail:jyan.lin@foxmail.com
 */
public class GuideActivity extends Activity {
    private static final int[] imageId = new int[]{R.drawable.guide_slide_page1, R.drawable.guide_slide_page2, R.drawable.guide_slide_page3, R.drawable.guide_slide_page4};
    private ViewPager vpGuide;
    private ArrayList<ImageView> imageViews;
    private LinearLayout ll_dot_group;
    private View dot_red;
    private Button btn_start;
    private int dotWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        vpGuide = (ViewPager) findViewById(R.id.vp_guide);
        ll_dot_group = (LinearLayout) findViewById(R.id.ll_dot_group);
        dot_red = findViewById(R.id.dot_red);
        btn_start = (Button) findViewById(R.id.btn_start);


        initView();
        vpGuide.setAdapter(new GuideAdapter());
        vpGuide.setOnPageChangeListener(new GuidePageListener());
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     * 初始化界面
     */
    private void initView() {
        imageViews = new ArrayList<ImageView>();

        //初始化引导页面
        for (int i = 0; i < imageId.length; i++) {
            //初始化页面背景
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageId[i]);
            imageViews.add(imageView);

            //初始化圆点
            View dot = new View(this);
            dot.setBackgroundResource(R.drawable.shape_dot_gray);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(Util.dp2px(this, 10), Util.dp2px(this, 10));
            if (i > 0) {
                params.leftMargin = Util.dp2px(this, 10); //设置圆点间隔
            }
            dot.setLayoutParams(params);
            ll_dot_group.addView(dot);
        }
        //获取视图树，监听layout结束后
        ll_dot_group.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ll_dot_group.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                dotWidth = ll_dot_group.getChildAt(1).getLeft() - ll_dot_group.getChildAt(0).getLeft();
            }
        });

    }

    /**
     * ViewPager适配器
     */
    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    /**
     * ViewPager滑动监听器
     */
    class GuidePageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int i, float v, int i1) {
            int len = (int) (dotWidth * v) + dotWidth * i;
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) dot_red.getLayoutParams();
            params.leftMargin = len;
            dot_red.setLayoutParams(params);
        }

        @Override
        public void onPageSelected(int i) {
            if (i == imageId.length - 1) {
                btn_start.setVisibility(View.VISIBLE);
            } else {
                btn_start.setVisibility(View.GONE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
