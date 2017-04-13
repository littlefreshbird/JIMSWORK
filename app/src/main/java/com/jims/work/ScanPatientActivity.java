package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScanPatientActivity extends BaseActivity1 {


    @BindView(R.id.input_message)
    EditText inputMessage;
    @BindView(R.id.scan_message)
    TextView scanMessage;
    @BindView(R.id.next)
    Button next;

    public static ScanPatientActivity sScanPatientActivity;

    @Override
    public int getLayoutId() {
        return R.layout.activity_scan_patient;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("查找病人");
    }

    @Override
    public void initDatas() {
        sScanPatientActivity=this;
    }

    @Override
    public void configViews() {

    }



    @OnClick({R.id.input_message, R.id.scan_message, R.id.next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.input_message:
                break;
            case R.id.scan_message:
                break;
            case R.id.next:
                startActivity(new Intent(ScanPatientActivity.this, FreeTreatActivity.class));
                break;
        }
    }



}
