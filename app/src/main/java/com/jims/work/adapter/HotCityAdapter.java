package com.jims.work.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jims.work.CityPositionActivity;
import com.jims.work.R;
import com.jims.work.entity.City;

import java.util.List;

public class HotCityAdapter extends BaseAdapter {

	private List<City> mHotCityList;
	private LayoutInflater mInflater;
	private Context mContext;

	public HotCityAdapter(Context context, List<City> hotCityList) {
		this.mHotCityList = hotCityList;
		this.mContext = context;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mHotCityList.size();
	}

	@Override
	public Object getItem(int position) {
		return mHotCityList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_city, null);
			viewHolder.tvCityName = (TextView) convertView
					.findViewById(R.id.tv_city_name);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		viewHolder.tvCityName.setText(mHotCityList.get(position).getName());
		viewHolder.tvCityName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Toast.makeText(mContext,mHotCityList.get(position).getName() + "", Toast.LENGTH_SHORT).show();
				SharedPreferences pref = mContext.getSharedPreferences("data",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = pref.edit();
				editor.putString("CITY",mHotCityList.get(position).getName());
				editor.commit();
				if(CityPositionActivity.class.isInstance(mContext))
				{
					// 转化为activity，然后finish就行了
					CityPositionActivity activity = (CityPositionActivity)mContext;
					activity.finish();
				}
			}
		});
		return convertView;
	}

	class ViewHolder {
		TextView tvCityName;
	}

}

