package com.jims.work.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.bean.DoctorsInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gong on 2017/1/5.
 */

public class DoctorsListAdapter extends BaseAdapter {
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<DoctorsInfo> getList() {
        return list;
    }

    public void setList(ArrayList<DoctorsInfo> list) {
        this.list = list;
    }

    private Context context;

    public DoctorsListAdapter(Context context, ArrayList<DoctorsInfo> list) {
        this.context = context;
        this.list = list;
    }

    private ArrayList<DoctorsInfo> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_doctors_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;

    }

    private void fillValue(int position, ViewHolder viewHolder) {
        viewHolder.imgIcon.setImageDrawable(list.get(position).getIcon());
        viewHolder.tvName.setText(list.get(position).getNames());
        viewHolder.tvClasses.setText(list.get(position).getClasses());
        viewHolder.tvPosition.setText(list.get(position).getPosition());
        viewHolder.tvHospital.setText(list.get(position).getHospital());
        viewHolder.tvDetail.setText(list.get(position).getDetail());
        viewHolder.tvPrice.setText(list.get(position).getPrice());
        viewHolder.tvNum.setText(list.get(position).getComment()+"人");
        viewHolder.tvPercent.setText(list.get(position).getPercent());

    }


    static class ViewHolder {
        @BindView(R.id.img_icon)
        ImageView imgIcon;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_classes)
        TextView tvClasses;
        @BindView(R.id.tv_position)
        TextView tvPosition;
        @BindView(R.id.tv_hospital)
        TextView tvHospital;
        @BindView(R.id.tv_title)
        TextView tvDetail;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_num)
        TextView tvNum;
        @BindView(R.id.img_icon_vip)
        ImageView imgIconVip;
        @BindView(R.id.tv_percent)
        TextView tvPercent;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
