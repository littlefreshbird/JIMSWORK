package com.jims.work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.userinfo_back)
    ImageView userinfoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserInfoActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_userinfo);
        ButterKnife.bind(this);

        userinfoBack.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userinfo_back:
                finish();
                break;

            default:
                break;
        }
    }

}
