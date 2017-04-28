package com.jims.work;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.jims.work.utils.Utils;

public class LookforFinishActivity extends BaseActivity1 {



	@Override
	public int getLayoutId() {
		return R.layout.activity_lookforpassword_next;
	}

	@Override
	public void initToolBar() {
		mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
		toolbarTitle.setText("重设密码");
	}

	@Override
	public void initDatas() {

		//找回密码成功跳转到主页
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
	}

	@Override
	public void configViews() {

	}


}
