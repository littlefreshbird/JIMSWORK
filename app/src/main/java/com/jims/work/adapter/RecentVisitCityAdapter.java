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

import java.util.List;


public class RecentVisitCityAdapter extends BaseAdapter {

	private List<String> mRecentVisitCityList;
	private LayoutInflater mInflater;
	private Context mContext;

	public RecentVisitCityAdapter(Context context, List<String> recentVisitCityList) {
		this.mRecentVisitCityList=recentVisitCityList;
		this.mContext=context;
		mInflater=LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		return mRecentVisitCityList.size();
	}

	@Override
	public Object getItem(int position) {
		return mRecentVisitCityList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {

		ViewHolder viewHolder=null;
		if(convertView==null){
			viewHolder=new ViewHolder();
			convertView=mInflater.inflate(R.layout.item_city,null);
			viewHolder.tvCityName=(TextView) convertView.findViewById(R.id.tv_city_name);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.tvCityName.setText(mRecentVisitCityList.get(position));
		viewHolder.tvCityName.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//Toast.makeText(mContext,mRecentVisitCityList.get(position)+"",0).show();


				SharedPreferences pref = mContext.getSharedPreferences("data",Context.MODE_PRIVATE);
				SharedPreferences.Editor editor = pref.edit();
				editor.putString("CITY",mRecentVisitCityList.get(position)+"");
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

	class ViewHolder{
		TextView tvCityName;
	}

}
