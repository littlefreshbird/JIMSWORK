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

public class BookcodeActivity extends BaseActivity1 {

    private GridView doctor_class_gridview;
    private Adapter_GridView_Doctorclass adapter_GridView_doctorclass;
    public static   BookcodeActivity mBookcodeActivity;

    private String[] str_path_hot = Constants.MyString.DEPARTMENT_CLS;
    private int[] pic_path_hot = { R.mipmap.clinic_08_color_icon, R.mipmap.clinic_01_color_icon, R.mipmap.clinic_02_color_icon, R.mipmap.clinic_21_color_icon,
            R.mipmap.clinic_09_color_icon, R.mipmap.clinic_03_color_icon, R.mipmap.clinic_12_color_icon, R.mipmap.clinic_04_color_icon,
            R.mipmap.clinic_07_color_icon, R.mipmap.clinic_17_color_icon, R.mipmap.clinic_15_color_icon, R.mipmap.clinic_13_color_icon,
            R.mipmap.clinic_14_color_icon, R.mipmap.clinic_11_color_icon, R.mipmap.clinic_16_color_icon, R.mipmap.clinic_06_color_icon,};

    @Override
    public int getLayoutId() {
        return R.layout.activity_bookcode;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("预约挂号");
    }

    @Override
    public void initDatas() {
        mBookcodeActivity=this;
        doctor_class_gridview = (GridView) findViewById(R.id.doctor_class_gridview);

        doctor_class_gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));

        adapter_GridView_doctorclass = new Adapter_GridView_Doctorclass(this, pic_path_hot,str_path_hot);

        doctor_class_gridview.setAdapter(adapter_GridView_doctorclass);
        doctor_class_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                BookListActivity.startActivity(BookcodeActivity.this,"11");
            }
        });
    }

    @Override
    public void configViews() {

    }
}
