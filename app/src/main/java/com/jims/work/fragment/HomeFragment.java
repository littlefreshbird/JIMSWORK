package com.jims.work.fragment;


import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jims.work.R;
import com.jims.work.fragment.base.BaseFragment;

/**
 * Created by gong on 2016/12/27.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    private ViewPager mPager;
    private int[] mBanner = new int[]{R.drawable.img_home_banner1,
            R.drawable.img_home_banner2, R.drawable.img_home_banner3,
            R.drawable.img_home_banner4};

    private ImageView mImageView;
    private ImageView mImgCover;
    private int mLastPos;// 记录上一次ViewPager的位置
    private boolean isDragging;// 是否被拖拽
    private boolean isFoucusRight; // ScrollView是否滚动到右侧
    private View layout;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (layout != null) {
            // 防止多次new出片段对象，造成图片错乱问题
            return layout;
        }
        layout = inflater.inflate(R.layout.fragment_home, container, false);
        initView();
        initPager();
        autoScroll();

        return layout;
    }

    private void initView() {

        mImgCover = (ImageView) layout.findViewById(R.id.img_cover);
        mImageView = (ImageView) layout.findViewById(R.id.img_indicator01);

    }

   /* private void activeCategory() {
        MainActivity activity = (MainActivity) getActivity();
        activity.activeCategory();
    }*/


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 将layout从父组件中移除
        ViewGroup parent = (ViewGroup) layout.getParent();
        parent.removeView(layout);
    }

    private void initPager() {
        mPager = (ViewPager) layout.findViewById(R.id.pager_banner);
        FragmentManager fm = getChildFragmentManager();
        MyPagerAdapter adapter = new MyPagerAdapter(fm);
        mPager.setAdapter(adapter);
        mPager.setCurrentItem(1000);
        mPager.setOnPageChangeListener(new MyPagerListener());
    }

    /**
     * 自动滚动
     */
    private void autoScroll() {
        mPager.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!isDragging) {
                    // 若用户没有拖拽，则自动滚动
                    mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                }

                isFoucusRight = !isFoucusRight;
                mPager.postDelayed(this, 3000);
            }
        }, 3000);









 /*   @Override
    public void onClick(View v) {
        switch (v.getId()) {
           *//* case R.id.img_home_category: // 切换到分类
                activeCategory();
                break;*//*
           // case R.id.img_home_search_code: // 二维码扫描
              //  ((MainActivity) getActivity()).scanQRCode();
               // break;



            default:
                break;
        }
    }*/
/*
    *//**
         * 转到商品详情
         *//*
    private void gotoDetail(int index) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(Constants.INTENT_KEY.INFO_TO_DETAIL, mInfos[index]);
        startActivity(intent);
    }

    private void gotoSearch() {
        Intent intent = new Intent(getActivity(), SearchActivity.class);
        startActivity(intent);
        // activity开启无动画
        getActivity().overridePendingTransition(0, 0);
    }

    private class GetDataTask extends AsyncTask<Void, Void, String[]> {
        protected String[] doInBackground(Void... params) {
            // 下拉刷新
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            return null;
        }



    }*/


    }

    @Override
    public void onClick(View view) {

    }

    private class MyPagerAdapter  extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BannerItemFragment fragment = new BannerItemFragment();
            fragment.setResId(mBanner[position % mBanner.length]);
            // fragment.setGoodsInfo(mInfos[position % mBanner.length]);
            return fragment;
        }

        @Override
        public int getCount() {
            return 10000;
        }

    }

    private class MyPagerListener implements   ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset,
                                   int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            int width = mImgCover.getWidth();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) mImageView
                    .getLayoutParams();
            int rightMargin = layoutParams.rightMargin;
            int endPos = (width + rightMargin) * (position % 4);
            int startPos = 0;
            if (mLastPos < position) {
                // 图片向右移动
                startPos = (width + rightMargin) * (position % 4 - 1);
            } else {
                // 图片向左移动
                startPos = (width + rightMargin) * (position % 4 + 1);
            }
            ObjectAnimator.ofFloat(mImgCover, "translationX", startPos, endPos)
                    .setDuration(300).start();
            mLastPos = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_DRAGGING:
                    // 用户拖拽
                    isDragging = true;
                    break;
                case ViewPager.SCROLL_STATE_IDLE:
                    // 空闲状态
                    isDragging = false;
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    // 被释放时
                    isDragging = false;
                    break;

                default:
                    break;
            }
        }
    }

