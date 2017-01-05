package com.jims.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.jims.work.utils.Utils;

public class LookforFinishActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lookforpassword_next);
		
		Button lookaccess_login = (Button) findViewById(R.id.lookfor_login);
		lookaccess_login.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 防止按钮连续点击
				if (Utils.isFastClick()) {
					return;
				}
			
				Intent intent = new Intent(LookforFinishActivity.this,
						MainActivity.class);
				LookforFinishActivity.this.startActivity(intent);
			finish();
			}
		});
		ImageView imageView= (ImageView) findViewById(R.id.img_lookpassfinish_back);
		imageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LookforFinishActivity.this,
						LookforActivity.class);
				startActivity(intent);
			}
		});
	}

	
	
	
	
	
}
