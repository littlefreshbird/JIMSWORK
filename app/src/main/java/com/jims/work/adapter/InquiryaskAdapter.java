package com.jims.work.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.bean.MyAsklistInfor;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 问诊.
 */

public class InquiryaskAdapter extends BaseAdapter {


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<MyAsklistInfor> getList() {
        return list;
    }

    public void setList(ArrayList<MyAsklistInfor> list) {
        this.list = list;
    }

    private Context context;

    public InquiryaskAdapter(Context context, ArrayList<MyAsklistInfor> list) {
        this.context = context;
        this.list = list;
    }

    private ArrayList<MyAsklistInfor> list;

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
            convertView = LayoutInflater.from(context).inflate(R.layout.simple1_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        fillValue(position, viewHolder);
        return convertView;

    }

    private void fillValue(int position, ViewHolder viewHolder) {
        //viewHolder.imgIcon.setImageDrawable(list.get(position).getIcon());
        viewHolder.begin_time.setText(list.get(position).getBegin_time());
        //viewHolder.tvClasses.setText(list.get(position).getClasses());
        viewHolder.myask_evaluate.setText(list.get(position).getMyask_evaluate());
        viewHolder.myask_content.setText(list.get(position).getMyask_content());
        viewHolder.myask_doctorname.setText(list.get(position).getMyask_doctorname());
        // viewHolder.tv_timetext.setText(list.get(position).getPrice());
        viewHolder.myask_doctorclass.setText(list.get(position).getMyask_doctorclass());
        viewHolder.myask_kind.setText(list.get(position).getMyask_kind());

    }



    class ViewHolder {
        @BindView(R.id.begin_time)
        TextView begin_time;
        @BindView(R.id.myask_evaluate)
        TextView myask_evaluate;
        @BindView(R.id.myask_content)
        TextView myask_content;
      /*  @BindView(R.id.myask_doctorimg)
        CircleImageView myask_doctorimg;*/
        @BindView(R.id.myask_doctorname)
        TextView myask_doctorname;
        @BindView(R.id.myask_doctorclass)
        TextView myask_doctorclass;
        @BindView(R.id.myask_kind)
        TextView myask_kind;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
