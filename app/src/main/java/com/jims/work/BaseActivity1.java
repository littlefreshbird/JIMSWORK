package com.jims.work;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.jims.work.utils.StatusBarCompat;
import com.jims.work.view.lodding.CustomDialog;

import butterknife.ButterKnife;

public abstract class BaseActivity1 extends AppCompatActivity {
    public Toolbar mCommonToolbar;
    public TextView toolbarTitle;
    protected Context mContext;
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    private CustomDialog dialog;//进度条
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        mContext = this;
        ButterKnife.bind(this);
        if (statusBarColor == 0) {
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        } else if (statusBarColor != -1) {
            statusBarView = StatusBarCompat.compat(this, statusBarColor);
        }
        mCommonToolbar = ButterKnife.findById(this, R.id.common_toolbar);
        toolbarTitle= ButterKnife.findById(this, R.id.toolbar_title);
        if (mCommonToolbar != null) {
            mCommonToolbar.setTitle("");
            mCommonToolbar.setBackgroundColor(R.color.gray);
            initToolBar();
            setSupportActionBar(mCommonToolbar);
        }
        initDatas();
        configViews();

    }

    public abstract int getLayoutId();
    public abstract void initToolBar();

    public abstract void initDatas();

    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();
    // dialog
    public CustomDialog getDialog() {
        if (dialog == null) {
            dialog = CustomDialog.instance(this);
            dialog.setCancelable(true);
        }
        return dialog;
    }

    public void hideDialog() {
        if (dialog != null)
            dialog.hide();
    }

    public void showDialog() {
        getDialog().show();
    }
    public void dismissDialog() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();

        dismissDialog();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    protected void hideStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    protected void showStatusBar() {
        WindowManager.LayoutParams attrs = getWindow().getAttributes();
        attrs.flags &= ~WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attrs);
        if(statusBarView != null){
            statusBarView.setBackgroundColor(statusBarColor);
        }
    }
}
