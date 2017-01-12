package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Toast;

import com.jims.work.adapter.MyhistoryListAdapter;
import com.jims.work.bean.MyhistoryInfo;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

import butterknife.ButterKnife;


/**
 * Created by Just on 2017/1/12.
 */

public class CaseseclectActivity extends AppCompatActivity {
    private ArrayList<MyhistoryInfo> doctorsList = new ArrayList<MyhistoryInfo>();
    private MyListView mListView;

    MyhistoryListAdapter mDoctorsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.caseseclect);
        ButterKnife.bind(this);
       /* CaseseclectActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();*/
      setCustomActionBar();
        initGoods();
        initview();
    }

    private void initGoods() {
        doctorsList.add(new MyhistoryInfo("感冒", "承德市第一附属医院", "心血管内科", "", "100001", "2016-12-15", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("发烧", "承德市中心医院", "神经外科", "", "100002", "2016-12-01", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("流鼻涕", "承德市妇幼保健院", "小儿科", "", "100003", "2016-11-10", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("咳嗽", "承德市第三附属医院", "心血管内科", "", "100001", "2016-09-07", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("咽喉痛", "承德市中心医院", "神经外科", "", "100002", "2016-04-02", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("腿疼", "承德市妇幼保健院", "小儿科", "", "100003", "2016-03-02", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("腿好了", "承德市第二附属医院", "心血管内科", "", "100001", "2016-03-01", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("感冒好了", "承德市妇幼保健院", "小儿科", "", "100003", "2016-02-01", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("发烧好了", "承德市第一附属医院", "心血管内科", "", "100001", "2016-01-31", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("不流鼻涕了", "承德市中心医院", "神经外科", "", "100002", "2015-09-17","填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryInfo("咽喉不痛了", "承德市妇幼保健院", "小儿科", "", "100003", "2015-08-14", "填写时间：", "填写人：", "张强"));

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
                if(position==0){
                    Intent intent=new Intent(CaseseclectActivity.this,CaseLoadingActivitytest.class);//点击回主页
                    startActivity(intent);
                    finish();
                }
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
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_seclect, null);
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