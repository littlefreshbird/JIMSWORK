package com.jims.work;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.jims.work.adapter.TimelineViewAdapter;
import com.jims.work.bean.TimelineRow;
import com.jims.work.view.MyListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FreeTreatTaskActivity extends BaseActivity1 {
    @BindView(R.id.timelineListView)
    MyListView timelineListView;
    private ArrayList<TimelineRow> TimelineRowsList = new ArrayList<>();
    ArrayAdapter<TimelineRow> myAdapter;


    @Override
    public int getLayoutId() {
        return R.layout.activity_free_treat_task;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("义诊日程");
    }

    @Override
    public void initDatas() {

        // Add Random Rows to the List
        for (int i = 0; i < 15; i++) {
            TimelineRowsList.add(
                    new TimelineRow(
                            //Row Id
                            i
                            //Row Date
                            , "2016/12/25"
                            //Row Title or null
                            , "李云龙"
                            //Row Description or null
                            , "承德市双滦区承钢街道 "
                            //Row bitmap Image or null
                            , BitmapFactory.decodeResource(getResources(), R.drawable.img_0 + getRandomNumber(0, 10))
                            //Row Bellow Line Color
                            , getRandomColor()
                            //Row Bellow Line Size in dp
                            , 2
                            //Row Image Size in dp
                            , 25
                            //Row Background color or -1
                            , -1
                            //Row Background Size in dp or -1
                            , 25
                    )
            );
        }

        //Create the Timeline Adapter
        myAdapter = new TimelineViewAdapter(this, 0, TimelineRowsList,
                //if true, list will be arranged by date
                true);


        //Get the ListView and Bind it with the Timeline Adapter

        timelineListView.setAdapter(myAdapter);
        AdapterView.OnItemClickListener adapterListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimelineRow row = TimelineRowsList.get(position);
                startActivity(new Intent(FreeTreatTaskActivity.this, FreeTreatListActivity.class));

            }
        };
        timelineListView.setOnItemClickListener(adapterListener);
    }

    @Override
    public void configViews() {

    }

    public Date getRandomDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        Date endDate = new Date();
        try {
            startDate = sdf.parse("02/09/2015");
            long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
            endDate = new Date(random);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endDate;
    }

    //Random Methods
    public int getRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public int getRandomNumber(int min, int max) {
        return min + (int) (Math.random() * max);
    }


}
