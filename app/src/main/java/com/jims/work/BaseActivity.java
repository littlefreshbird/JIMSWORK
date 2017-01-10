
package com.jims.work;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.jims.work.utils.BaseInterfaces;



public  class BaseActivity extends AppCompatActivity implements BaseInterfaces {

	private Dialog loadbar = null;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setCustomActionBar();
	}
	public void setCustomActionBar() {
		ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
		View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
		ActionBar actionBar = getSupportActionBar();
		actionBar.setCustomView(mActionBarView, lp);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setDisplayShowCustomEnabled(true);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setHomeAsUpIndicator(R.drawable.action_bar_back);
		actionBar.setElevation(2);
	}
	public void SkipActivityforClass(Context ctx,Class<?>cla){
		Intent intent=new Intent();
		intent.setClass(ctx, cla);
		startActivity(intent);
	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
	}
	

	
}
