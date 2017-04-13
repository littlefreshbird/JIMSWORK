package com.jims.work;

import android.content.Context;
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

public class BooksureActivity extends BaseActivity1 {

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
    public int getLayoutId() {
        return R.layout.activity_booksure;
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

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, BooksureActivity.class)
                .putExtra("id", bookId));
    }


    @OnClick({R.id.btn_person_change, R.id.btn_book})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_person_change://更换就诊者
                Intent intent=new Intent(BooksureActivity.this,OldrecordActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_book://预约完成
               MybookcodeActivity.startActivity(BooksureActivity.this,"11");

                if(BookListActivity.mBookListActivity!=null){BookListActivity.mBookListActivity.finish();};
                if(BookcodeActivity.mBookcodeActivity!=null){BookcodeActivity.mBookcodeActivity.finish();};
                 finish();

                break;
        }
    }
}
