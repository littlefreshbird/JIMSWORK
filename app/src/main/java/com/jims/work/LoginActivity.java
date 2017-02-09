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
import android.widget.Toast;

import static com.jims.work.R.id.etPassWord;


/****
 * 登录
 */

public class LoginActivity extends Activity {
    //显示密码和切换图片
    private ImageView img_displaypass;
    //设置密码
    private EditText et_password,et_account;
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
        et_account= (EditText) findViewById(R.id.etAccount);
        et_password = (EditText) findViewById(etPassWord);
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
             /*   Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.2.215:8080/restfulDemo/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                LoginService loginService = retrofit.create(LoginService.class);

                Call<LoginResult> call = loginService.getData(new User(et_account.getText().toString(),et_password.getText().toString()));
                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                        if (response.isSuccessful()) {
                            LoginResult loginResult=response.body();
                            if(loginResult.getCode().equals("200")){
                                Intent intent = new Intent(LoginActivity.this,
                                        MainActivity.class);
                                startActivity(intent);
                            }
                            if(loginResult.getCode().equals("201")){
                                showToast("密码错误");
                            }
                            if(loginResult.getCode().equals("202")){
                                showToast("用户名错误");
                            }

                        } else {
                            showToast("网络有问题");
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {

                        // do onFailure代码
                    }
                });*/


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

    public void showToast(String str){
        Toast.makeText(LoginActivity.this, str, Toast.LENGTH_LONG).show();
    }
}