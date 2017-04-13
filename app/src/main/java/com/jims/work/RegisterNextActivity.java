package com.jims.work;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jims.work.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 注册设置密码
 */
public class RegisterNextActivity extends BaseActivity1 {

    @BindView(R.id.img_registernext_back)
    ImageView imgRegisternextBack;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.edit_copycode)
    EditText editCopycode;
    @BindView(R.id.btn_register_next)
    Button btnRegisterNext;
    ProgressDialog pd;


    @Override
    public int getLayoutId() {
        return R.layout.activity_register_next;
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void initDatas() {
        Intent intent= getIntent();
        String phone= intent.getStringExtra("phone");

        //返回
        imgRegisternextBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //注册成功跳转到主页
        btnRegisterNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkUserInput();
                Intent intent=new Intent(RegisterNextActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void configViews() {

    }

    public void checkUserInput(){
        int len = editCode.getText().toString().length();
        boolean result = editCode.getText().toString().equals(editCopycode.getText().toString());
        if(!"".equals(editCode.getText().toString().trim())){
            if (len > 5 && len < 21) {
                if(!editCopycode.getText().toString().trim().isEmpty()){
                    if(result) {
                        if (AppUtils.checkNetwork(RegisterNextActivity.this) == true) {
                            //executeHttp();
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
    public void executeHttp(){




    }



    public void showToast(String str){
        Toast.makeText(RegisterNextActivity.this, str, Toast.LENGTH_LONG).show();
    }
}
