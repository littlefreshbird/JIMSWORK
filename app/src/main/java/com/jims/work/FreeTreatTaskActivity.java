package com.jims.work;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jims.work.adapter.TimelineViewAdapter;
import com.jims.work.bean.TimelineRow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FreeTreatTaskActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<TimelineRow> TimelineRowsList = new ArrayList<>();
    ArrayAdapter<TimelineRow> myAdapter;
    @BindView(R.id.timelineListView)
    ListView timelineListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_treat_task);
        ButterKnife.bind(this);
        setCustomActionBar();
        // Add Random Rows to the List
        for (int i=0; i<15; i++) {
            TimelineRowsList.add(
                    new TimelineRow(
                            //Row Id
                            i
                            //Row Date
                            ,"2016/12/25"
                            //Row Title or null
                            ,"李云龙"
                            //Row Description or null
                            ,"承德市双滦区承钢街道 "
                            //Row bitmap Image or null
                            , BitmapFactory.decodeResource(getResources(), R.drawable.img_0 + getRandomNumber(0,10))
                            //Row Bellow Line Color
                            , getRandomColor()
                            //Row Bellow Line Size in dp
                            ,2
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
        ListView myListView = (ListView) findViewById(R.id.timelineListView);
        myListView.setAdapter(myAdapter);

    }
    public Date getRandomDate () {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = null;
        Date endDate = new Date();
        try {
            startDate = sdf.parse("02/09/2015");
            long random = ThreadLocalRandom.current().nextLong(startDate.getTime(), endDate.getTime());
            endDate = new Date(random);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return endDate;
    }
    //Random Methods
    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    public int getRandomNumber(int min, int max){
        return  min + (int)(Math.random() * max);
    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView=ButterKnife.findById(mActionBarView,android.R.id.title);
        textView.setText("义诊日程");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.action_bar_back);
        actionBar.setElevation(2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
            default:}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}
