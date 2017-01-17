package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/*****
 * 我的评价
 */
public class MyEvaluateActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        MyEvaluateActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        setContentView(R.layout.activity_myevaluate);

        ImageView iv_title_bar_left = (ImageView) findViewById(R.id.img_myevaluate_back);
        iv_title_bar_left.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                finish();


            }
        });

    }

}
