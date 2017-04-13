package com.jims.work;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jims.work.bean.Check_result;


import java.util.ArrayList;
import java.util.List;

public class CheckResultActivity extends BaseActivity1 {

      @Override
    public int getLayoutId() {
        return R.layout.activity_check_result;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("检测明细");
    }

    @Override
    public void initDatas() {
        //设置表格标题的背景颜色
        ViewGroup tableTitle = (ViewGroup) findViewById(R.id.table_title);
        tableTitle.setBackgroundColor(Color.rgb(177, 173, 172));

        List<Check_result> list = new ArrayList<Check_result>();
        list.add(new Check_result("白细胞", "6.30", "10＾9/L","N","4-10"));
        list.add(new Check_result("中性细胞比率", "58.6", "%","N","50-70"));
        list.add(new Check_result("中性细胞数", "3.8", "10＾9/L","N","2-7.7"));
        list.add(new Check_result("淋巴细胞比率", "35.3", "%","N","20-40"));
        list.add(new Check_result("淋巴细胞数", "2.2", "10＾9/L","N","0.8-4"));
        list.add(new Check_result("中值细胞比率", "6.1", "%","N","3-10"));
        list.add(new Check_result("中值细胞数", "0.3", "10＾9/L","N","0.12-1"));
        list.add(new Check_result("红细胞", "4.93", "10＾12/L","N","3.5-5.5"));
        list.add(new Check_result("血红蛋白", "138.0", "g/L","N","110-160"));
        list.add(new Check_result("红细胞压积", "0.414", "L/L","N","0.36-0.5"));

        ListView tableListView = (ListView) findViewById(R.id.list);

        TableAdapter adapter = new TableAdapter(this, list);

        tableListView.setAdapter(adapter);
    }

    @Override
    public void configViews() {

    }

    class TableAdapter extends BaseAdapter {

        private List<Check_result> list;
        private LayoutInflater inflater;

        public TableAdapter(Context context, List<Check_result> list) {
            this.list = list;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            int ret = 0;
            if (list != null) {
                ret = list.size();
            }
            return ret;
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Check_result check = (Check_result) this.getItem(position);

            ViewHolder viewHolder;

            if (convertView == null) {

                viewHolder = new ViewHolder();

                convertView = inflater.inflate(R.layout.result_list_item, null);
                viewHolder.check_name = (TextView) convertView.findViewById(R.id.check_name);
                viewHolder.check_result = (TextView) convertView.findViewById(R.id.check_result);
                viewHolder.check_unit = (TextView) convertView.findViewById(R.id.check_unit);
                viewHolder.unusual = (TextView) convertView.findViewById(R.id.unusual);
                viewHolder.value = (TextView) convertView.findViewById(R.id.value);


                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.check_name.setText(check.getCheck_name());
            viewHolder.check_name.setTextSize(13);
            viewHolder.check_result.setText(check.getCheck_result());
            viewHolder.check_result.setTextSize(13);
            viewHolder.check_unit.setText(check.getCheck_unit());
            viewHolder.check_unit.setTextSize(13);
            viewHolder.unusual.setText(check.getUnusual());
            viewHolder.unusual.setTextSize(13);
            viewHolder.value.setText(check.getValue());
            viewHolder.value.setTextSize(13);


            return convertView;
        }

        public class ViewHolder {
            public TextView check_name;
            public TextView check_result;
            public TextView check_unit;
            public TextView unusual;
            public TextView value;

        }
    }
}
