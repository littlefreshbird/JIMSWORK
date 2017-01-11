package com.jims.work.fragment;


import android.animation.ObjectAnimator;
import android.content.Intent;
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
import android.widget.TextView;

import com.jims.work.CaseLoadingActivity;
import com.jims.work.CityPositionActivity;
import com.jims.work.DoctorClassActivity;
import com.jims.work.FreeTreatActivity;
import com.jims.work.MyDoctorsListActivity;
import com.jims.work.PostActivity;
import com.jims.work.R;
import com.jims.work.view.UPMarqueeView;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private ViewPager mPager;
    private int[] mBanner = new int[]{R.drawable.img_home_banner1,
            R.drawable.img_home_banner2, R.drawable.img_home_banner3,
            R.drawable.img_home_banner4};
    private TextView mTextview;
    private ImageView mImageView;
    private ImageView mImgCover;
    private TextView mTextView;
    private int mLastPos;// 记录上一次ViewPager的位置
    private boolean isDragging;// 是否被拖拽
    private boolean isFoucusRight; // ScrollView是否滚动到右侧
    private View layout;

    private UPMarqueeView upview1;
    List<String> data = new ArrayList<>();
    List<View> upviews = new ArrayList<>();

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
        initParam();
        initdata();
        initupView();
        setOnListener();
        return layout;

    }

    private void initView() {

        mImgCover = (ImageView) layout.findViewById(R.id.img_cover);
        mImageView = (ImageView) layout.findViewById(R.id.img_indicator01);

       mTextview = (TextView) layout.findViewById(R.id.top_title_text);
        mTextview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(), CityPositionActivity.class));
               getActivity().finish();

            }
        });

    }

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
    }
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


    private class MyPagerAdapter extends FragmentStatePagerAdapter {

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

    private class MyPagerListener implements ViewPager.OnPageChangeListener {

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

    /**
     * 实例化控件
     */
    private void initParam() {
        upview1 = (UPMarqueeView) layout.findViewById(R.id.upview1);
    }

    /**
     * 初始化数据
     */
    private void initdata() {
        data = new ArrayList<>();
        data.add("家人给2岁孩子喝这个，孩子智力倒退10岁!!!");
        data.add("冬季养生的方法和要点！");
        data.add("为什么你的黑眼圈总是消不掉？");
        data.add("有关咳嗽的30个常见问题！");
        data.add("雾霾持续加重，哪些措施能保护我们？");
        data.add("冬季为何是哮喘发作的高峰期！");

    }

    /**
     * 初始化界面程序
     */
    private void initupView() {
        setView();
        upview1.setViews(upviews);
        /**
         * 设置item_view的监听
         */
        upview1.setOnItemClickListener(new UPMarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {

            }
        });
    }

    /**
     * 初始化需要循环的View
     * 为了灵活的使用滚动的View，所以把滚动的内容让用户自定义
     * 假如滚动的是三条或者一条，或者是其他，只需要把对应的布局，和这个方法稍微改改就可以了，
     */
    private void setView() {
        for (int i = 0; i < data.size(); i = i + 2) {
            final int position = i;
            //设置滚动的单个布局
            LinearLayout moreView = (LinearLayout) LayoutInflater.from(getActivity()).inflate(R.layout.item_upview, null);
            //初始化布局的控件
            TextView tv1 = (TextView) moreView.findViewById(R.id.tv1);
            TextView tv2 = (TextView) moreView.findViewById(R.id.tv2);

            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            /**
             * 设置监听
             */
            moreView.findViewById(R.id.rl2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
            //进行对控件赋值
            tv1.setText(data.get(i).toString());
            if (data.size() > i + 1) {
                //因为淘宝那儿是两条数据，但是当数据是奇数时就不需要赋值第二个，所以加了一个判断，还应该把第二个布局给隐藏掉
                tv2.setText(data.get(i + 1).toString());
            } else {
                moreView.findViewById(R.id.rl2).setVisibility(View.GONE);
            }

            //添加到循环滚动数组里面去
            upviews.add(moreView);
        }
    }

    private void setOnListener() {

        layout.findViewById(R.id.quick_ask).setOnClickListener(this);

        layout.findViewById(R.id.quick_find).setOnClickListener(this);
        layout.findViewById(R.id.layout_case_uploading).setOnClickListener(this);
        layout.findViewById(R.id.layout_special1).setOnClickListener(this);
        layout.findViewById(R.id.layout_special2).setOnClickListener(this);
        layout.findViewById(R.id.layout_special3).setOnClickListener(this);
        layout.findViewById(R.id.layout_special4).setOnClickListener(this);
        layout.findViewById(R.id.layout_freetreat).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.top_title_text: // 城市定位
                startActivity(new Intent(getActivity(), CityPositionActivity.class));
               // getActivity().finish();
                break;*/

            case R.id.quick_ask: // 快速问诊
                startActivity(new Intent(getActivity(), PostActivity.class));
                //getActivity().finish();
                break;
            case R.id.quick_find: // 查找医生
                startActivity(new Intent(getActivity(), DoctorClassActivity.class));
                break;
            case R.id.layout_case_uploading: // 病例上传
                startActivity(new Intent(getActivity(), CaseLoadingActivity.class));
                break;
            case R.id.layout_special1: //
                startActivity(new Intent(getActivity(), DoctorClassActivity.class));
                break;
            case R.id.layout_special2: // 我的医生
                startActivity(new Intent(getActivity(), MyDoctorsListActivity.class));
                break;
            case R.id.layout_special3: //
                startActivity(new Intent(getActivity(), MyDoctorsListActivity.class));
                break;
            case R.id.layout_special4: //
                startActivity(new Intent(getActivity(), MyDoctorsListActivity.class));
                break;
            case R.id.layout_freetreat: //义诊
                startActivity(new Intent(getActivity(), FreeTreatActivity.class));
                break;

            case R.id.img_home_search_code: // 二维码扫描
                // ((MainActivity) getActivity()).scanQRCode();
                break;
            default:
                break;
        }
    }
}