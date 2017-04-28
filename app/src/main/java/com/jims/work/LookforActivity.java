package com.jims.work;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.jims.work.utils.Utils;

/****
 * 找回密码第一页
 */
public class LookforActivity extends BaseActivity1 {
private ImageView imageView;
	@Override
	public int getLayoutId() {
		return R.layout.activity_lookforpassword;
	}

	@Override
	public void initToolBar() {
		mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
		toolbarTitle.setText("找回密码");
	}

	@Override
	public void initDatas() {
		//跳转到找回密码第二页
		Button lookaccess_login = (Button) findViewById(R.id.lookaccess_login);
		lookaccess_login.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// 防止按钮连续点击
				if (Utils.isFastClick()) {
					return;
				}

				Intent intent = new Intent(LookforActivity.this,
						LookforFinishActivity.class);
				LookforActivity.this.startActivity(intent);
				finish();
			}
		});

	}

	@Override
	public void configViews() {

	}
	
}
