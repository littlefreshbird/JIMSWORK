package com.jims.work;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;

import com.jims.work.bean.Adapter_GridView_Doctorclass;
import com.jims.work.utils.Constants;

/**
 * Created by Just on 2016/12/29.
 */
public class DoctorClassActivity extends FragmentActivity {

	private GridView doctor_class_gridview;
	private Adapter_GridView_Doctorclass adapter_GridView_doctorclass;


	private String[] str_path_hot = Constants.MyString.DEPARTMENT;
	private int[] pic_path_hot = { R.mipmap.clinic_08_color_icon, R.mipmap.clinic_01_color_icon, R.mipmap.clinic_02_color_icon, R.mipmap.clinic_21_color_icon,
			R.mipmap.clinic_09_color_icon, R.mipmap.clinic_03_color_icon, R.mipmap.clinic_12_color_icon, R.mipmap.clinic_04_color_icon,
			R.mipmap.clinic_07_color_icon, R.mipmap.clinic_17_color_icon, R.mipmap.clinic_15_color_icon, R.mipmap.clinic_13_color_icon,
			R.mipmap.clinic_14_color_icon, R.mipmap.clinic_11_color_icon, R.mipmap.clinic_16_color_icon, R.mipmap.clinic_06_color_icon,};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctorclass);

		doctor_class_gridview = (GridView) findViewById(R.id.doctor_class_gridview);

		doctor_class_gridview.setSelector(new ColorDrawable(Color.TRANSPARENT));

		adapter_GridView_doctorclass = new Adapter_GridView_Doctorclass(this, pic_path_hot,str_path_hot);

		doctor_class_gridview.setAdapter(adapter_GridView_doctorclass);


		doctor_class_gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

				switch (position){
					case 0:
					Intent intent = new Intent(DoctorClassActivity.this,
							DoctorListActivity.class);
					startActivity(intent);
						finish();
						break;
					case 1:
						Intent intent1 = new Intent(DoctorClassActivity.this,
								DoctorListActivity.class);
						startActivity(intent1);
						finish();
						break;
					default:
						break;
				}



			}
		});


		ImageView toolbar_profile_back = (ImageView) findViewById(R.id.toolbar_profile_back);
		toolbar_profile_back.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				Intent intent = new Intent(DoctorClassActivity.this,
						RecordActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

}
