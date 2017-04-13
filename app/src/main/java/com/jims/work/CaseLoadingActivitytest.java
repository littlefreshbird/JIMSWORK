package com.jims.work;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;

import static com.jims.work.R.menu.main;

/**
 * 病例详情页
 */
public class CaseLoadingActivitytest extends BaseActivity1 {
    private GridView gridView;
    private Button button_1;
    private final int IMAGE_OPEN = 1;        //打开图片标记
    private String pathImage;                       //选择图片路径
    private Bitmap bmp;                               //导入临时图片
    private ArrayList<HashMap<String, Object>> imageItem;
    private SimpleAdapter simpleAdapter;     //适配器private static final int PHOTO_SUCCESS = 1;
    private static final int PHOTO_SUCCESS = 1;
    private static final int CAMERA_SUCCESS = 2;
    private boolean bl=false;
    private int position1=0;



    @Override
    public int getLayoutId() {
        return R.layout.activity_caseloadingtest;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("病例详情");
    }

    @Override
    public void initDatas() {
        button_1=(Button)findViewById(R.id.button_1) ;
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(CaseLoadingActivitytest.this,MainActivity.class);
                startActivity(intent);
                CaseLoadingActivitytest.this.finish();
            }
        });

        /*
         * 防止键盘挡住输入框
         * 不希望遮挡设置activity属性 android:windowSoftInputMode="adjustPan"
         * 希望动态调整高度 android:windowSoftInputMode="adjustResize"
         */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.
                SOFT_INPUT_ADJUST_PAN);
        //锁定屏幕
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void configViews() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(main,menu);
        return super.onCreateOptionsMenu(menu);
    }

}
