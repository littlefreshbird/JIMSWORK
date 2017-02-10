package com.jims.work;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.layout_location)
    LinearLayout layoutLocation;
    @BindView(R.id.tgbtn_load_img)
    ToggleButton tgbtnLoadImg;
    @BindView(R.id.tgbtn_update)
    ToggleButton tgbtnUpdate;
    @BindView(R.id.tv_cache_size)
    TextView tvCacheSize;
    @BindView(R.id.layout_clear_cache)
    LinearLayout layoutClearCache;
    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.layout_about)
    LinearLayout layoutAbout;
    @BindView(R.id.btn_logout)
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        ButterKnife.bind(this);
        setCustomActionBar();

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

          /*  case R.id.layout_location:// 设置位置
                startActivity(new Intent(this, LocationActivity.class));
                break;
            case R.id.layout_about: // 关于
                startActivity(new Intent(this, AboutActivity.class));
                break;
            case R.id.layout_clear_cache: // 清除缓存
                clearCache();
                break;
            case R.id.layout_recom_apps: // 应用推荐
                startActivity(new Intent(this, DownloadActivity.class));
                break;
            case R.id.btn_logout: // 注销
                LogoutDialogFragment fragment = new LogoutDialogFragment();
                fragment.show(getSupportFragmentManager(), null);
                break;*/

            default:
                break;
        }
    }

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView=ButterKnife.findById(mActionBarView,android.R.id.title);
        textView.setText("更多");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.action_bar_back);
        actionBar.setElevation(2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
            default:}
        return super.onOptionsItemSelected(item);
    }


}
