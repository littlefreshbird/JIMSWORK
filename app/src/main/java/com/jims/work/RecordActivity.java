package com.jims.work;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Just on 2016/12/29.
 */

public class RecordActivity extends AppCompatActivity {
    private EditText editone,edittwo;
    private RadioButton radiobutton1,radiobutton2;
    private TextView textone,texttwo,textthree,textfour ;
    private TextView buttonone;
    private RadioGroup radiogroup;
    private static final int DATE_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        editone = (EditText) findViewById(R.id.editone);
        edittwo = (EditText) findViewById(R.id.edittwo);
        radiobutton1= (RadioButton) findViewById(R.id.radiobutton1);
        radiobutton2= (RadioButton) findViewById(R.id.radiobutton2);
        textone= (TextView) findViewById(R.id.textone);
        texttwo= (TextView) findViewById(R.id.texttwo);
        textthree= (TextView) findViewById(R.id.textthree);
        textfour= (TextView) findViewById(R.id.textfour);
        buttonone=(Button)findViewById(R.id.buttonone);
        buttonone.setBackgroundColor(Color.GREEN);
        radiogroup=(RadioGroup) findViewById(R.id.rgSex);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radiobutton1){
                    Toast.makeText(RecordActivity.this, "男", Toast.LENGTH_SHORT).show();
                }else if(checkedId==R.id.radiobutton2){
                    Toast.makeText(RecordActivity.this, "女", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_ID);
            }
        });

        buttonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecordActivity.this,PostActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this,onDateSetListener,2016,12,30);
        }
        return null;
    }

    //设置时间之后点击SET就会将时间改为你刚刚设置的时间
    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            System.out.println(year+"-"+monthOfYear+"-"+dayOfMonth);
            textfour.setText("出生日期：          "+year+"-"+monthOfYear+"-"+dayOfMonth);
        }
    };
    //调用onSuppprtNavigateup()为actionbar左上角点击事件
    @Override
    public boolean onSupportNavigateUp() {
       // Intent intent=new Intent(RecordActivity.this,MainActivity.class);//点击回主页
        //startActivity(intent);
        finish();
        return super.onSupportNavigateUp();
    }
}
