package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jims.work.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 注册页面
 */
public class RegisterActivity extends AppCompatActivity {


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
    @BindView(R.id.img_registerback)
    ImageView imgRegisterback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RegisterActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        //注册下一步跳转到设置密码页
        accessNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserInput();
                Intent intent = new Intent(RegisterActivity.this, RegisterNextActivity.class);
                startActivity(intent);
            }
        });


        //返回
        imgRegisterback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    public void checkUserInput(){
        if(!"".equals(editMobile.getText().toString().trim())){
            if(AppUtils.isMobileNO(editMobile.getText().toString().trim())==true){
                if(!editCode.getText().toString().trim().isEmpty()){
                            if(AppUtils.checkNetwork(RegisterActivity.this)==true){
                                //executeHttp();
                            }else{
                                showToast("亲，您还没有联网!");
                            }
                }else{
                    showToast("验证码不能为空");
                }
            }else{
                showToast("手机号码格式不对哦");
            }
        }else {
            showToast("手机号码不能为空");
        }
    }

    public void showToast(String str){
        Toast.makeText(RegisterActivity.this, str, Toast.LENGTH_LONG).show();
    }
}
