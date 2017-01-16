package com.jims.work;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DialogTitle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


/**
 * Created by Just on 2016/12/29.
 */

public class RecordcaseActivity extends AppCompatActivity {
    private EditText editone;
    private RadioButton radiobutton1,radiobutton2;
    private TextView textone,textthree,textfour,textfive ;
    private TextView buttonone,buttontwo;
    private RadioGroup radiogroup;
    private static final int DATE_ID = 1;
    private int mYear;
    private int mMonth;
    private int mDay;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_case);
        setCustomActionBar();
        editone = (EditText) findViewById(R.id.editone);
      //  edittwo = (EditText) findViewById(R.id.edittwo);
        radiobutton1= (RadioButton) findViewById(R.id.radiobutton1);
        radiobutton2= (RadioButton) findViewById(R.id.radiobutton2);
        //textone= (TextView) findViewById(R.id.textone);
        textthree= (TextView) findViewById(R.id.textthree);
        textfive= (TextView) findViewById(R.id.textfive);
        buttonone=(Button)findViewById(R.id.buttonone);
        buttontwo=(Button)findViewById(R.id.buttontwo);
        //buttontwo.setBackgroundColor(Color.GREEN);
        radiogroup=(RadioGroup) findViewById(R.id.rgSex);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radiobutton1){
                    Toast.makeText(RecordcaseActivity.this, "您选择了门诊病历", Toast.LENGTH_SHORT).show();
                }else if(checkedId==R.id.radiobutton2){
                    Toast.makeText(RecordcaseActivity.this, "您选择了住院病历", Toast.LENGTH_SHORT).show();
                }
            }
        });

        textfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(RecordcaseActivity.this,
                        onDateSetListener,
                        mYear, mMonth, mDay).show();*/
                showDialog(DATE_ID);
            }
        });

        buttontwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RecordcaseActivity.this, "已提交病例", Toast.LENGTH_SHORT).show();
            }
        });
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
    }
    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this,mDateSetListener,2016,12,30);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            updateDisplay();
        }
    };
    private void updateDisplay() {
        textfive.setText(new StringBuilder().append(mYear).append("-")
                .append(mMonth + 1).append("-").append(mDay).append(" "));
    }


    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(RecordcaseActivity.this,CaseLoadingActivity.class);
                startActivity(intent);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_recordcase, null);
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
