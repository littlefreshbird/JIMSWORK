package com.jims.work.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.jims.work.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jims.work.R.id.ratingbar;

public class MyEvaluateDetailFragment extends Fragment {

    private String[] name = { "张强" };

    private String[] desc = { "2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合，这次多亏了这个医生"};

    private int[] imageids = { R.drawable.image_myhead};
    private String[] time = {"2016-09-29"};
    private String[] client ={"满意度:"};
    private  int[] count = {5};
    private int[]  sexmaletop={R.drawable.male};
    ListView lvinfo;
    List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
    private RatingBar ratingBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.activity_listitem, null);
         ratingBar = (RatingBar)getActivity(). findViewById(ratingbar);
        for (int i = 0; i < name.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("imageids", imageids[i]);
            listItem.put("name", name[i]);
            listItem.put("desc", desc[i]);
            listItem.put("time", time[i]);
            listItem.put("client", client[i]);
            listItem.put("count", count[i]);
            listItem.put("sexmaletop", sexmaletop[i]);

            listItems.add(listItem);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(), listItems,
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

}
