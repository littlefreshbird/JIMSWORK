package com.jims.work.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jims.work.R;

public class TwoFragment extends Fragment {

	private View view;// ��ǰfragment

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_two, null);
		initValues();// ��ʼ��ֵ
		findViews();// ��ʼ���ؼ�
		setValues();// ����ֵ
		setListeners();// ��Ӽ���
		return view;
	}

	private void initValues() {
		// TODO Auto-generated method stub

	}

	private void findViews() {
		// TODO Auto-generated method stub

	}

	private void setValues() {
		// TODO Auto-generated method stub

	}

	private void setListeners() {
		// TODO Auto-generated method stub

	}
}
