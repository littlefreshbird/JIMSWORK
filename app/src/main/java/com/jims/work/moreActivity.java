package com.jims.work;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreActivity extends FragmentActivity implements View.OnClickListener {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.layout_login_topbar)
    RelativeLayout layoutLoginTopbar;
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
        imgBack.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
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




}
