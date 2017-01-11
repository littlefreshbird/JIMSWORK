package com.jims.work;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

public class SplashActivity extends AppCompatActivity {
    Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp=getPreferences(MODE_PRIVATE);
                boolean isFirst=sp.getBoolean("isFirst",true);

          Intent intent =new Intent();
                /*if(isFirst){
                    sp.edit().putBoolean("isFirst",false).commit();
                    //如果第一次安装并进入
           intent.setClass(SplashActivity.this,GuideActivity.class);

                }else{
                    intent.setClass(SplashActivity.this,LoginActivity.class);
                }*/
                intent.setClass(SplashActivity.this,GuideActivity.class);
                startActivity(intent);

                finish();
            }
        },3000);
    }
}
