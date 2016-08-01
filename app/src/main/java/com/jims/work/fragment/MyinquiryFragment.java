package com.jims.work.fragment;

/**
 * Created by Just on 2017/1/7.
 */
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jims.work.MyEvaluateDetailAcivity;
import com.jims.work.MyinquiryDetailAcivity;
import com.jims.work.R;
import com.jims.work.ReplyActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.R.attr.name;
import static com.jims.work.R.id.idquiry_listitem_userface;

public class MyinquiryFragment extends  Fragment {

   private String[] name = { "王林发的帖子", "王林发的帖子", "王林发的帖子", "王林发的帖子","王林发的帖子","王林发的帖子","王林发的帖子","王林发的帖子","王林发的帖子" };

    private String[] desc = { "医生服务态度很好，很满意！", "我小孩今年8岁,乘坐自行车摔倒擦伤了脸,医生很细心，谢谢！", "这个张大夫对待病人态度不好！"
            + "2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合，这次多亏了这个医生。", "在这个医院医生能力不行，在这治病三年了，根本没什么效果！","我要投诉"
           + "我要投诉，我要投诉。。。","我要投诉1某某医院的张医生。。。","我要投诉某某医院的刘医生。。。","我要投诉某某医院的王医生。。。","我要投诉某某医院的赵医生。。。"};
    private int[] imageid = { R.drawable.image_myhead, R.drawable.image_myhead,
            R.drawable.image_myhead, R.drawable.image_myhead ,R.drawable.image_myhead,R.drawable.image_myhead,R.drawable.image_myhead,R.drawable.image_myhead,R.drawable.image_myhead};
    private int[] imageids = { R.mipmap.dianzan,  R.mipmap.dianzan,
            R.mipmap.dianzan,  R.mipmap.dianzan, R.mipmap.dianzan, R.mipmap.dianzan, R.mipmap.dianzan, R.mipmap.dianzan, R.mipmap.dianzan};
    private String[] time = {"2016-09-29","2016-08-23","2016-06-05","2015-12-18","2015-11-11","2015-10-10","2015-06-09","2015-05-03","2015-03-10"};
    private String[] client ={"已完结","未完结","已完结","未完结","已完结","未完结","已完结","未完结","已完结"};
   // private  int[] count = {5,4,4,5,5,3,4,1,2};
   //private int[]  sexmaletop={R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male,R.drawable.male};
    ListView lvinfo;
    List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.activity_listitem, null);

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
           listItem.put("name", name[i]);
           listItem.put("desc", desc[i]);
            listItem.put("time", time[i]);
           listItem.put("client", client[i]);
            listItem.put("imageids", imageids[i]);
            listItem.put("imageid", imageid[i]);
            listItems.add(listItem);
        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems,
                R.layout.simple1_item,
                new String[] {"name","desc","time","client","imageids","imageid"},
                new int[] { R.id.idquiry_listitem_username,R.id.idquiry_tweetcontent ,R.id.idquiry_questiontime,R.id.idquiry_listitem_client,R.id.idquiry_listitem_dianzan,R.id.idquiry_listitem_userface});
        lvinfo=(ListView)view.findViewById(R.id.tweet_listitem_content);
        lvinfo.setAdapter(simpleAdapter); // ΪListView��������


        lvinfo.setOnItemClickListener(new OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                String itemclivk =  String.valueOf(arg2);
                // TODO Auto-generated method stub

                Intent intent = new Intent(getActivity(),
                        ReplyActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("arg2", itemclivk);
                intent.putExtras(bundle);
                startActivity(intent);


            }
        });

        initView(view);
        return view;
    }
    private void initView(View view){


    }
}
