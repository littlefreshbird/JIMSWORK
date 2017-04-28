package com.jims.work;

/*****
 * 我的评价
 */
public class MyEvaluateActivity extends BaseActivity1 {


    @Override
    public int getLayoutId() {
        return R.layout.activity_myevaluate;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("我的评价");
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }

}
