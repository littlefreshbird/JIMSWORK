package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    //调用onSuppprtNavigateup()为actionbar左上角点击事件
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent=new Intent(DoctorMessageActivity.this,DoctorListActivity.class);
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
}
