package com.jims.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import com.jims.work.utils.Utils;

public class EvaluateDetailActivity extends BaseActivity1 {
    private	String itemclick="";



    @Override
    public int getLayoutId() {
        return R.layout.activity_item_details_top;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("评价详情");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}


