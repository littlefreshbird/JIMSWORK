package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SubscibeDetailActivity extends BaseActivity1 {

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, SubscibeDetailActivity.class)
                .putExtra("id", bookId));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_subscibe_detail;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("服务详情");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
