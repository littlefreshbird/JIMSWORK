package com.jims.work.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.bean.MyServicelistInfor;
import com.jims.work.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 当前服务.
 */

public class   CurrentserviceAdapter extends BaseAdapter {


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<MyServicelistInfor> getList() {
        return list;
    }

    public void setList(ArrayList<MyServicelistInfor> list) {
        this.list = list;
    }

    private Context context;
    private List<MyServicelistInfor> list;

    public CurrentserviceAdapter(Context context, List<MyServicelistInfor> list) {
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


    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_myservice_list, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;

    }

    private void fillValue(int position, ViewHolder holder) {
        holder.myserviceTime.setText(list.get(position).getMyservice_time());
        holder.myserviceContent.setText(list.get(position).getMyservice_content());


        holder.myserviceEvaluate.setText(list.get(position).getMyservice_evaluate());
        holder.myserviceDoctorname.setText(list.get(position).getMyservice_doctorname());
        //holder.myserviceDoctorimg.set(list.get(position).getMyservice_doctorimg());
        holder.myserviceDoctorclass.setText(list.get(position).getMyservice_doctorclass());
        holder.myserviceKind.setText(list.get(position).getMyservice_kind());
    }



    class ViewHolder {
        @BindView(R.id.myservice_time)
        TextView myserviceTime;
        @BindView(R.id.myservice_evaluate)
        TextView myserviceEvaluate;
        @BindView(R.id.myservice_content)
        TextView myserviceContent;
        @BindView(R.id.myservice_doctorimg)
        CircleImageView myserviceDoctorimg;
        @BindView(R.id.myservice_doctorname)
        TextView myserviceDoctorname;
        @BindView(R.id.myservice_doctorclass)
        TextView myserviceDoctorclass;
        @BindView(R.id.myservice_kind)
        TextView myserviceKind;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
