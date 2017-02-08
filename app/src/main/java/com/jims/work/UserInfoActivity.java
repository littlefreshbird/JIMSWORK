package com.jims.work;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jims.work.utils.SdCardUtil;
import com.jims.work.view.CircleImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    String fileName = String.valueOf(System.currentTimeMillis()) + ".jpg";
    @BindView(R.id.generate_qrcode)
    RelativeLayout generateQrcode;
    private View slidView;
    @BindView(R.id.userinfo_back)
    ImageView userinfoBack;
    @BindView(R.id.username_info)
    RelativeLayout usernameInfo;
    @BindView(R.id.name_text)
    TextView nameText;
    @BindView(R.id.sex)
    TextView user_sex;
    @BindView(R.id.sex_info1)
    RelativeLayout sexInfo;
    int yourChoice;
    int mYear, mMonth, mDay;//日期弹窗定义年月日
    final int DATE_DIALOG = 1;//日期弹窗
    @BindView(R.id.datepicker)
    RelativeLayout datepicker;
    @BindView(R.id.dateDisplay)
    TextView dateDisplay;
    @BindView(R.id.heights)
    TextView heights;
    @BindView(R.id.user_height)
    RelativeLayout userHeight;
    @BindView(R.id.address)
    TextView address1;
    @BindView(R.id.user_address)
    RelativeLayout userAddress;
    @BindView(R.id.userIcon)
    CircleImageView userIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserInfoActivity.this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_userinfo);
        slidView = LayoutInflater.from(UserInfoActivity.this).inflate(R.layout.activity_userinfo, null);
        ButterKnife.bind(this);
        setOnListener();
        final Calendar ca = Calendar.getInstance();
        mYear = ca.get(Calendar.YEAR);
        mMonth = ca.get(Calendar.MONTH);
        mDay = ca.get(Calendar.DAY_OF_MONTH);

    }

    private void setOnListener() {
        userIcon.setOnClickListener(this);
        userinfoBack.setOnClickListener(this);
        usernameInfo.setOnClickListener(this);
        sexInfo.setOnClickListener(this);
        datepicker.setOnClickListener(this);
        userHeight.setOnClickListener(this);
        userAddress.setOnClickListener(this);
        generateQrcode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userIcon://上传头像
                new SelectPopuWindow(UserInfoActivity.this, slidView);
                break;
            case R.id.userinfo_back://返回
                finish();
                break;
            case R.id.username_info://姓名
                showInputDialog();
                break;
            case R.id.sex_info1:
                showSingleChoiceDialog();//性别
                break;
            case R.id.datepicker://出生日期
                showDialog(DATE_DIALOG);
                break;
            case R.id.generate_qrcode://二维码
               Intent intent=new Intent(UserInfoActivity.this,QRCodeActivity.class);
                startActivity(intent);
                break;
            case R.id.user_height://身高
                showInputDialog1();
                break;
            case R.id.user_address://地址
                showInputDialog2();
                break;
            default:
                break;
        }
    }


    //上传头像

    public class SelectPopuWindow extends PopupWindow {

        private Context context;

        public SelectPopuWindow(Context mContext, View parent) {

            this.context = mContext;
            View view = View
                    .inflate(mContext, R.layout.item_popupwindows, null);
            view.startAnimation(AnimationUtils.loadAnimation(mContext,
                    R.anim.fade_ins));
            LinearLayout ll_popup = (LinearLayout) view
                    .findViewById(R.id.ll_popup);
            ll_popup.startAnimation(AnimationUtils.loadAnimation(mContext,
                    R.anim.push_bottom_in_2));

            setWidth(LayoutParams.FILL_PARENT);
            setHeight(LayoutParams.FILL_PARENT);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setContentView(view);
            showAtLocation(parent, Gravity.BOTTOM, 0, 0);
            update();

            Button bt1 = (Button) view
                    .findViewById(R.id.item_popupwindows_camera);
            Button bt2 = (Button) view
                    .findViewById(R.id.item_popupwindows_Photo);
            Button bt3 = (Button) view
                    .findViewById(R.id.item_popupwindows_cancel);


            /**
             * 拍照
             */
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), fileName));
                    openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(openCameraIntent, 1);
                    dismiss();
                }
            });
            bt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (SdCardUtil.checkSdCard() == true) {
                        Intent intent = new Intent(Intent.ACTION_PICK);
                        intent.setType("image/*");// 相片类型
                        startActivityForResult(intent, 2);
                    } else {
                        Toast.makeText(UserInfoActivity.this, "SD卡不存在",
                                Toast.LENGTH_LONG).show();
                    }

                    dismiss();
                }
            });
            bt3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
        }
    }
    //保存照片到文件
    public void saveImageToFile(Bitmap bitmap) {

        FileOutputStream fos = null;
        String fileName = SdCardUtil.getSdPath() + SdCardUtil.FILEDIR + "/"
                + SdCardUtil.FILEUSER + "/icon" + "/" + "userIcon"
                + String.valueOf(System.currentTimeMillis()) + ".png";

        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
        try {
            fos = new FileOutputStream(fileName);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fos.flush();
                if (bitmap != null) {
                    bitmap.recycle();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {


                Toast.makeText(UserInfoActivity.this, fileName + "上传成功",
                        Toast.LENGTH_LONG).show();




                //initProgressDialog();
                // AjaxParams ap = new AjaxParams();
             /*   try {
                    ap.put("file", new File(fileName));
                    ap.put("id", userBean.getId());
                    FinalHttp fh = new FinalHttp();
                    fh.post(HttpConstants.HTTP_UPDATE_USERICON, ap,
                            new AjaxCallBack<Object>() {

                                @Override
                                public void onFailure(Throwable t, int errorNo,
                                                      String strMsg) {
                                    // TODO Auto-generated method stub
                                    super.onFailure(t, errorNo, strMsg);
                                    Toast.makeText(UserInfoActivity.this, "修改图像失败",
                                            Toast.LENGTH_LONG).show();
                                    close();
                                }

                                @Override
                                public void onSuccess(Object t) {
                                    // TODO Auto-generated method stub
                                    super.onSuccess(t);
                                    close();
                                    Toast.makeText(UserInfoActivity.this,
                                            String.valueOf(t),
                                            Toast.LENGTH_LONG).show();
                                }

                            });
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    close();
                }*/
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int respCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, respCode, data);

        if (requestCode == 1 && respCode == RESULT_OK) {

            Uri uri = null;
            if (data != null) {
                uri = data.getData();
                System.out.println("Data");
            } else {
                uri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), fileName));
            }

            cropImage(uri, 98, 98, 3);


        } else if (requestCode == 2 && respCode == RESULT_OK) {
            ContentResolver resolver = getContentResolver();
            Uri uri = data.getData();
            try {
                /*Bitmap bitmap = MediaStore.Images.Media
						.getBitmap(resolver, uri);*/
                cropImage(uri, 98, 98, 3);
				/*Bitmap resizeBmp = ThumbnailUtils.extractThumbnail(bitmap, 88,
						88);
				userIcon.setImageBitmap(resizeBmp);
				saveImageToFile(bitmap);*/
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (requestCode == 3 && respCode == RESULT_OK) {
            Bitmap photo = null;
            Uri photoUri = data.getData();
            if (photoUri != null) {
                photo = BitmapFactory.decodeFile(photoUri.getPath());
            }
            if (photo == null) {
                Bundle extra = data.getExtras();
                if (extra != null) {
                    photo = (Bitmap) extra.get("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                }
            }
            if (photo != null) {

                Bitmap resizeBmp = ThumbnailUtils.extractThumbnail(photo, 98, 98);
                userIcon.setImageBitmap(resizeBmp);
                saveImageToFile(photo);
            }

        }
    }


    //截取图片
    public void cropImage(Uri uri, int outputX, int outputY, int requestCode) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", outputX);
        intent.putExtra("outputY", outputY);
        intent.putExtra("outputFormat", "JPEG");
        intent.putExtra("noFaceDetection", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, requestCode);
    }

    //姓名
    private void showInputDialog() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(UserInfoActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        inputDialog.setTitle("输入姓名").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       /* Toast.makeText(UserInfoActivity.this,
                                editText.getText().toString(),
                                Toast.LENGTH_SHORT).show();*/
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();

                        editor.putString("name", editText.getText().toString());

                        editor.commit();
                        nameText.setText(editText.getText().toString());
                        nameText.setTextSize(14);
                    }
                }).show();
    }

    //性别
    private void showSingleChoiceDialog() {

        final String[] items = {"男", "女"};
        yourChoice = -1;
        AlertDialog.Builder singleChoiceDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        singleChoiceDialog.setTitle("请选择性别");
        // 第二个参数是默认选项，此处设置为0
        singleChoiceDialog.setSingleChoiceItems(items, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        yourChoice = which;
                    }
                });
        singleChoiceDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (yourChoice != -1) {
                            Toast.makeText(UserInfoActivity.this,
                                    "你选择了" + items[yourChoice],
                                    Toast.LENGTH_SHORT).show();
                            SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();

                            editor.putString("sex", items[yourChoice]);

                            editor.commit();
                            user_sex.setText(items[yourChoice]);
                            user_sex.setTextSize(14);
                        }
                    }
                });
        singleChoiceDialog.show();
    }

    //出生日期
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG:
                return new DatePickerDialog(this, mdateListener, mYear, mMonth, mDay);
        }
        return null;
    }

    /**
     * 设置日期 利用StringBuffer追加
     */
    public void display() {
        dateDisplay.setText(new StringBuffer().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay).append(" "));
    }

    private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;
            display();
        }
    };

    //身高
    private void showInputDialog1() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(UserInfoActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        inputDialog.setTitle("填写身高(cm)").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("height", editText.getText().toString());
                        editor.commit();
                        heights.setText(editText.getText().toString() + "cm");
                        heights.setTextSize(14);
                    }
                }).show();
    }

    //详细地址
    private void showInputDialog2() {
    /*@setView 装入一个EditView
     */
        final EditText editText = new EditText(UserInfoActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(UserInfoActivity.this);
        inputDialog.setTitle("输入详细地址").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("address", editText.getText().toString());
                        editor.commit();
                        address1.setText(editText.getText().toString());
                        address1.setTextSize(14);
                    }
                }).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        initmessage();
    }

    private void initmessage() {
        SharedPreferences preferences = getSharedPreferences("user", Context.MODE_PRIVATE);
        String name = preferences.getString("name", "未填写");

        nameText.setText(name);
        nameText.setTextSize(14);

        String sex = preferences.getString("sex", "男");

        user_sex.setText(sex);
        user_sex.setTextSize(14);
        String height = preferences.getString("height", "未填写");

        heights.setText(height + "cm");
        heights.setTextSize(14);
        String address = preferences.getString("address", "未填写");

        address1.setText(address);
        address1.setTextSize(14);
    }
}
