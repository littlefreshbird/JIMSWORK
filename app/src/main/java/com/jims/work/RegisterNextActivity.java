package com.jims.work;

import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.jims.work.bean.BaseBean;
import com.jims.work.encrypt.JiaMi;
import com.jims.work.service.LoginService;
import com.jims.work.utils.AppUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 注册设置密码
 */
public class RegisterNextActivity extends BaseActivity1 {


    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.edit_copycode)
    EditText editCopycode;
    @BindView(R.id.btn_register_next)
    Button btnRegisterNext;
    ProgressDialog pd;
    LoginService loginService;
    private String account;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_next;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("设置密码");
    }

    @Override
    public void initDatas() {
        Intent intent= getIntent();
        String phone= intent.getStringExtra("phone");
        this.account=phone;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.212:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        loginService = retrofit.create(LoginService.class);
        //注册成功跳转到主页
        btnRegisterNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserInput(account);
              // Intent intent=new Intent(RegisterNextActivity.this,MainActivity.class);
              //  startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public void configViews() {



    }

    public void checkUserInput(String account){
        int len = editCode.getText().toString().length();
        boolean result = editCode.getText().toString().equals(editCopycode.getText().toString());
        if(!"".equals(editCode.getText().toString().trim())){
            if (len > 5 && len < 21) {
                if(!editCopycode.getText().toString().trim().isEmpty()){
                    if(result) {
                        if (AppUtils.checkNetwork(RegisterNextActivity.this) == true) {
                            executeHttp(account);
                        } else {
                            showToast("亲，您还没有联网!");
                        }
                    }else{
                        showToast("两次密码不一致");
                    }
                }else{
                    showToast("重复密码不能为空");
                }
            }else{
                showToast(" \"密码为6-20的字母或数字！\\n\" + \"请检查！\"");
            }
        }else {
            showToast("密码不能为空");
        }
    }
    public void executeHttp(String account){
        String aa = JiaMi.entryptPassword(editCode.getText().toString().trim());
        Map<String, Object> map = new HashMap<>();
        map.put("account", account);
        map.put("password", aa);
        Call<ResponseBody> call = loginService.userRegist(map);
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
                            showToast("注册成功");
                            Intent intent=new Intent(RegisterNextActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                        if (b.getErrorcode().equals("10000")) {
                            showToast("用户已存在");
                        }
                        if (b.getErrorcode().equals("1")) {
                            showToast("注册失败");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }

    public void showToast(String str){
        Toast.makeText(RegisterNextActivity.this, str, Toast.LENGTH_LONG).show();
    }
}
