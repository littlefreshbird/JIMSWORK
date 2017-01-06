package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Just on 2017/1/4.
 */

public class DoctorMessageActivity extends AppCompatActivity {
    private TextView text;
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctormsg);
        text=(TextView)findViewById(R.id.text);
        imageView=(ImageView) findViewById(R.id.imageView);
        setCustomActionBar();
    }
    //调用onSuppprtNavigateup()为actionbar左上角点击事件
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent=new Intent(DoctorMessageActivity.this,NewDoctorListActivity.class);
        startActivity(intent);
        finish();
        return super.onSupportNavigateUp();
    }
    //调用menu中的main资源
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.main1,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //点击事件

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(DoctorMessageActivity.this,NewDoctorListActivity.class);//点击回主页
                startActivity(intent);
                finish();
            case R.id.tijiao:
                Toast.makeText(this, "已提交", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.guanzhu:
                Toast.makeText(this, "已关注", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.dingyue:
                Toast.makeText(this, "已订阅", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_msg, null);
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
