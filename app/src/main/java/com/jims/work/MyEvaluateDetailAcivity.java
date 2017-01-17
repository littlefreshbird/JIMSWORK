package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
/*****
 * 我的评价详情
 */
public class MyEvaluateDetailAcivity extends AppCompatActivity {
    private ImageView mimageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyEvaluateDetailAcivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevaluate_detail);
        ImageView mimageView= (ImageView) findViewById(R.id.img_myevaluatedetial_back);
        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent(MyEvaluateDetailAcivity.this,MyEvaluateActivity.class);
                startActivity(intent);*/
                finish();
            }
        });
    }

}
