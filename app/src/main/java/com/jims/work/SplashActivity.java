package com.jims.work;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * 引导页
 */
public class SplashActivity extends AppCompatActivity {
    Handler mHandler=new Handler();
   // private MyCountDownTimer mc;
   // private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
       // tv = (TextView) findViewById(R.id.textView);
       // mc = new MyCountDownTimer(3000, 1000);
       // mc.start();
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
    /*private Handler handler=new Handler();*//**
     * 继承 CountDownTimer 防范
     *
     * 重写 父类的方法 onTick() 、 onFinish()
     *//*class MyCountDownTimer extends CountDownTimer {
        *//**
         *
         * @param millisInFuture
         *      表示以毫秒为单位 倒计时的总数
         *
         *      例如 millisInFuture=1000 表示1秒
         *
         * @param countDownInterval
         *      表示 间隔 多少微秒 调用一次 onTick 方法
         *
         *      例如: countDownInterval =1000 ; 表示每1000毫秒调用一次onTick()
         *
         *//*public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        public void onFinish() {
            tv.setText("正在跳转");
        }

        public void onTick(long millisUntilFinished) {
            tv.setText("倒计时(" + millisUntilFinished / 1000 + ")");
        }

    }*/
}
