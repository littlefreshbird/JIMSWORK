package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
/*****
 * 我的评价详情
 */
public class MyEvaluateDetailAcivity extends BaseActivity1 {
    private ImageView mimageView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_myevaluate_detail;
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
