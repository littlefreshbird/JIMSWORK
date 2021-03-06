package com.jims.work;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class CodeScanActivity extends BaseActivity1 implements QRCodeView.Delegate {
    private static final String TAG = CodeScanActivity.class.getSimpleName();
    private static final int REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 666;

    private QRCodeView mQRCodeView;
private Button open_flashlight,close_flashlight;
 
    @Override
    public int getLayoutId() {
        return R.layout.activity_codescan;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("扫描二维码");
    }

    @Override
    public void initDatas() {
        open_flashlight= (Button) findViewById(R.id.open_flashlight);
        close_flashlight= (Button) findViewById(R.id.close_flashlight);
        mQRCodeView = (ZXingView) findViewById(R.id.zxingview);
        mQRCodeView.setDelegate(this);

        mQRCodeView.startSpot();
        //mQRCodeView.showScanRect();//显示扫描框
        mQRCodeView.startSpotAndShowRect();//延时1.5s识别
        mQRCodeView.changeToScanQRCodeStyle();
    }

    @Override
    public void configViews() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mQRCodeView.stopSpot();
                finish();
            default:}
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
//        mQRCodeView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        if (result.equals("")) {
            Toast.makeText(CodeScanActivity.this, "扫描失败!", Toast.LENGTH_SHORT).show();
        }else {
            Intent resultIntent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("result", result);

            resultIntent.putExtras(bundle);
            this.setResult(RESULT_OK, resultIntent);
        }
        //CodeScanActivity.this.finish();
        vibrate();
        mQRCodeView.startSpot();
        Toast.makeText(CodeScanActivity.this, result,Toast.LENGTH_SHORT).show();
    }
   /* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
            Toast.makeText(CodeScanActivity.this, scanResult,Toast.LENGTH_SHORT).show();
        }
    }*/
    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }

   public void onClick(View v) {
       switch (v.getId()) {
            case R.id.open_flashlight://开灯
                mQRCodeView.openFlashlight();
                break;
            case R.id.close_flashlight://关灯
                mQRCodeView.closeFlashlight();
                break;


       }

   }

}
