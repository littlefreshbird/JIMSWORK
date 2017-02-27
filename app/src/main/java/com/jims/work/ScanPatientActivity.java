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

public class ScanPatientActivity extends AppCompatActivity {


    @BindView(R.id.input_message)
    EditText inputMessage;
    @BindView(R.id.scan_message)
    TextView scanMessage;
    @BindView(R.id.next)
    Button next;

    public static ScanPatientActivity sScanPatientActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_patient);
        ButterKnife.bind(this);
        setCustomActionBar();
        sScanPatientActivity=this;
    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView = ButterKnife.findById(mActionBarView, android.R.id.title);
        textView.setText("查找病人");
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
            default:
        }
        return super.onOptionsItemSelected(item);
    }


}
