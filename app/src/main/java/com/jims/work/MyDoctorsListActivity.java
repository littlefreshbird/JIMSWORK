package com.jims.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jims.work.bean.MyDoctorsInfor;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyDoctorsListActivity extends Activity implements
        View.OnClickListener {

    private ArrayList<MyDoctorsInfor> goodsList = new ArrayList<MyDoctorsInfor>();
    private ArrayList<MyDoctorsInfor> goodsListCopy = new ArrayList<MyDoctorsInfor>();    //备份，用于排序后恢复

    private GoodsListAdapter mListAdapter;
    private ImageView mImgOverlay, mImgMORE;
    private MyListView mListView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydoctors);
        initGoods();
        initView();
        setOnListener();
        initListView();
        mProgressBar.setVisibility(View.GONE);
    }

    private void initGoods() {
        goodsList.add(new MyDoctorsInfor("李云龙", "承德附属医院", "心血管内科", "副主任医师", "100001", "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1471855743&di=f63c2ee8173acac5df640d73e7e48827&src=http://p.3761.com/pic/88711413852949.jpg", "已关注", ""));
        goodsList.add(new MyDoctorsInfor("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1471853209&di=c7c5b93eb5398edee0d5ff1e6083358b&src=http://p.3761.com/pic/70691413852950.jpg", "", "已订阅"));
        goodsList.add(new MyDoctorsInfor("周慧敏", "承德妇幼保健院", "小儿科", "副主任医师", "100003", "http://img5.imgtn.bdimg.com/it/u=43321951,2217292456&fm=21&gp=0.jpg", "已关注", "已订阅"));

        goodsListCopy.addAll(goodsList);
    }


    /**
     * 设置菜单宽度
     */
    @Override
    protected void onResume() {
        super.onResume();

    }


    private void setOnListener() {
        mImgOverlay.setOnClickListener(this);
        findViewById(R.id.toolbar_profile_back).setOnClickListener(this);
        mImgMORE.setOnClickListener(this);
        findViewById(R.id.toolbar_profile_more).setOnClickListener(this);

    }

    private void initView() {
        mImgOverlay = (ImageView) findViewById(R.id.img_overlay);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
        mImgMORE = (ImageView) findViewById(R.id.toolbar_profile_more);

    }

    private void initListView() {
        mListView = (MyListView) findViewById(R.id.listView1);

        mListAdapter = new GoodsListAdapter();
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyDoctorsInfor info = goodsList.get(position);
                // gotoDetail(info);
            }
        });
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });
        // 向上滚动后右下角出现回到顶部按钮
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if (firstVisibleItem > 0) {
                    mImgOverlay.setVisibility(View.VISIBLE);
                } else {
                    mImgOverlay.setVisibility(View.INVISIBLE);
                }
            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

        });


    }

    /**
     * 商品详情
     * @param info
     */
   /* private void gotoDetail(MyDoctorsInfor info) {
        Intent intent = new Intent(this, DoctorsDetailActivity.class);

        startActivity(intent);
    }*/

    /**
     * 将二级菜单的选择结果设置给一级菜单
     *
     * @param
     */
//	public void setSelectedResult(String result) {
//		filterMenuFragment.setSelectedResult(result);
//	}

    class GoodsListAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            ViewHolder holder = null;
            if (convertView == null) {
                inflate = getLayoutInflater().inflate(
                        R.layout.item_mydoctors_list, null);

                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            MyDoctorsInfor DoctorsInfo = goodsList.get(position);
            if (DoctorsInfo.getBuy().equals("")) {
                holder.tvBuy.setVisibility(View.GONE);
            } else {
                holder.tvBuy.setText(DoctorsInfo.getBuy());
            }

            if (DoctorsInfo.getAttention().equals("")) {
                holder.tvAttention.setVisibility(View.GONE);
            } else {
                holder.tvAttention.setText(DoctorsInfo.getAttention());
            }


            holder.tvName.setText(DoctorsInfo.getNames());
            holder.tvClasses.setText(DoctorsInfo.getClasses());
            holder.tvHospital.setText(DoctorsInfo.getHospital());
            holder.tvPosition.setText(DoctorsInfo.getPosition());
            // UILUtils.displayImage(MyDoctorsListActivity.this, DoctorsInfo.getIcon(), holder.imgIcon);

            return inflate;
        }

        @Override
        public int getCount() {
            return goodsList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

    }
        static class ViewHolder {
            @BindView(R.id.img_icon)
            ImageView imgIcon;
            @BindView(R.id.tv_name)
            TextView tvName;
            @BindView(R.id.tv_buy)
            TextView tvBuy;
            @BindView(R.id.tv_attention)
            TextView tvAttention;
            @BindView(R.id.tv_hospital)
            TextView tvHospital;
            @BindView(R.id.tv_classes)
            TextView tvClasses;
            @BindView(R.id.tv_position)
            TextView tvPosition;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.img_overlay:
                mListView.setSelection(0);

                break;

            case R.id.toolbar_profile_back: // 返回
                finish();
                break;
            case R.id.toolbar_profile_more://添加我的医生
                Intent intent = new Intent(MyDoctorsListActivity.this,
                        DoctorClassActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }


    public void toggleFilterMenu() {
//		mDrawer.toggleMenu();
    }

    private void gotoSearch() {
//		Intent intent = new Intent(this, SearchActivity.class);
//		startActivity(intent);
//		// activity开启无动画
//		overridePendingTransition(0, 0);
    }


}
