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


public class TestResultsActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_results);
        ButterKnife.bind(this);
        setCustomActionBar();
        TabHost m = (TabHost)findViewById(R.id.tabhost);
        m.setup();

        LayoutInflater i=LayoutInflater.from(this);
        i.inflate(R.layout.result_layout, m.getTabContentView());
        i.inflate(R.layout.result_layout, m.getTabContentView());

        m.addTab(m.newTabSpec("tab1").setIndicator("检查结果").setContent(R.id.LinearLayout01));
        m.addTab(m.newTabSpec("tab2").setIndicator("检验结果").setContent(R.id.LinearLayout01));


    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView = ButterKnife.findById(mActionBarView, android.R.id.title);
        textView.setText("检查检验");
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





        }