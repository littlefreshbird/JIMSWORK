package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterNextActivity extends AppCompatActivity {

    @BindView(R.id.img_registernext_back)
    ImageView imgRegisternextBack;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.edit_copycode)
    EditText editCopycode;
    @BindView(R.id.btn_register_next)
    Button btnRegisterNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegisterNextActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register_next);
        ButterKnife.bind(this);
        imgRegisternextBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        btnRegisterNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterNextActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
