package com.jims.work;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TabHost;
import android.widget.TextView;

import com.jims.work.bean.TestResult1;
import com.jims.work.bean.TestResult2;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;


public class TestResultsActivity extends BaseActivity1  {
    private ArrayList<TestResult1> List = new ArrayList<TestResult1>();
    private ArrayList<TestResult1> ListCopy = new ArrayList<TestResult1>();	//备份，用于排序后恢复

    private ArrayList<TestResult2> goodsList = new ArrayList<TestResult2>();
    private ArrayList<TestResult2> goodsListCopy = new ArrayList<TestResult2>();	//备份，用于排序后恢复
    private GoodsListAdapter mListAdapter;
    private GoodsListAdapter1 mListAdapter1;
    private MyListView mListView,mListView1;
    @Override
    public int getLayoutId() {
        return R.layout.activity_test_results;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("检查检验");
    }

    @Override
    public void initDatas() {
        TabHost m = (TabHost) findViewById(R.id.tabhost);
        m.setup();

        LayoutInflater i = LayoutInflater.from(this);
        i.inflate(R.layout.result_layout1, m.getTabContentView());
        i.inflate(R.layout.result_layout2, m.getTabContentView());

        m.addTab(m.newTabSpec("tab1").setIndicator("检查结果").setContent(R.id.LinearLayout01));
        m.addTab(m.newTabSpec("tab2").setIndicator("检验结果").setContent(R.id.LinearLayout02));
        initGoods();
        initListView();
    }

    @Override
    public void configViews() {

    }
    private void initGoods() {
        List.add(new TestResult1("CT检查","2017-03-17 09:50:42"));
        List.add(new TestResult1("X光检查","2017-03-28 15:50:42"));
        List.add(new TestResult1("B超","2017-03-29 17:50:42"));
        ListCopy.addAll(List);

        goodsList.add(new TestResult2("全血","2017-03-17 09:50:42"));
        goodsList.add(new TestResult2("全血","2017-03-28 15:50:42"));
        goodsList.add(new TestResult2("全血","2017-03-29 17:50:42"));
        goodsListCopy.addAll(goodsList);
    }
    /**
     * 设置菜单宽度
     */
    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initListView() {
        mListView1 = (MyListView) findViewById(R.id.listView1);
        mListView = (MyListView) findViewById(R.id.listView2);
        mListAdapter1=new GoodsListAdapter1();
        mListAdapter = new GoodsListAdapter();
        mListView1.setAdapter(mListAdapter1);
        mListView.setAdapter(mListAdapter);
        //检查结果
        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TestResult1 info1 = List.get(position);
                gotoDetail1(info1);
            }
        });
        mListView1.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });
        //检验结果
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TestResult2 info = goodsList.get(position);
                gotoDetail(info);
            }
        });
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });


    }

    /**
     * 检查结果详情
     * @param info1
     */
    private void gotoDetail1(TestResult1 info1) {
        Intent intent = new Intent(this, CheckResultActivity.class);

        startActivity(intent);
    }

    /**
     * 检验结果详情
     * @param info
     */
    private void gotoDetail(TestResult2 info) {
        Intent intent = new Intent(this, CheckResultActivity.class);

        startActivity(intent);
    }

    /**
     * 检查结果
     * @param
     * @param
     */
    class GoodsListAdapter1 extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            ViewHolder holder = null;
            if (convertView == null) {
                inflate = getLayoutInflater().inflate(
                        R.layout.item_check_result, null);
                holder = new ViewHolder();
                holder.check_name = (TextView) inflate.findViewById(R.id.check_name);
                holder.check_time = (TextView) inflate.findViewById(R.id.check_time);
                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            TestResult1 testResult1 = List.get(position);
            holder.check_name.setText(testResult1.getCheck_name());
            holder.check_time.setText(testResult1.getCheck_time());
            return inflate;
        }

        @Override
        public int getCount() {
            return List.size();
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
    /**
     * 检验结果
     * @param
     * @param
     */
    class GoodsListAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            ViewHolder holder = null;
            if (convertView == null) {
                inflate = getLayoutInflater().inflate(
                        R.layout.item_test_result, null);
                holder = new ViewHolder();
                holder.test_name = (TextView) inflate.findViewById(R.id.test_name);
                holder.test_time = (TextView) inflate.findViewById(R.id.test_time);
                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            TestResult2 testResult2 = goodsList.get(position);
            holder.test_name.setText(testResult2.getTest_name());
            holder.test_time.setText(testResult2.getTest_time());
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
    public class ViewHolder {
        TextView check_name;
        TextView check_time;
        TextView test_name;
        TextView test_time;


    }

}