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

/**
 * 我的二维码名片
 */
public class QRCodeActivity extends BaseActivity1 {

    private ImageView ivqr;
    private Bitmap bp;
    private String str = "woshi";


    @Override
    public int getLayoutId() {
        return R.layout.activity_qrcode;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("我的二维码名片");
    }

    @Override
    public void initDatas() {

        ivqr = (ImageView) findViewById(R.id.iv_qr);
        //创建带logo二维码
        createQRCodeWithLogo();
    }

    @Override
    public void configViews() {

    }

    //创建带logo二维码
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

}
