package com.jims.work;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

/****
 * 我的投诉
 */
public class MyComplaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mycomplaint);
        //返回
        ImageView iv_title_bar_left = (ImageView) findViewById(R.id.img_mycomplaint_back);
        iv_title_bar_left.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                finish();


            }
        });
    }
}
