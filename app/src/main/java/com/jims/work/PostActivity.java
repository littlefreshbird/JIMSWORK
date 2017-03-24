package com.jims.work;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Just on 2016/12/25.
 * 提交病例
 */

public class PostActivity extends BaseActivity implements View.OnClickListener {
    private TextView neike,waike,jingshenke,meirongke,fangsheke,nanke,muyingke,guke,huayanke,erbihouke,pifuke,kouqiangke,chanke,xueyeke;
    private EditText edit;
    private GridView gridView;
    private Button button_1;
    private final int IMAGE_OPEN = 1;               //打开图片标记
    private String pathImage;                       //选择图片路径
    private Bitmap bmp;                             //导入临时图片
    private ArrayList<HashMap<String, Object>> imageItem;
    private SimpleAdapter simpleAdapter;     //适配器private static final int PHOTO_SUCCESS = 1;
    private static final int PHOTO_SUCCESS = 1;
    private static final int CAMERA_SUCCESS = 2;
    private boolean bl=false;
    private int position1=0;
    private boolean nei,wai,jingshen,meirong,fangshe,nan,muying,gu,huayan,erbihou,pifu,xueye,kouqiang,chan=false;
    float scaleWidth;
    float scaleHeight;

    /**
     *
     * @param savedInstanceState
     * 初始化页面布局
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        edit=(EditText)findViewById(R.id.edit);
        DisplayMetrics dm=new DisplayMetrics();//创建矩阵
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        button_1=(Button)findViewById(R.id.button_1);//注册档案页
        neike=(TextView) findViewById(R.id.neike);
        waike=(TextView) findViewById(R.id.waike);
        jingshenke=(TextView) findViewById(R.id.jingshenke);
        meirongke=(TextView) findViewById(R.id.meirongke);
        fangsheke=(TextView) findViewById(R.id.fangsheke);
        nanke=(TextView) findViewById(R.id.nanke);
        muyingke=(TextView) findViewById(R.id.muyingke);
        guke=(TextView) findViewById(R.id.guke);
        huayanke=(TextView) findViewById(R.id.huayanke);
        erbihouke=(TextView) findViewById(R.id.erbihouke);
        kouqiangke=(TextView) findViewById(R.id.kouqiangke);
        chanke=(TextView) findViewById(R.id.chanke);
        xueyeke=(TextView) findViewById(R.id.xueyeke);
        pifuke=(TextView) findViewById(R.id.pifuke);
        button_1.setOnClickListener(this);
        neike.setOnClickListener(this);
        waike.setOnClickListener(this);
        jingshenke.setOnClickListener(this);
        meirongke.setOnClickListener(this);
        fangsheke.setOnClickListener(this);
        nanke.setOnClickListener(this);
        muyingke.setOnClickListener(this);
        guke.setOnClickListener(this);
        huayanke.setOnClickListener(this);
        erbihouke.setOnClickListener(this);
        kouqiangke.setOnClickListener(this);
        xueyeke.setOnClickListener(this);
        chanke.setOnClickListener(this);
        pifuke.setOnClickListener(this);


        setCustomActionBar("提交病情");//actionbar格式
        /*
         * 防止键盘挡住输入框
         * 不希望遮挡设置activity属性 android:windowSoftInputMode="adjustPan"
         * 希望动态调整高度 android:windowSoftInputMode="adjustResize"
         */
        getWindow().setSoftInputMode(WindowManager.LayoutParams.
                SOFT_INPUT_ADJUST_PAN);
        //锁定屏幕
       setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //获取控件对象
        gridView = (GridView) findViewById(R.id.gridView);

