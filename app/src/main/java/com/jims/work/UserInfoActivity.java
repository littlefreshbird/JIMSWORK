package com.jims.work;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.userinfo_back)
    ImageView userinfoBack;
    @BindView(R.id.username_info)
    RelativeLayout usernameInfo;
    @BindView(R.id.name_text)
    TextView nameText;
    @BindView(R.id.sex)
    TextView user_sex;
    @BindView(R.id.sex_info1)
    RelativeLayout sexInfo;
    int yourChoice;
    int mYear, mMonth, mDay;//日期弹窗定义年月日
    final int DATE_DIALOG = 1;//日期弹窗
    @BindView(R.id.datepicker)
    RelativeLayout datepicker;
    @BindView(R.id.dateDisplay)
    TextView dateDisplay;
    @BindView(R.id.heights)
    TextView heights;
    @BindView(R.id.user_height)
    RelativeLayout userHeight;
    @BindView(R.id.address)
    TextView address1;
    @BindView(R.id.user_address)
    RelativeLayout userAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserInfoActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_userinfo);
        ButterKnife.bind(this);
        setOnListener();
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

    }

    private void setOnListener() {

        userinfoBack.setOnClickListener(this);
        usernameInfo.setOnClickListener(this);
        sexInfo.setOnClickListener(this);
        datepicker.setOnClickListener(this);
        userHeight.setOnClickListener(this);
        userAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userinfo_back:
                finish();
                break;
            case R.id.username_info:
                showInputDialog();
                break;
            case R.id.sex_info1:
                showSingleChoiceDialog();
                break;
            case R.id.datepicker:
                showDialog(DATE_DIALOG);
                break;
            case R.id.user_height:
                showInputDialog1();
                break;
            case R.id.user_address:
                showInputDialog2();
                break;
            default:
                break;
        }
    }

    //姓名
    private void showInputDialog() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(UserInfoActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        inputDialog.setTitle("输入姓名").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       /* Toast.makeText(UserInfoActivity.this,
                                editText.getText().toString(),
                                Toast.LENGTH_SHORT).show();*/
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();

                        editor.putString("name", editText.getText().toString());

                        editor.commit();
                        nameText.setText(editText.getText().toString());
                        nameText.setTextSize(14);
                    }
                }).show();
    }

    //性别
    private void showSingleChoiceDialog() {

        final String[] items = {"男", "女"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        singleChoiceDialog.setTitle("请选择性别");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            Toast.makeText(UserInfoActivity.this,
                                    "你选择了" + items[yourChoice],
                                    Toast.LENGTH_SHORT).show();
                            SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();

                            editor.putString("sex", items[yourChoice]);

                            editor.commit();
                            user_sex.setText(items[yourChoice]);
                            user_sex.setTextSize(14);
                        }
                    }
                });
        singleChoiceDialog.show();
    }

    //出生日期
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        dateDisplay.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

    //身高
    private void showInputDialog1() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(UserInfoActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        inputDialog.setTitle("填写身高(cm)").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("height", editText.getText().toString());
                        editor.commit();
                        heights.setText(editText.getText().toString() + "cm");
                        heights.setTextSize(14);
                    }
                }).show();
    }
    //详细地址
    private void showInputDialog2() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(UserInfoActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        inputDialog.setTitle("输入详细地址").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("address", editText.getText().toString());
                        editor.commit();
                        address1.setText(editText.getText().toString());
                        address1.setTextSize(14);
                    }
                }).show();
    }
    @Override
    public void onResume() {
        super.onResume();
        initmessage();
    }

    private void initmessage() {
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "未填写");

        nameText.setText(name);
        nameText.setTextSize(14);

        String sex = preferences.getString("sex", "男");

        user_sex.setText(sex);
        user_sex.setTextSize(14);
        String height = preferences.getString("height", "未填写");

        heights.setText(height + "cm");
        heights.setTextSize(14);
        String address = preferences.getString("address", "未填写");

        address1.setText(address);
        address1.setTextSize(14);
    }
}
