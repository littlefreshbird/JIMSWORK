package com.jims.work;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jims.work.fragment.OneFragment;
import com.jims.work.fragment.ThreeFragment;
import com.jims.work.fragment.TwoFragment;

/**
 * Created by Just on 2017/1/5.
 */
public class MyServiceActivity extends AppCompatActivity {
    private OneFragment f1 = new OneFragment();
    private TwoFragment f2 = new TwoFragment();
    private ThreeFragment f3 = new ThreeFragment();

    private static final int TAB_INDEX_COUNT = 3;
    private static final int TAB_INDEX_ONE = 0;
    private static final int TAB_INDEX_TWO = 1;
    private static final int TAB_INDEX_THREE = 2;

    private ViewPager mViewPager;
    private ViewPagerAdapter mViewPagerAdapter;

    private int[] mainGridView = new int[3];
    private int[] mainGridViewSelected = new int[3];
    private GridView gridView;
    private MainAdapter mainAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myservice);
        initValues();
        findViews();
        setValues();
        setUpViewPager();
        setListeners();
        setCustomActionBar();
    }

    private void initValues() {
        mainGridView[0] = R.mipmap.main_index;
        mainGridView[1] = R.mipmap.main_two;
        mainGridView[2] = R.mipmap.main_index;
        mainGridViewSelected[0] = R.mipmap.main_index_select;
        mainGridViewSelected[1] = R.mipmap.main_two_select;
        mainGridViewSelected[2] = R.mipmap.main_index_select;
    }

    private void findViews() {
        mViewPager = (ViewPager) findViewById(R.id.pager);
        gridView = (GridView) findViewById(R.id.gv_main_footer_menu);
    }

    private void setValues() {
        mainAdapter = new MainAdapter(this);
        gridView.setAdapter(mainAdapter);
        gridView.setNumColumns(3);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setGravity(Gravity.CENTER);
    }

    private void setListeners() {
        gridView.setOnItemClickListener(gridViewOnClick);
        mViewPager.setOnPageChangeListener(viewPagerOnPageChange);
    }

    private SimpleOnPageChangeListener viewPagerOnPageChange = new ViewPager.SimpleOnPageChangeListener() {
        public void onPageSelected(int position) {

            LinearLayout temp = (LinearLayout) gridView.getChildAt(position);
            ImageView ig = (ImageView) temp.getChildAt(0);
            ig.setImageResource(mainGridViewSelected[position]);
            for (int i = 0; i < mainGridView.length; i++) {
                if (i != position) {
                    LinearLayout temp2 = (LinearLayout) gridView.getChildAt(i);
                    ImageView ig2 = (ImageView) temp2.getChildAt(0);
                    ig2.setImageResource(mainGridView[i]);
                }
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            switch (state) {
                case ViewPager.SCROLL_STATE_IDLE:
                    break;
                case ViewPager.SCROLL_STATE_DRAGGING:
                    break;
                case ViewPager.SCROLL_STATE_SETTLING:
                    break;
                default:
                    break;
            }
        }
    };

    private OnItemClickListener gridViewOnClick = new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                long arg3) {
            // TODO Auto-generated method stub
               mViewPager.setCurrentItem(arg2, true);
        }
    };

    private void setUpViewPager() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mViewPagerAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    public class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int position) {
            // TODO Auto-generated method stub
            switch (position) {
                case TAB_INDEX_ONE:
                    return f1;
                case TAB_INDEX_TWO:
                    return f2;
                case TAB_INDEX_THREE:
                    return f3;
            }
            throw new IllegalStateException("No fragment at position "
                    + position);

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return TAB_INDEX_COUNT;
        }

    }

    private class MainAdapter extends BaseAdapter {

        private LayoutInflater mInflater;

        public MainAdapter(Context ctx) {
            this.mInflater = LayoutInflater.from(ctx);
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return mainGridView.length;
        }

        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            MainViewHolder viewHolder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item_main_image, null);
                viewHolder = new MainViewHolder();
                viewHolder.imageView = (ImageView) convertView
                        .findViewById(R.id.iv_main_img);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (MainViewHolder) convertView.getTag();
            }
            if (position == 0) {
                viewHolder.imageView
                        .setImageResource(mainGridViewSelected[position]);
            } else {
                viewHolder.imageView.setImageResource(mainGridView[position]);
            }
            return convertView;
        }

    }

    private final class MainViewHolder {
        private ImageView imageView;
        private String string;
    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_service, null);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.action_bar_back);
        actionBar.setElevation(2);
    }
    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent1=new Intent(MyServiceActivity.this,MainActivity.class);//点击回主页
                startActivity(intent1);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
