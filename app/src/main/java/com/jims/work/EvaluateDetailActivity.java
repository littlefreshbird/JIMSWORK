package com.jims.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

public class EvaluateDetailActivity extends FragmentActivity {
    private	String itemclick="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_item_details_top);

        ImageView iv_title_bar_complainleft = (ImageView) findViewById(R.id.img_myevaluate_detail_back);
        iv_title_bar_complainleft.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // 防止多次点击
                if (Utils.isFastClick()) {
                    return;
                }
                finish();
//				Intent intent = new Intent(Complaindetail_activity.this,
//						Complain_activity.class);
//				Complaindetail_activity.this.startActivity(intent);

            }
        });

    }
}


