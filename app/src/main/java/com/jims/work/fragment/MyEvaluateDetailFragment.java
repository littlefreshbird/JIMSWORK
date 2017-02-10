package com.jims.work.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jims.work.MoreActivity;
import com.jims.work.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyEvaluateDetailFragment extends Fragment {

    private String[] name = { "王林" };

    private String[] desc = { "2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合，这次多亏了这个医生"};
    private int[] imageids = { R.drawable.image_myhead};
    private String[] time = {"2016-09-29"};
    private String[] client ={"满意度:"};
    //private  int[] count = {5};
    private int[]  sexmaletop={R.drawable.male};
    ListView lvinfo;
    List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
    private RatingBar ratingBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.activity_listitem, null);
         ratingBar = (RatingBar)getActivity(). findViewById(R.id.ratingbar);
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("imageids", imageids[i]);
            listItem.put("name", name[i]);
            listItem.put("desc", desc[i]);
            listItem.put("time", time[i]);
            listItem.put("client", client[i]);
           // listItem.put("count", count[i]);

            listItem.put("sexmaletop", sexmaletop[i]);

            listItems.add(listItem);
        }

        MySimpleAdapter simpleAdapter = new MySimpleAdapter(getActivity(), listItems,
                R.layout.evaluate_detail_item,
                new String[] { "imageids", "name", "desc","time","client","count","sexmaletop"   },
                new int[] { R.id.tweet_listitem_userface, R.id.tweet_listitem_username,R.id.tweetcontent ,R.id.questiontime,R.id.tweet_listitem_client,R.id.tweet_listitem_commentCount,R.id.sexmaletop});
        lvinfo=(ListView)view.findViewById(R.id.tweet_listitem_content);
        lvinfo.setAdapter(simpleAdapter); // ΪListView��������
        initView(view);
        return view;
    }
    private void initView(View view){


    }
    private class MySimpleAdapter extends SimpleAdapter {
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            View v = super.getView(position, convertView, parent);

            TextView add_myevaluate=(TextView) v.findViewById(R.id.add_myevaluate);
            add_myevaluate.setTag(position);
            add_myevaluate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(getActivity(),
                            MoreActivity.class);
                    startActivity(intent);


                }
            });
            TextView del_myevaluate=(TextView) v.findViewById(R.id.del_myevaluate);
            del_myevaluate.setTag(position);
            del_myevaluate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    dialog();


                }
            });
            TextView update_myevaluate=(TextView) v.findViewById(R.id.update_myevaluate);
            update_myevaluate.setTag(position);
            update_myevaluate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    Intent intent = new Intent(getActivity(),
                            MoreActivity.class);
                    startActivity(intent);


                }
            });
            return v;
        }

        public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            // TODO Auto-generated constructor stub
        }
    }
    private void dialog(){
        //先new出一个监听器，设置好监听
        DialogInterface.OnClickListener dialogOnclicListener=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch(which){
                    case Dialog.BUTTON_POSITIVE:
                        Toast.makeText(getActivity(), "确认" + which, Toast.LENGTH_SHORT).show();
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        Toast.makeText(getActivity(), "取消" + which, Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        };
        //dialog参数设置
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());  //先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setMessage("确定删除这条评论吗?"); //设置内容
        builder.setIcon(R.mipmap.ic_launcher);//设置图标，图片id即可
        builder.setPositiveButton("确认",dialogOnclicListener);
        builder.setNegativeButton("取消", dialogOnclicListener);

        builder.create().show();
    }
}
