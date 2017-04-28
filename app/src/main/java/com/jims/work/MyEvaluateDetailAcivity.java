package com.jims.work;

/*****
 * 我的评价详情
 */
public class MyEvaluateDetailAcivity extends BaseActivity1 {



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
