package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jims.work.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 注册页面
 */
public class RegisterActivity extends BaseActivity1 {


    @BindView(R.id.edit_mobile)
    EditText editMobile;
    @BindView(R.id.access_password)
    Button accessPassword;
    @BindView(R.id.edit_code)
    EditText editCode;
    @BindView(R.id.access_next)
    Button accessNext;



    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("注册");
    }

    @Override
    public void initDatas() {
        accessNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserInput();
                Intent intent = new Intent();
                intent.putExtra("phone", editMobile.getText().toString().trim());
                intent.setClass(RegisterActivity.this, RegisterNextActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void configViews() {

    }

    public void checkUserInput(){
        if(!"".equals(editMobile.getText().toString().trim())){
            if(AppUtils.isMobileNO(editMobile.getText().toString().trim())==true){
                if(!editCode.getText().toString().trim().isEmpty()){
                            if(AppUtils.checkNetwork(RegisterActivity.this)==true){
                                //xecuteHttp();
                            }else{
                                showToast("亲，您还没有联网!");
                            }
                }else{
                    showToast("验证码不能为空");
                }
            }else{
                showToast("手机号码格式不对");
            }
        }else {
            showToast("手机号码不能为空");
        }
    }









    public void showToast(String str){
        Toast.makeText(RegisterActivity.this, str, Toast.LENGTH_LONG).show();
    }

}
