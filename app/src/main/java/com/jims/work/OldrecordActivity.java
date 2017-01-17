package com.jims.work;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
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
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Just on 2017/1/16.
 * 选择已有档案
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
        for(int i=0;i<3;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemTitle","李雷");
            map.put("ItemTitle1","20");
            map.put("ItemTitle2","男");
            listItem.add(map);
        }
        //生成适配器的Item和动态数组对应的元素
        SimpleAdapter listItemAdapter = new SimpleAdapter(this,listItem,//数据源
                R.layout.old_listview,//ListItem的XML实现
                //动态数组与ImageItem对应的子项
                new String[] {"ItemTitle","ItemTitle1","ItemTitle2"},

                new int[] {R.id.onetext,R.id.twotext,R.id.threetext}
        );

        //添加并且显示
        list.setAdapter(listItemAdapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(OldrecordActivity.this);
                builder.setMessage("确认移除吗？");
                builder.setTitle("提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();


                return true;
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
