package com.jims.work;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    TextView sex;
    @BindView(R.id.sex_info1)
    RelativeLayout sexInfo;
    int yourChoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserInfoActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_userinfo);
        ButterKnife.bind(this);
        setOnListener();
        userinfoBack.setOnClickListener(this);
    }

    private void setOnListener() {

        userinfoBack.setOnClickListener(this);
        usernameInfo.setOnClickListener(this);


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
            default:
                break;
        }
    }

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
                        nameText.setTextSize(12);
                    }
                }).show();
    }



    private void showSingleChoiceDialog() {

        final String[] items = {"男", "女"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        singleChoiceDialog.setTitle("性别");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 1,
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
                        }
                    }
                });
        singleChoiceDialog.show();
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
        nameText.setTextSize(12);

    }
}
