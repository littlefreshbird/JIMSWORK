package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {


    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.layout_login_topbar)
    RelativeLayout layoutLoginTopbar;
    @BindView(R.id.edit_mobile)
    EditText editMobile;
    @BindView(R.id.access_password)
    Button accessPassword;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.access_next)
    Button accessNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        accessNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, RegisterNextActivity.class);
                startActivity(intent);
            }
        });
    }
}
