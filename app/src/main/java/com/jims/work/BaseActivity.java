
package com.jims.work;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.jims.work.utils.BaseInterfaces;



public  class BaseActivity extends FragmentActivity implements BaseInterfaces {

	private Dialog loadbar = null;
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
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
