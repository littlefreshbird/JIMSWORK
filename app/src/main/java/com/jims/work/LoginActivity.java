package com.jims.work;

import android.app.Activity;
import android.app.ProgressDialog;
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

import com.jims.work.utils.Utils;

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
    ProgressDialog pd;
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
                // 防止按钮连续点击
                if (Utils.isFastClick()) {
                    return;
                }
            /*    if(!et_account.getText().toString().isEmpty()) {

                    if (!et_password.getText().toString().isEmpty()) {
                        if(AppUtils.checkNetwork(LoginActivity.this)==true) {
                           *//* pd = ProgressDialog.show(LoginActivity.this, "请稍候", "正在连接服务器...", true, true);
                            Retrofit retrofit = new Retrofit.Builder()
                                    .baseUrl("http://192.168.2.215:8080/Mybaits/")
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .build();
                            LoginService loginService = retrofit.create(LoginService.class);

                            Call<LoginResult> call = loginService.getData(new User(et_account.getText().toString(), et_password.getText().toString()));
                            call.enqueue(new Callback<LoginResult>() {
                                @Override
                                public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                                    pd.dismiss();
                                    if (response.isSuccessful()) {
                                        LoginResult loginResult = response.body();
                                        if (loginResult.getCode().equals("200")) {
                                            Intent intent = new Intent(LoginActivity.this,
                                                    MainActivity.class);
                                            startActivity(intent);
                                        }
                                        if (loginResult.getCode().equals("201")) {
                                            showToast("密码错误");

                                        }
                                        if (loginResult.getCode().equals("202")) {
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
                            });*//*

                            Thread thread=new Thread(new Runnable() {

                                @Override
                                public void run() {
                                    String LOGIN_NAME=et_account.getText().toString().trim();
                                    String PASSWORD=et_password.getText().toString().trim();
                                    String url="http://192.168.2.212:8888/JimsService/user/userLogin.do";
                                    //创建OkHttpClient对象，用于稍后发起请求
                                    OkHttpClient client = new OkHttpClient();
                                    //通过FormEncodingBuilder对象添加多个请求参数键值对
                                    FormEncodingBuilder builder = new FormEncodingBuilder();
                                    builder.add("account", LOGIN_NAME)
                                            .add("password", PASSWORD);
                                    //通过FormEncodingBuilder对象构造Post请求体
                                    RequestBody body = builder.build();
                                    //通过请求地址和请求体构造Post请求对象Request
                                    Request request = new Request.Builder().url(url).post(body).build();

                                    try {
                                        Response response = client.newCall(request).execute();
                                    } catch (IOException e1) {
                                        // TODO Auto-generated catch block
                                        e1.printStackTrace();
                                    }


                                    //android不允许UI线程中访问网络 根据Request对象发起POST异步Http请求，并添加请求回调  请求加入调度
                                    client.newCall(request).enqueue(new Callback() {
                                        @Override
                                        public void onResponse(final Response response) throws IOException {
                                            //请求成功，此处对请求结果进行处理
                                            String result=response.body().string();
                                            Log.e("result", result);
                                            BaseBean b= JSON.parseObject(result, BaseBean.class);
                                            Log.e("b", b+"");
                                            //获取get值
                                            String respcode=b.getRespcode();
                                            String message=b.getMessage();
                                            Log.e("message", message);
                                            String str=null;
                                            if(respcode.equals("-1")){
                                                str="用户不存在";
                                            }
                                            if(respcode.equals("1")){
                                                str="用户名或密码不正确";
                                            }
                                            if(respcode.equals("0")){

                                                str="登录成功";
                                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                                startActivity(intent);
                                                finish();
                                            }
                                            Looper.prepare();
                                            showToast(str);
                                            Looper.loop();
                                        }

                                        @Override
                                        public void onFailure(Request request, IOException e) {
                                            //请求失败
                                        }
                                    });

                                }
                            });

                            thread.start();




                        }else{
                            showToast("亲，您还没有联网!");
                        }
                    } else {
                        showToast("密码不能为空");
                    }
                }else{
                    showToast("用户名不能为空");
                }*/

/*
               Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();*/






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
        Toast.makeText(LoginActivity.this, str, Toast.LENGTH_SHORT).show();
    }

}