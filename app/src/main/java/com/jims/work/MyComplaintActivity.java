package com.jims.work;

/****
 * 我的投诉
 */
public class MyComplaintActivity extends BaseActivity1 {


    @Override
    public int getLayoutId() {
        return R.layout.activity_mycomplaint;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("我的投诉");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
