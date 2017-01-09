package com.jims.work.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter{
	private ArrayList<Fragment> fragmentList;
	
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}
	
	public MyFragmentPagerAdapter(FragmentManager fm,ArrayList<Fragment> fragment){
		super(fm);
		this.fragmentList = fragment;
	}
	
	@Override
	public Fragment getItem(int arg0) {
		// TODO Auto-generated method stub
		return fragmentList.get(arg0);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragmentList.size();
	}

}
