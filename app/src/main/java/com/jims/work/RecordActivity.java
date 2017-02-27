package com.jims.work;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
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
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.ButterKnife;


/**
 * Created by Just on 2016/12/29.
 * 创建档案或选择已有档案
 */

public class RecordActivity extends BaseActivity {
    private EditText editone,edittwo;
    private RadioButton radiobutton1,radiobutton2;
    private TextView textone,texttwo,textthree,textfour,textfive ;
    private TextView buttonone,buttontwo;
    private RadioGroup radiogroup;
    private static final int DATE_ID = 1;
    private int mYear;
    private int mMonth;
    private int mDay;
    /**
     *
     * @param savedInstanceState
     * 初始化页面布局
     */
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        setCustomActionBar("注册档案");
        editone = (EditText) findViewById(R.id.editone);
        radiobutton1= (RadioButton) findViewById(R.id.radiobutton1);
        radiobutton2= (RadioButton) findViewById(R.id.radiobutton2);
        textthree= (TextView) findViewById(R.id.textthree);
        textfour= (TextView) findViewById(R.id.textfour);
        textfive= (TextView) findViewById(R.id.textfive);
        buttonone=(Button)findViewById(R.id.buttonone);
        buttonone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecordActivity.this,OldrecordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        buttontwo=(Button)findViewById(R.id.buttontwo);
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
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        textfive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_ID);

            }
        });

        buttontwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RecordActivity.this,NewDoctorListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /**
     *
     * @param id
     * @return
     * 展现时钟控件
     */
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

    /**
     * 展示时间画面
     */
    private void updateDisplay() {
        textfive.setText(new StringBuilder().append(mYear).append("-")
                .append(mMonth + 1).append("-").append(mDay).append(" "));
    }

   /* //设置时间之后点击SET就会将时间改为你刚刚设置的时间
    DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            System.out.println(year+"-"+monthOfYear+"-"+dayOfMonth);
            textfive.setText(year+"-"+monthOfYear+"-"+dayOfMonth);
            textfive.setTextSize(12);
            textfive.setTextColor(Color.BLACK);

        }
    };*/

    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(RecordActivity.this,PostActivity.class);
                startActivity(intent);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
