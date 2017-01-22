package com.jims.work;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.BGAQRCodeUtil;
import cn.bingoogolapple.qrcode.zxing.QRCodeEncoder;

public class QRCodeActivity extends AppCompatActivity {

    private ImageView ivqr;
    private Bitmap bp;
    private String str = "woshi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        setCustomActionBar();
        ivqr = (ImageView) findViewById(R.id.iv_qr);
       //创建带logo
        createQRCodeWithLogo();

    }
    private void createQRCodeWithLogo() {

        new AsyncTask<Void, Void, Bitmap>() {
            @Override
            protected Bitmap doInBackground(Void... params) {

                str="sasas";
                Bitmap logoBitmap = BitmapFactory.decodeResource(QRCodeActivity.this.getResources(), R.drawable.person_no_login);
                return QRCodeEncoder.syncEncodeQRCode(str, BGAQRCodeUtil.dp2px(QRCodeActivity.this, 150), Color.BLACK, Color.WHITE, logoBitmap);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    ivqr.setImageBitmap(bitmap);
                    bp = bitmap;
                } else {
                    Toast.makeText(QRCodeActivity.this, "生成带logo的二维码失败", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }
    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView= ButterKnife.findById(mActionBarView,android.R.id.title);
        textView.setText("我的二维码名片");
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
}
