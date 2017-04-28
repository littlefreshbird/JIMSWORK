package com.jims.work;

/*****
 * 我的投诉详情
 */
public class MyComplaintDetailActivity extends BaseActivity1 {


    @Override
    public int getLayoutId() {
        return R.layout.activity_mycomplaint_detail;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("投诉详情");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
