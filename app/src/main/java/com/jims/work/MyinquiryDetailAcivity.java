package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.jims.work.fragment.ServiceFragment;

public class MyinquiryDetailAcivity extends AppCompatActivity {
    private ImageView mimageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MyinquiryDetailAcivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myevaluate_detail);
        ImageView mimageView= (ImageView) findViewById(R.id.img_myevaluatedetial_back);
        mimageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServiceFragment serviceFragment=new ServiceFragment();
                serviceFragment.setMenuVisibility(true);
               // Intent intent=new Intent(MyinquiryDetailAcivity.this,ServiceFragment.class);
               // startActivity(intent);
                finish();
            }
        });
    }

}