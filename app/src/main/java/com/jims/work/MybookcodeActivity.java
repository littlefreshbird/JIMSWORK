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

import com.jims.work.bean.MyBookcodeInfor;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

public class MybookcodeActivity extends Activity implements View.OnClickListener {

    private ArrayList<MyBookcodeInfor> goodsList = new ArrayList<MyBookcodeInfor>();
    private ArrayList<MyBookcodeInfor> goodsListCopy = new ArrayList<MyBookcodeInfor>();	//备份，用于排序后恢复

    private GoodsListAdapter mListAdapter;
    private ImageView mImgOverlay;
    private MyListView mListView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mybookcode);
        initGoods();
        initView();
        setOnListener();
        initListView();
        mProgressBar.setVisibility(View.GONE);
    }

    private void initGoods() {
        goodsList.add(new MyBookcodeInfor("承德附属第一医院","心血管内科","李云龙","15元",  "2017-3-15", "张三"));
        goodsList.add(new MyBookcodeInfor("承德市双滦区医院","神经内科","李运昌","15元",  "2017-3-18", "周洁"));
        goodsList.add(new MyBookcodeInfor("承德附属第一医院","心血管内科","周慧敏","15元",  "2017-3-20", "张黎明"));

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

    }

    private void initView() {
        mImgOverlay = (ImageView) findViewById(R.id.img_overlay);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

    }

    private void initListView() {
        mListView = (MyListView) findViewById(R.id.listView1);

        mListAdapter = new GoodsListAdapter();
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyBookcodeInfor Infor = goodsList.get(position);
                gotoDetail(Infor);
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
    private void gotoDetail(MyBookcodeInfor info) {
        Intent intent = new Intent(this, BooksureActivity.class);

        startActivity(intent);
    }

    /**
     * 将二级菜单的选择结果设置给一级菜单
     * @param
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
                        R.layout.item_mybookcode_list, null);
                holder = new ViewHolder();
                holder.book_hospital = (TextView) inflate.findViewById(R.id.book_hospital);
                holder.book_class = (TextView) inflate.findViewById(R.id.book_class);
                holder.book_doctor = (TextView) inflate.findViewById(R.id.book_doctor);

                holder.book_price = (TextView) inflate.findViewById(R.id.book_price);
                holder.book_time = (TextView) inflate.findViewById(R.id.book_time);
                holder.book_person = (TextView) inflate.findViewById(R.id.book_person);

                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            MyBookcodeInfor Info = goodsList.get(position);
            if (Info.getBook_hospital().equals("")) {
                holder.book_hospital.setVisibility(View.GONE);
            }
            else{holder.book_hospital.setText(Info.getBook_hospital());}

            if (Info.getBook_doctor().equals("")) {
                holder.book_doctor.setVisibility(View.GONE);
            }
            else{holder.book_doctor.setText(Info.getBook_doctor());}


            holder.book_class.setText(Info.getBook_class());
            holder.book_price.setText(Info.getBook_price());
            holder.book_time.setText(Info.getBook_time());
            holder.book_person.setText(Info.getBook_person());
            //  UILUtils.displayImage(MyDoctorssListActivity.this, DoctorsInfo.getGoodsIcon(), holder.imgIcon);

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





    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.img_overlay:
                mListView.setSelection(0);

                break;

            case R.id.toolbar_profile_back: // 返回
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

    public class ViewHolder {
        TextView book_hospital;
        TextView book_class;
        TextView book_doctor;
        TextView book_price;
        TextView book_time;
        TextView book_person;

    }
}
