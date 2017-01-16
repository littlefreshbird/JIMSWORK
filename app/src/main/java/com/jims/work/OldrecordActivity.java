package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Just on 2017/1/16.
 */

public class OldrecordActivity extends AppCompatActivity implements View.OnClickListener{
    private Button wancheng;
    private RadioButton radiobutton1;

    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oldrecord);

        //绑定Layout里面的ListView
        ListView list = (ListView) findViewById(R.id.listview01);
        //生成动态数组，加入数据
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
        for(int i=0;i<10;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle","1111");
            map.put("ItemText","男");
            listItem.add(map);
        }
        //生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源
                R.layout.old_listview,//ListItem的XML实现
                //动态数组与ImageItem对应的子项
                new String[] {"ItemTitle","ItemText"},
                //ImageItem的XML文件里面的一个ImageView,两个ID
                new int[] {R.id.onetext,R.id.radiobutton1}
        );
        list=(ListView)findViewById(R.id.listview01);
        //添加并且显示
        list.setAdapter(listItemAdapter);

        //添加点击
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

            }
        });

        wancheng=(Button)findViewById(R.id.wancheng);
        wancheng.setOnClickListener(this);

        setCustomActionBar();
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.wancheng:
                Intent intent1=new Intent(OldrecordActivity.this,NewDoctorListActivity.class);
                startActivity(intent1);
                finish();
                break;
            default:
                break;
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(OldrecordActivity.this,RecordActivity.class);//点击回主页
                startActivity(intent);
                finish();
            case R.id.action_photo:
               //删除
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_oldrecord, null);
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
}
