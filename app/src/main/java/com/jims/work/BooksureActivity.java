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
import android.widget.TextView;

import com.jims.work.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BooksureActivity extends AppCompatActivity {

    @BindView(R.id.DoctorIcon)
    CircleImageView DoctorIcon;
    @BindView(R.id.doctor_name)
    TextView doctorName;
    @BindView(R.id.doctor_professional)
    TextView doctorProfessional;
    @BindView(R.id.doctor_department)
    TextView doctorDepartment;
    @BindView(R.id.book_time)
    TextView bookTime;
    @BindView(R.id.service_time)
    TextView serviceTime;
    @BindView(R.id.visit_time)
    TextView visitTime;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.book_price)
    TextView bookPrice;
    @BindView(R.id.visit_person)
    TextView visitPerson;
    @BindView(R.id.remain_number)
    TextView remainNumber;
    @BindView(R.id.btn_person_change)
    Button btnPersonChange;
    @BindView(R.id.btn_book)
    Button btnBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booksure);
        ButterKnife.bind(this);
        setCustomActionBar();
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.btn_person_change, R.id.btn_book})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_person_change://更换就诊者
                Intent intent=new Intent(BooksureActivity.this,OldrecordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_book://预约完成
                Intent i=new Intent(BooksureActivity.this,MybookcodeActivity.class);
                startActivity(i);

                finish();
                break;
        }
    }
}
