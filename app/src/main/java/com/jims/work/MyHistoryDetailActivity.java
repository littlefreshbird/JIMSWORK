package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyHistoryDetailActivity extends AppCompatActivity {

    @BindView(R.id.img_myhistory_back)
    ImageView imgMyhistoryBack;
    @BindView(R.id.id_title)
    RelativeLayout idTitle;
    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, MyHistoryDetailActivity.class)
                .putExtra("id", bookId));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyHistoryDetailActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_myhistory_detail);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_myhistory_back, R.id.id_title})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_myhistory_back:
                finish();
                break;
            case R.id.id_title:
                break;
        }
    }
}
