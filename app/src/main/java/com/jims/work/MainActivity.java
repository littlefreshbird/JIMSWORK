package com.jims.work;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.jims.work.bean.Tab;
import com.jims.work.bean.UserBean;
import com.jims.work.fragment.HealthFragment;
import com.jims.work.fragment.HomeFragment;
import com.jims.work.fragment.MineFragment;
import com.jims.work.fragment.ServiceFragment;
import com.jims.work.widget.FragmentTabHost;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends FragmentActivity {
    private UserBean userBean;
    private LayoutInflater mInflater;
    private FragmentTabHost mTabhost;
    private List<Tab> mTabs = new ArrayList<>(4);
    private long exitTime=0;//两次按返回退出
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initData();
        initTab();
    }


    public void initData() {
        UserBean u = (UserBean) getIntent().getSerializableExtra("user");
        this.userBean = u;

    }
    //初始化Tab
    private void initTab() {
        Tab tab_home = new Tab(HomeFragment.class,R.string.home,R.drawable.selector_icon_home);
        Tab tab_health = new Tab(HealthFragment.class,R.string.health,R.drawable.selector_icon_health);
        Tab tab_service = new Tab(ServiceFragment.class,R.string.service,R.drawable.selector_icon_service);
        Tab tab_mine = new Tab(MineFragment.class,R.string.mine,R.drawable.selector_icon_mine);
        mTabs.add(tab_home);
        mTabs.add(tab_health);
        mTabs.add(tab_service);
        mTabs.add(tab_mine);
        mInflater = LayoutInflater.from(this);
        mTabhost = (FragmentTabHost) this.findViewById(android.R.id.tabhost);
        mTabhost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);
        for (Tab tab : mTabs){
            TabHost.TabSpec tabSpec = mTabhost.newTabSpec(getString(tab.getTitle()));
            tabSpec.setIndicator(buildIndicator(tab));
            mTabhost.addTab(tabSpec,tab.getFragment(),null);
        }
        mTabhost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
        mTabhost.setCurrentTab(0);
    }
//Tabhost布局样式
    private View buildIndicator(Tab tab){
        View view =mInflater.inflate(R.layout.tab_indicator,null);
        ImageView img = (ImageView) view.findViewById(R.id.icon_tab);
        TextView text = (TextView) view.findViewById(R.id.txt_indicator);
        img.setBackgroundResource(tab.getIcon());
        text.setText(tab.getTitle());
        return  view;
    }
    @Override
    public void onBackPressed() {


        exit();  ///退出应用

    }

    public void exit() {   //退出应用
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            //System.exit(0);
        }
    }

}
