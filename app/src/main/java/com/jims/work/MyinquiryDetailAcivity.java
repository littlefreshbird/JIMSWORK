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
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.jims.work.fragment.ServiceFragment;

public class MyinquiryDetailAcivity extends AppCompatActivity {
    private ImageView mimageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.myinquiry);
        setCustomActionBar();
       /* ImageView mimageView= (ImageView) findViewById(R.id.img_myevaluatedetial_back);
        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceFragment serviceFragment=new ServiceFragment();
                serviceFragment.setMenuVisibility(true);
               // Intent intent=new Intent(MyinquiryDetailAcivity.this,ServiceFragment.class);
               // startActivity(intent);
                finish();
            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ServiceFragment serviceFragment=new ServiceFragment();
                serviceFragment.setMenuVisibility(true);
                // Intent intent=new Intent(MyinquiryDetailAcivity.this,ServiceFragment.class);
                // startActivity(intent);
                finish();
            case R.id.action:

                return true;
            case R.id.action_photo:
                return true;
            case R.id.action_fanhui:

                return true;
            case R.id.action_qianjin:
                Toast.makeText(this, "提交完成", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_inquiry, null);
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