        /*
         * 载入默认图片添加图片加号
         * 通过适配器实现
         * SimpleAdapter参数imageItem为数据源 R.layout.griditem_addpic为布局
         */
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.gridview_addpic); //加号
        imageItem = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("itemImage", bmp);
        imageItem.add(map);
        simpleAdapter = new SimpleAdapter(this,
                imageItem, R.layout.griditem_addpic,
                new String[] { "itemImage"}, new int[] { R.id.imageView1});
        /*
         *              1.自定义继承BaseAdapter实现
         *              2.ViewBinder()接口实现
         */
        simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
            @Override
            public boolean setViewValue(View view, Object data,
                                        String textRepresentation) {
                if(view instanceof ImageView && data instanceof Bitmap){
                    ImageView i = (ImageView)view;
                    i.setImageBitmap((Bitmap) data);
                    return true;
                }
                return false;
            }
        });
        gridView.setAdapter(simpleAdapter);

        /*
         * 监听GridView点击事件
         * 报错:该函数必须抽象方法 故需要手动导入import android.view.View;
         */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if( imageItem.size() == 6) { //第一张为默认图片
                    Toast.makeText(PostActivity.this, "图片数5张已满", Toast.LENGTH_SHORT).show();
                }
                else if(position == 0) { //点击图片位置为+ 0对应0张图片
                    final CharSequence[] items = { "手机相册", "相机拍摄" };
                    AlertDialog dlg = new AlertDialog.Builder(PostActivity.this).setTitle("选择图片").setItems(items,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int item) {
                                    if(item==1){
                                        Intent getImageByCamera= new Intent("android.media.action.IMAGE_CAPTURE");
                                        startActivityForResult(getImageByCamera, CAMERA_SUCCESS);
                                    }else{
                                        Intent intent = new Intent(Intent.ACTION_PICK,
                                                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                        startActivityForResult(intent, IMAGE_OPEN);
                                    }
                                }
                            }).create();
                    dlg.show();
                }
                else {
                  //增加点击放大效果
                    position1=position;
                    if(bl==false){
                        Animation testAnim = AnimationUtils.loadAnimation(PostActivity.this, R.anim.anim);
                        gridView.getChildAt(position).startAnimation(testAnim);
                        bl=true;
                    }else{
                        bl=false;
                        Animation testAnim = AnimationUtils.loadAnimation(PostActivity.this, R.anim.anim1);
                        gridView.getChildAt(position).startAnimation(testAnim);
                    }
                }
            }
        });
    }

    /**
     *
     * 点击事件
     */
   public void onClick(View v){
         switch (v.getId()) {
             case R.id.button_1:
                 Intent intent = new Intent(PostActivity.this,RecordActivity.class);//
                 startActivity(intent);
                 PostActivity.this.finish();
                 break;
             case R.id.neike:
                 if(nei==false){
                     neike.setBackgroundColor(Color.GREEN);
                     nei=true;
                 }else{
                     neike.setBackgroundColor(Color.WHITE);
                     nei=false;
                 }
                 break;
             case R.id.waike:
                 if(wai==false){
                     waike.setBackgroundColor(Color.GREEN);
                     wai=true;
                 }else{
                     waike.setBackgroundColor(Color.WHITE);
                     wai=false;
                 }
                 break;
             case R.id.jingshenke:
                 if(jingshen==false){
                     jingshenke.setBackgroundColor(Color.GREEN);
                     jingshen=true;
                 }else{
                     jingshenke.setBackgroundColor(Color.WHITE);
                     jingshen=false;
                 }
                 break;
             case R.id.meirongke:
                 if(meirong==false){
                     meirongke.setBackgroundColor(Color.GREEN);
                     meirong=true;
                 }else{
                     meirongke.setBackgroundColor(Color.WHITE);
                     meirong=false;
                 }
                 break;
             case R.id.fangsheke:
                 if(fangshe==false){
                     fangsheke.setBackgroundColor(Color.GREEN);
                     fangshe=true;
                 }else{
                     fangsheke.setBackgroundColor(Color.WHITE);
                     fangshe=false;
                 }
                 break;
             case R.id.nanke:
                 if(nan==false){
                     nanke.setBackgroundColor(Color.GREEN);
                     nan=true;
                 }else{
                     nanke.setBackgroundColor(Color.WHITE);
                     nan=false;
                 }
                 break;
             case R.id.muyingke:
                 if(muying==false){
                     muyingke.setBackgroundColor(Color.GREEN);
                     muying=true;
                 }else{
                     muyingke.setBackgroundColor(Color.WHITE);
                     muying=false;
                 }
                 break;
             case R.id.guke:
                 if(gu==false){
                     guke.setBackgroundColor(Color.GREEN);
                     gu=true;
                 }else{
                     guke.setBackgroundColor(Color.WHITE);
                     gu=false;
                 }
                 break;
             case R.id.huayanke:
                 if(huayan==false){
                     huayanke.setBackgroundColor(Color.GREEN);
                     huayan=true;
                 }else{
                     huayanke.setBackgroundColor(Color.WHITE);
                     huayan=false;
                 }
                 break;
             case R.id.erbihouke:
                 if(erbihou==false){
                     erbihouke.setBackgroundColor(Color.GREEN);
                     erbihou=true;
                 }else{
                     erbihouke.setBackgroundColor(Color.WHITE);
                     erbihou=false;
                 }
                 break;
             case R.id.kouqiangke:
                 if(kouqiang==false){
                     kouqiangke.setBackgroundColor(Color.GREEN);
                     kouqiang=true;
                 }else{
                     kouqiangke.setBackgroundColor(Color.WHITE);
                     kouqiang=false;
                 }
                 break;
             case R.id.pifuke:
                 if(pifu==false){
                     pifuke.setBackgroundColor(Color.GREEN);
                     pifu=true;
                 }else{
                     pifuke.setBackgroundColor(Color.WHITE);
                     pifu=false;
                 }
                 break;
             case R.id.xueyeke:
                 if(xueye==false){
                     xueyeke.setBackgroundColor(Color.GREEN);
                     xueye=true;
                 }else{
                     xueyeke.setBackgroundColor(Color.WHITE);
                     xueye=false;
                 }
                 break;
             case R.id.chanke:
                 if(chan==false){
                     chanke.setBackgroundColor(Color.GREEN);
                     chan=true;
                 }else{
                     chanke.setBackgroundColor(Color.WHITE);
                     chan=false;
                 }
                 break;
             default:
                 break;

         }

   }
  /*  //调用onSuppprtNavigateup()为actionbar左上角点击事件
    @Override
    public boolean onSupportNavigateUp() {
        Intent intent=new Intent(PostActivity.this,MainActivity.class);//点击回主页
        startActivity(intent);
        finish();
        return super.onSupportNavigateUp();
    }*/

    /**
     *
     *  调用menu中的main资源
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            case R.id.action:
               openInputMethod(edit);
                return true;
            case R.id.action_photo:
                if(position1==0){
                    Toast.makeText(this, "不能删除", Toast.LENGTH_SHORT).show();
                    return false;
                }else{
                    dialog(position1);//删除照片
                    return true;
                }
            case R.id.action_fanhui:
                Intent intent0= new Intent(PostActivity.this,RecordActivity.class);
                startActivity(intent0);
                PostActivity.this.finish();
                return true;
            case R.id.action_qianjin:
                Intent intent= new Intent(PostActivity.this,RecordActivity.class);
                startActivity(intent);
                PostActivity.this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    /**
     * @Description:关闭系统软键盘
     */
    public void closeInputMethod(){
        try {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE))
                    .hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) { }finally{ }
    }
    /**
     * @Description:打开系统软键盘
     */
    public void openInputMethod(final EditText editText){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                InputMethodManager inputManager = (InputMethodManager) editText
                        .getContext().getSystemService(
                                Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(editText, 0);

            }

        }, 200);
    }


    /**
     *
     * @param requestCode
     * @param resultCode
     * @param data
     * 获取图片路径 响应startActivityForResult
     *
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //打开图片
        if(resultCode==RESULT_OK && requestCode==IMAGE_OPEN) {
            Uri uri = data.getData();
            if (!TextUtils.isEmpty(uri.getAuthority())) {
                //查询选择图片
                Cursor cursor = getContentResolver().query(
                        uri,
                        new String[] { MediaStore.Images.Media.DATA },
                        null,
                        null,
                        null);
                //返回 没找到选择图片
                if (null == cursor) {
                    return;
                }
                //光标移动至开头 获取图片路径
                cursor.moveToFirst();
                pathImage = cursor.getString(cursor
                        .getColumnIndex(MediaStore.Images.Media.DATA));
            }
        }  //end if 打开图片
    }
    /**
     * 刷新图片
     */
    @Override
    protected void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(pathImage)){
            Bitmap addbmp= BitmapFactory.decodeFile(pathImage);
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("itemImage", addbmp);
            imageItem.add(map);
            simpleAdapter = new SimpleAdapter(this,
                    imageItem, R.layout.griditem_addpic,
                    new String[] { "itemImage"}, new int[] { R.id.imageView1});
          simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() {
                @Override
                public boolean setViewValue(View view, Object data,
                                            String textRepresentation) {
                    // TODO Auto-generated method stub
                    if(view instanceof ImageView && data instanceof Bitmap){
                        ImageView i = (ImageView)view;
                        i.setImageBitmap((Bitmap) data);
                        return true;
                    }
                    return false;
                }
            });
            gridView.setAdapter(simpleAdapter);
            simpleAdapter.notifyDataSetChanged();
            //刷新后释放防止手机休眠后自动添加
            pathImage = null;
        }
    }


    /*
     * Dialog对话框提示用户删除操作
     * position为删除图片位置
     */
    protected void dialog(final int position) {
      AlertDialog.Builder builder = new AlertDialog.Builder(PostActivity.this);
        builder.setMessage("确认移除已添加图片吗？");
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                imageItem.remove(position);
                simpleAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }

}

