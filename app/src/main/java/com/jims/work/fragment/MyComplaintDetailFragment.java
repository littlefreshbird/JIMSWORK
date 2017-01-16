package com.jims.work.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.jims.work.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyComplaintDetailFragment extends Fragment {

    private String[] name = { "张强" };
    private String[] service_type = {"免费问诊" };
    private String[] question = { "我患有鼻窦炎  最近脖子淋巴结肿大，自己就能摸到五个，做彩超显示快到2厘米了。我想去就医，想问一下，我需要挂什么科？外科还是耳鼻喉科？急！" };

    private String[] desc = { "2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合，这个医生看不好，不负责任"};

    private int[] imageids = { R.drawable.image_myhead};
    private String[] time = {"2016-09-29"};
    private String[] client ={"满意度:"};
    private  int[] count = {5};
    private int[]  sexmaletop={R.drawable.male};
    ListView lvinfo;
    List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.activity_listitem, null);

        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("imageids", imageids[i]);
            listItem.put("name", name[i]);
            listItem.put("service_type", service_type[i]);
            listItem.put("question", question[i]);
            listItem.put("desc", desc[i]);
            listItem.put("time", time[i]);
            listItem.put("client", client[i]);
            listItem.put("count", count[i]);
            listItem.put("sexmaletop", sexmaletop[i]);

            listItems.add(listItem);
        }


        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems,
                R.layout.complaint_detail_item,
                new String[] { "imageids", "name","question", "desc","time","client","count","sexmaletop","service_type"  },
                new int[] { R.id.tweet_listitem_userface, R.id.tweet_listitem_username,R.id.listitem_content,R.id.tweetcontent ,R.id.questiontime,R.id.tweet_listitem_client,R.id.tweet_listitem_commentCount,R.id.sexmaletop,R.id.servicetype});
        lvinfo=(ListView)view.findViewById(R.id.tweet_listitem_content);
        lvinfo.setAdapter(simpleAdapter); // ΪListView��������




        initView(view);
        return view;
    }
    private void initView(View view){


    }

}
