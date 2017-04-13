package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.jims.work.fragment.ServiceFragment;

public class MyinquiryDetailAcivity extends BaseActivity1 {
    private ImageView mimageView;

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, MyinquiryDetailAcivity.class)
                .putExtra("id", bookId));
    }
    @Override
    public int getLayoutId() {
        return R.layout.myinquiry;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("我的问诊");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

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
                ServiceFragment serviceFragment=new ServiceFragment();
                serviceFragment.setMenuVisibility(true);
                // Intent intent=new Intent(MyinquiryDetailAcivity.this,ServiceFragment.class);
                // startActivity(intent);
                finish();
            case R.id.action:

                return true;
            case R.id.action_photo:
                return true;
            case R.id.action_fanhui:

                return true;
            case R.id.action_qianjin:
                Toast.makeText(this, "提交完成", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
