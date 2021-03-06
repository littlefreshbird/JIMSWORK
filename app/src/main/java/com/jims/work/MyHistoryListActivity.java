package com.jims.work;

import android.content.Context;
import android.content.Intent;
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

/***
 * 诊疗记录
 */
public class MyHistoryListActivity extends BaseActivity1 {



    private ArrayList<MyhistoryInfo> doctorsList = new ArrayList<MyhistoryInfo>();
    private MyListView mListView;

    MyhistoryListAdapter mDoctorsListAdapter;
    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, MyHistoryListActivity.class)
                .putExtra("id", bookId));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_myhistory_list;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("诊疗记录");
    }

    @Override
    public void initDatas() {
        initGoods();
        initview();
    }

    @Override
    public void configViews() {

    }

    private void initGoods() {
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第一附属医院", "副主任医师","发热三天，咳嗽严重，头痛失眠，食欲不好，已输液治疗一星期，不见好转", "100001", "2016-12-15",  "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院","副主任医师", "右眼疼痛、视物模糊在一周,入院常州二院，入院诊断右眼葡萄膜炎","100002", "2016-12-01", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "副主任医师","右眼视物模糊二月，左眼视物模糊一周,入院","100003", "2016-11-03", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第三附属医院","副主任医师","刚开始腰部僵硬现在腰没事就是弯腰发麻，做ct没事，臀部大腿疼时间很短，躺一会就轻点，这严重吗","100001", "2016-09-07",  "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "副主任医师","腹部疼，食欲不振，想吐，身体瘦了许度多","100002", "2016-04-02",  "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院",  "副主任医师", "发热三天，咳嗽严重，头痛失眠，食欲不好，已输液治疗一星期，不见好转","100003", "2016-03-02", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第二附属医院",  "副主任医师","发热三天，咳嗽严重，头痛失眠，食欲不好，已输液治疗一星期，不见好转","100001", "2016-03-01", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院",  "副主任医师","晚上睡觉感觉胸闷憋气平躺喘粗气,白天就感觉嗓子痒痒的想咳嗽 ","100003", "2016-02-01",  "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第一附属医院",  "副主任医师","发热三天，咳嗽严重，头痛失眠，食欲不好，已输液治疗一星期，不见好转","100001", "2016-01-31",  "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院",  "副主任医师","发热三天，咳嗽严重，头痛失眠，食欲不好，已输液治疗一星期，不见好转","100002", "2015-09-17",  "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "副主任医师", "查出类风湿3年了。时好时坏,最近小腿前部痒的难受。","100003", "2015-08-14",  "就诊人：", "张强"));

    }
     // 初始化
    private void initview() {
        mListView = (MyListView) findViewById(R.id.listView1);
        mDoctorsListAdapter = new MyhistoryListAdapter(this, doctorsList);
        mListView.setAdapter(mDoctorsListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyhistoryInfo info = doctorsList.get(position);
                MyHistoryDetailActivity.startActivity(MyHistoryListActivity.this,"11");
            }
        });
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });

    }


}