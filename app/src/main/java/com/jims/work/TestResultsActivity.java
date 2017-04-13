package com.jims.work;


import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

import butterknife.ButterKnife;


public class TestResultsActivity extends BaseActivity1 {


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
        i.inflate(R.layout.result_layout, m.getTabContentView());
        i.inflate(R.layout.result_layout, m.getTabContentView());

        m.addTab(m.newTabSpec("tab1").setIndicator("检查结果").setContent(R.id.LinearLayout01));
        m.addTab(m.newTabSpec("tab2").setIndicator("检验结果").setContent(R.id.LinearLayout01));
    }

    @Override
    public void configViews() {

    }


}