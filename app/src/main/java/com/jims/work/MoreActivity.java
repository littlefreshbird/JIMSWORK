package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.BindView;

public class MoreActivity extends BaseActivity1 implements View.OnClickListener {


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

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, MoreActivity.class)
                .putExtra("id", bookId));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_more;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("更多");
    }

    @Override
    public void initDatas() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    @Override
    public void configViews() {

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
                break;*/
            case R.id.btn_logout: // 注销
                System.exit(0);
                break;

            default:
                break;
        }
    }



}
