package com.jims.work.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.bean.CheckResult;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 问诊.
 */

public class CheckAdapter extends BaseAdapter {


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<CheckResult> getList() {
        return list;
    }

    public void setList(ArrayList<CheckResult> list) {
        this.list = list;
    }

    private Context context;
    private List<CheckResult> list;

    public CheckAdapter(Context context, List<CheckResult> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    public void addAll(Collection<? extends CheckResult> collection) {
        list.addAll(collection);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_check_result, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;

    }

    private void fillValue(int position, ViewHolder viewHolder) {
        //viewHolder.imgIcon.setImageDrawable(list.get(position).getIcon());
        viewHolder.checkName.setText(list.get(position).getItem());

        viewHolder.checkTime.setText(list.get(position).getCheck_date());


    }



    class ViewHolder {
        @BindView(R.id.check_name)
        TextView checkName;
        @BindView(R.id.check_time)
        TextView checkTime;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
