package com.jims.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

public class MyEvaluateActivity extends FragmentActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevaluate);

        ImageView iv_title_bar_left = (ImageView) findViewById(R.id.img_myevaluate_back);
        iv_title_bar_left.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                finish();


            }
        });

    }

}
