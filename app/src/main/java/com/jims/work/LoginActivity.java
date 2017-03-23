package com.jims.work;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.jims.work.bean.BaseBean;
import com.jims.work.bean.UserBean;
import com.jims.work.service.LoginService;
import com.jims.work.utils.AppUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/****
 * 登录
 */

public class LoginActivity extends Activity {
    @BindView(R.id.login)
    Button login;
    //显示密码和切换图片
    private ImageView img_displaypass;
    //设置密码
    private EditText et_password, et_account;
    private Button btnlogin;
    private TextView btnRegister, zhaohuipass;
    int count = 0;
    int image[] = new int[]{
            R.drawable.hide_password,
            R.drawable.display_password
    };
    ProgressDialog pd;

    LoginService loginService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.212:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginService = retrofit.create(LoginService.class);



        et_account = (EditText) findViewById(R.id.etAccount);
        et_password = (EditText) findViewById(R.id.etPassWord);

        btnRegister = (TextView) findViewById(R.id.btn_register);
        img_displaypass = (ImageView) findViewById(R.id.img_displaypass);
        zhaohuipass = (TextView) findViewById(R.id.zhaohuipass);
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

    public void showToast(String str) {
        Toast.makeText(LoginActivity.this, str, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.login)
    public void onClick() {

        String account = et_account.getText().toString().trim();
        if (TextUtils.isEmpty(account)) {
            showToast("用户名不能为空");
            return;
        }

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            showToast("密码不能为空");
            return;
        }
        if (AppUtils.checkNetwork(LoginActivity.this) == true) {
            pd = ProgressDialog.show(LoginActivity.this, "请稍候", "正在连接服务器...", true, true);
            Map<String, Object> map = new HashMap<>();
            map.put("account", account);
            map.put("password", password);
            Call<ResponseBody> call = loginService.getUserByLogin(map);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            String result = response.body().string();
                            Log.e("result", result);
                            BaseBean b = JSON.parseObject(result, BaseBean.class);
                            //String respcode = b.getRespcode();
                            String message = b.getMessage();
                            Log.e("message", message);
                            if (b.getRespcode().equals("0")) {
                                UserBean u=JSON.parseObject(b.getData(), UserBean.class);
                                Intent intent = new Intent();
                                intent.putExtra("user", u);
                                intent.setClass(LoginActivity.this, MainActivity.class);
                                startActivity(intent);


                                SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString("ACCOUNT", u.getAccount());
                                editor.commit();




                            }
                            if (b.getRespcode().equals("1")) {
                                showToast("用户名或密码错误");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        showToast("服务器响应失败");
                    }

                    pd.dismiss();
                }


                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                }
            });
        }else {
            showToast("连接网络失败");
        }
        }
}
