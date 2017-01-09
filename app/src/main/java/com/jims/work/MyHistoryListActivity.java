package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.jims.work.adapter.MyhistoryListAdapter;
import com.jims.work.bean.MyhistoryInfo;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MyHistoryListActivity extends AppCompatActivity {



    private ArrayList<MyhistoryInfo> doctorsList = new ArrayList<MyhistoryInfo>();
    private MyListView mListView;

    MyhistoryListAdapter mDoctorsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myhistory_list);
        ButterKnife.bind(this);
        setCustomActionBar();
        initGoods();
        initview();
    }

    private void initGoods() {
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第一附属医院", "心血管内科", "副主任医师", "100001", "2016-12-15", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "2016-12-01", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003", "2016-11-10", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第三附属医院", "心血管内科", "副主任医师", "100001", "2016-09-07", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "2016-04-02", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003", "2016-03-02", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第二附属医院", "心血管内科", "副主任医师", "100001", "2016-03-01", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003", "2016-02-01", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第一附属医院", "心血管内科", "副主任医师", "100001", "2016-01-31", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "2015-09-17", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003", "2015-08-14", "就诊时间：", "就诊人：", "张强"));

    }

    private void initview() {
        mListView = (MyListView) findViewById(R.id.listView1);
        mDoctorsListAdapter = new MyhistoryListAdapter(this, doctorsList);
        mListView.setAdapter(mDoctorsListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyhistoryInfo info = doctorsList.get(position);
                // gotoDetail(info);
            }
        });
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });

    }
    public void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_history, null);
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

                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}