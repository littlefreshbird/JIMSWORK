package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jims.work.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookSucessActivity extends BaseActivity1 {

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, BookSucessActivity.class)
                .putExtra("id", bookId));
    }

    @BindView(R.id.DoctorIcon)
    CircleImageView DoctorIcon;
    @BindView(R.id.doctor_name)
    TextView doctorName;
    @BindView(R.id.doctor_professional)
    TextView doctorProfessional;
    @BindView(R.id.doctor_hospital)
    TextView doctorHospital;
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
    @BindView(R.id.btn_book)
    Button btnBook;

    @Override
    public int getLayoutId() {
        return R.layout.activity_book_sucess;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("预约挂号");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }





    @OnClick(R.id.btn_book)
    public void onClick() {
        finish();
    }
}
