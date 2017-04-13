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
import android.widget.TextView;
import com.jims.work.adapter.MyhistoryListseclectAdapter;
import com.jims.work.bean.MyhistoryseclectInfo;
import com.jims.work.utils.MyListView;
import java.util.ArrayList;
import butterknife.ButterKnife;



/**
 * Created by Just on 2017/1/12.
 * 病历查询
 */

public class CaseseclectActivity extends BaseActivity1 {
    private ArrayList<MyhistoryseclectInfo> doctorsList = new ArrayList<MyhistoryseclectInfo>();
    private MyListView mListView;
    private TextView top_title_text;

    MyhistoryListseclectAdapter mDoctorsListAdapter;



    @Override
    public int getLayoutId() {
        return R.layout.caseseclect;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("寻医");
    }

    @Override
    public void initDatas() {
        top_title_text=(TextView)findViewById(R.id.top_title_text);
        top_title_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CaseseclectActivity.this,MainActivity.class);//点击回主页
                startActivity(intent);
                finish();
            }
        });
        initGoods();
        initview();
    }

    @Override
    public void configViews() {

    }

    //加载数据
    private void initGoods() {
        doctorsList.add(new MyhistoryseclectInfo("感冒", "承德市第一附属医院", "心血管内科", "", "100001", "2016-12-15", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("发烧", "承德市中心医院", "神经外科", "", "100002", "2016-12-01", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("流鼻涕", "承德市妇幼保健院", "小儿科", "", "100003", "2016-11-10", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("咳嗽", "承德市第三附属医院", "心血管内科", "", "100001", "2016-09-07", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("咽喉痛", "承德市中心医院", "神经外科", "", "100002", "2016-04-02", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("腿疼", "承德市妇幼保健院", "小儿科", "", "100003", "2016-03-02", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("腿好了", "承德市第二附属医院", "心血管内科", "", "100001", "2016-03-01", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("感冒好了", "承德市妇幼保健院", "小儿科", "", "100003", "2016-02-01", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("发烧好了", "承德市第一附属医院", "心血管内科", "", "100001", "2016-01-31", "填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("不流鼻涕了", "承德市中心医院", "神经外科", "", "100002", "2015-09-17","填写时间：", "填写人：", "张强"));
        doctorsList.add(new MyhistoryseclectInfo("咽喉不痛了", "承德市妇幼保健院", "小儿科", "", "100003", "2015-08-14", "填写时间：", "填写人：", "张强"));

    }
    //绑定数据源
    private void initview() {
        mListView = (MyListView) findViewById(R.id.listView1);
        mDoctorsListAdapter = new MyhistoryListseclectAdapter(this, doctorsList);
        mListView.setAdapter(mDoctorsListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyhistoryseclectInfo info = doctorsList.get(position);
                if(position==0){
                    Intent intent=new Intent(CaseseclectActivity.this,CaseLoadingActivitytest.class);//点击进详细页面
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

}
