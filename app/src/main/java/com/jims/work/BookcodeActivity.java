package com.jims.work;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jims.work.adapter.Adapter_GridView_Doctorclass;
import com.jims.work.utils.Constants;

import butterknife.ButterKnife;

public class BookcodeActivity extends BaseActivity {
    private ProgressBar mProgressBar;



    private GridView doctor_class_gridview;
    private Adapter_GridView_Doctorclass adapter_GridView_doctorclass;


    private String[] str_path_hot = Constants.MyString.DEPARTMENT_CLS;
    private int[] pic_path_hot = { R.mipmap.clinic_08_color_icon, R.mipmap.clinic_01_color_icon, R.mipmap.clinic_02_color_icon, R.mipmap.clinic_21_color_icon,
            R.mipmap.clinic_09_color_icon, R.mipmap.clinic_03_color_icon, R.mipmap.clinic_12_color_icon, R.mipmap.clinic_04_color_icon,
            R.mipmap.clinic_07_color_icon, R.mipmap.clinic_17_color_icon, R.mipmap.clinic_15_color_icon, R.mipmap.clinic_13_color_icon,
            R.mipmap.clinic_14_color_icon, R.mipmap.clinic_11_color_icon, R.mipmap.clinic_16_color_icon, R.mipmap.clinic_06_color_icon,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookcode);
        setCustomActionBar();
        doctor_class_gridview = (GridView) findViewById(R.id.doctor_class_gridview);

        doctor_class_gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));

        adapter_GridView_doctorclass = new Adapter_GridView_Doctorclass(this, pic_path_hot,str_path_hot);

        doctor_class_gridview.setAdapter(adapter_GridView_doctorclass);
        doctor_class_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {


                Intent intent = new Intent(BookcodeActivity.this,
                        NewDoctorListActivity.class);
                startActivity(intent);
                finish();



            }
        });


    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView = ButterKnife.findById(mActionBarView, android.R.id.title);
        textView.setText("预约挂号");
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
