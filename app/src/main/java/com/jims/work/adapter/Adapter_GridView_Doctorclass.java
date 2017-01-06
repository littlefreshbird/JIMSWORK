package com.jims.work.adapter;





import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jims.work.R;


public class Adapter_GridView_Doctorclass extends BaseAdapter {
private Context context;
private int[] data;
private String[] title;
	public Adapter_GridView_Doctorclass(Context context, int[] data, String[] title){
		
		this.context=context;
		this.data=data;
		this.title=title;
	}
	
	public String[] getTitle() {
		return title;
	}

	public void setTitle(String[] title) {
		this.title = title;
	}

	@Override
	public int getCount() {
		return data.length;
	}

	@Override
	public Object getItem(int arg0) {
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		return 0;
	}

	@Override
	public View getView(int position, View currentView, ViewGroup arg2) {
		HolderView holderView=null;
		if (currentView==null) {
			holderView=new HolderView();
			currentView= LayoutInflater.from(context).inflate(R.layout.grid_doctorclass, null);
			holderView.iv_pic=(ImageView) currentView.findViewById(R.id.iv_adapter_grid_pic);
			holderView.iv_text=(TextView) currentView.findViewById(R.id.iv_adapter_grid_text);
			currentView.setTag(holderView);
		}else {
			holderView=(HolderView) currentView.getTag();
		}
		
		
		holderView.iv_pic.setImageResource(data[position]);
		
		holderView.iv_text.setText(title[position]);
		return currentView;
	}
	
	
	public class HolderView {
		
		private ImageView iv_pic;
		private TextView iv_text;
		
	}

}
