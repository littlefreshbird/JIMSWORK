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
import java.util.Collection;
import java.util.List;

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

    public List<MyAsklistInfor> getList() {
        return list;
    }

    public void setList(ArrayList<MyAsklistInfor> list) {
        this.list = list;
    }

    private Context context;
    private List<MyAsklistInfor> list;
    public InquiryaskAdapter(Context context, List<MyAsklistInfor> list) {
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

    public void addAll(Collection<? extends MyAsklistInfor> collection){
        list.addAll(collection);
        notifyDataSetChanged();
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
        //viewHolder.myask_evaluate.setText(list.get(position).getMyask_evaluate());
        viewHolder.myask_content.setText(list.get(position).getContent()+"("+list.get(position).getSex()+","+list.get(position).getAge()+"岁)");
        viewHolder.myask_doctorname.setText(list.get(position).getDoctor());
        // viewHolder.tv_timetext.setText(list.get(position).getPrice());
        //viewHolder.myask_doctorclass.setText(list.get(position).getMyask_doctorclass());
        viewHolder.myask_kind.setText(list.get(position).getIspay().equals("0")?"免费咨询":"付费咨询");
       //viewHolder.myask_kind.setText(list.get(position).getMyask_kind());
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
