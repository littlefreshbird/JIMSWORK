package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HealthRecordActivity extends AppCompatActivity {

    @BindView(R.id.title_daytest)
    TextView titleDaytest;
    @BindView(R.id.text_blood_pressure)
    TextView textBloodPressure;
    @BindView(R.id.text_blood_sugar)
    TextView textBloodSugar;
    @BindView(R.id.title_allergic)
    TextView titleAllergic;
    @BindView(R.id.text_allergic)
    TextView textAllergic;
    @BindView(R.id.text_symptom)
    TextView textSymptom;
    @BindView(R.id.layout_allergic)
    RelativeLayout layoutAllergic;
    @BindView(R.id.title_immune)
    TextView titleImmune;
    @BindView(R.id.text_immune)
    TextView textImmune;
    @BindView(R.id.layout_immune)
    RelativeLayout layoutImmune;
    @BindView(R.id.title_health)
    TextView titleHealth;
    @BindView(R.id.text_family)
    TextView textFamily;
    @BindView(R.id.text_genetics)
    TextView textGenetics;
    @BindView(R.id.text_trauma)
    TextView textTrauma;
    @BindView(R.id.text_operation)
    TextView textOperation;
    @BindView(R.id.text_transfusion)
    TextView textTransfusion;
    @BindView(R.id.layout_health)
    RelativeLayout layoutHealth;
    @BindView(R.id.title_medicine)
    TextView titleMedicine;
    @BindView(R.id.text_medicine)
    TextView textMedicine;
    @BindView(R.id.layout_medicine)
    RelativeLayout layoutMedicine;
    @BindView(R.id.activity_health_record)
    LinearLayout activityHealthRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_record);
        ButterKnife.bind(this);
        setCustomActionBar();
    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView = ButterKnife.findById(mActionBarView, android.R.id.title);
        textView.setText("健康档案");
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.layout_allergic, R.id.layout_immune, R.id.layout_health, R.id.layout_medicine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_allergic:
                break;
            case R.id.layout_immune:
                break;
            case R.id.layout_health:
                break;
            case R.id.layout_medicine:
                break;
        }
    }
}
