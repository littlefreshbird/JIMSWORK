package com.jims.work.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.adapter.MyFragmentPagerAdapter;

import java.util.ArrayList;

public class ServiceFragment extends Fragment   {
   // private View layout;
    private Resources mResources;
    private ViewPager mPager;
    private ArrayList<Fragment> mFragmentList;
    private ImageView mImgLine;
    private TextView one,mTxOne,mTxTwo,mTxThree;
    private Fragment oneFragment,twoFragment,threeFragment;
    private int mBottomLineWidth;
    private int mOffset = 0;
    private int mPositionOne,mPositionTwo;
    public final static int num = 3;
    private int mCurrentIndex = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_service, null);
        mResources = getResources();
        initTextView(view);
        initViewPager(view);
        initWidth(view);
        Animation animation = new TranslateAnimation(0, mOffset, 0, 0);
        animation.setFillAfter(true);
        animation.setDuration(0);
        mImgLine.startAnimation(animation);
        getActivity().getActionBar();


        return view;
    }
    private void initTextView(View parentView){
        /* one=(TextView)parentView.findViewById(R.id.one);
           one.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG );*/
        mTxOne = (TextView) parentView.findViewById(R.id.fragment_more_tab1);
        mTxTwo = (TextView) parentView.findViewById(R.id.fragment_more_tab2);
        mTxThree = (TextView) parentView.findViewById(R.id.fragment_more_tab3);

        mTxOne.setOnClickListener(new MyClickListener(0));
        mTxTwo.setOnClickListener(new MyClickListener(1));
        mTxThree.setOnClickListener(new MyClickListener(2));
    }

    private void initViewPager(View parentView){
        mPager = (ViewPager) parentView.findViewById(R.id.fragment_more_vp);
        mFragmentList = new ArrayList<Fragment>();

        oneFragment = new OneFragment();
        twoFragment = new TwoFragment();
        threeFragment = new ThreeFragment();

        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
        mFragmentList.add(threeFragment);

        mPager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), mFragmentList));
        mPager.setOnPageChangeListener(new MyOnPageChangeLisenter());
        mPager.setCurrentItem(0);
        mPager.setOffscreenPageLimit(3);
    }

    private void initWidth(View parentView){
        mImgLine = (ImageView) parentView.findViewById(R.id.fragment_more_img_line);
       mBottomLineWidth = mImgLine.getLayoutParams().width;
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;
        mOffset = (int)((screenW/num-mBottomLineWidth)/2);
        int avg = (int)screenW / num;
        mPositionOne = avg + mOffset;
        mPositionTwo = avg*2 + mOffset;
    }

    private class MyClickListener implements OnClickListener{
        private int index = 0;

        public MyClickListener(int i){
            index = i;
        }

        @Override
        public void onClick(View arg0) {
            // TODO Auto-generated method stub
            mPager.setCurrentItem(index);
        }
    }

    private class MyOnPageChangeLisenter implements OnPageChangeListener{

        @Override
        public void onPageScrollStateChanged(int arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onPageSelected(int arg0) {
            // TODO Auto-generated method stub
            Animation animation = null;
            switch(arg0){
                case 0:
                    if(mCurrentIndex == 1){
                        animation = new TranslateAnimation(mPositionOne, mOffset, 0, 0);
                        mTxTwo.setTextColor(mResources.getColor(R.color.black));
                    }else if(mCurrentIndex == 2){
                        animation = new TranslateAnimation(mPositionTwo, mOffset, 0, 0);
                        mTxThree.setTextColor(mResources.getColor(R.color.black));
                    }
                    mTxOne.setTextColor(mResources.getColor(R.color.red));
                    break;
                case 1:
                    if(mCurrentIndex == 0){
                        animation = new TranslateAnimation(mOffset, mPositionOne, 0, 0);
                        mTxOne.setTextColor(mResources.getColor(R.color.black));
                    }else if(mCurrentIndex == 2){
                        animation = new TranslateAnimation(mPositionTwo, mPositionOne, 0, 0);
                        mTxThree.setTextColor(mResources.getColor(R.color.black));
                    }
                    mTxTwo.setTextColor(mResources.getColor(R.color.red));
                    break;
                case 2:
                    if(mCurrentIndex == 1){
                        animation = new TranslateAnimation(mPositionOne, mPositionTwo, 0, 0);
                        mTxTwo.setTextColor(mResources.getColor(R.color.black));
                    }else if(mCurrentIndex == 0){
                        animation = new TranslateAnimation(mOffset,mPositionTwo,0,0);
                        mTxOne.setTextColor(mResources.getColor(R.color.black));
                    }
                    mTxThree.setTextColor(mResources.getColor(R.color.red));
                    break;
            }
            mCurrentIndex = arg0;
            animation.setFillAfter(true);
            animation.setDuration(300);
            mImgLine.startAnimation(animation);
        }

    }
}

