package com.jims.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/****
 * 登录
 */

public class LoginActivity extends Activity {
    //显示密码和切换图片
    private ImageView img_displaypass;
    //设置密码
    private EditText et_password;
    private Button btnlogin;
    private TextView btnRegister,zhaohuipass;
    int count = 0;
    int image[] = new int[]{
            R.drawable.hide_password,
            R.drawable.display_password
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_password = (EditText) findViewById(R.id.etPassWord);
        btnlogin=(Button)findViewById(R.id.login);
        btnRegister=(TextView) findViewById(R.id.btn_register);
        img_displaypass = (ImageView) findViewById(R.id.img_displaypass);
        zhaohuipass= (TextView) findViewById(R.id.zhaohuipass);
//密码显示与隐藏
        img_displaypass.setImageResource(image[0]);
        img_displaypass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img_displaypass.setImageResource(image[count]);
                if (count == 0) {
                    //隐藏密码
                    et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    count++;
                } else if (count == 1) {
                    //如果选中，显示密码
                    et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    count = 0;
                }
            }
        });






        //登录成功跳转到主页
       btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //注册按钮跳转到注册页面
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        //找回密码跳转到找回密码页
        zhaohuipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LookforActivity.class);
                startActivity(intent);
            }
        });
    }


}