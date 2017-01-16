package com.jims.work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MyHistoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyHistoryDetailActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_myhistory_detail);
    }
}
