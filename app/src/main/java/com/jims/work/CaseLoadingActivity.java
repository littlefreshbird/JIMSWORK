package com.jims.work;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.login.LoginException;

import static com.jims.work.R.menu.main;

/**
 * 病例上传
 */
public class CaseLoadingActivity extends BaseActivity1 {
    private EditText edit;
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
        return R.layout.activity_caseloading;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("提交病情");
    }

    @Override
    public void initDatas() {
        edit=(EditText)findViewById(R.id.edit);
        button_1=(Button)findViewById(R.id.button_1);
        //button_1.setBackgroundColor(Color.GREEN);
        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(CaseLoadingActivity.this,RecordcaseActivity.class);
                startActivity(intent);
                CaseLoadingActivity.this.finish();
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
                    Toast.makeText(CaseLoadingActivity.this, "图片数5张已满", Toast.LENGTH_SHORT).show();
                }
                else if(position == 0) { //点击图片位置为+ 0对应0张图片
                    final CharSequence[] items = { "手机相册", "相机拍摄" };
                    AlertDialog dlg = new AlertDialog.Builder(CaseLoadingActivity.this).setTitle("选择图片").setItems(items,
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
                    /*Toast.makeText(PostActivity.this, "添加图片", Toast.LENGTH_SHORT).show();
                    //选择图片
                    Intent intent = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, IMAGE_OPEN);*/
                    //通过onResume()刷新数据
                }
                else {
                    //  dialog(position); //增加点击放大效果
                    position1=position;
                    if(bl==false){
                        Animation testAnim = AnimationUtils.loadAnimation(CaseLoadingActivity.this, R.anim.anim);
                        gridView.getChildAt(position).startAnimation(testAnim);
                        bl=true;
                    }else{
                        bl=false;
                        Animation testAnim = AnimationUtils.loadAnimation(CaseLoadingActivity.this, R.anim.anim1);
                        gridView.getChildAt(position).startAnimation(testAnim);
                    }
                }
            }
        });
    }

    @Override
    public void configViews() {

    }

    /**
     *
     * @param menu
     * @return
     * 调用menu中的资源
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent1=new Intent(CaseLoadingActivity.this,MainActivity.class);//点击回主页
                startActivity(intent1);
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
                Intent intent0= new Intent(CaseLoadingActivity.this,RecordActivity.class);
                startActivity(intent0);
                CaseLoadingActivity.this.finish();
                return true;
            case R.id.action_qianjin:

                Intent intent= new Intent(CaseLoadingActivity.this,RecordcaseActivity.class);
                startActivity(intent);
                CaseLoadingActivity.this.finish();
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
    //获取图片路径 响应startActivityForResult
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
    //刷新图片
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
        AlertDialog.Builder builder = new AlertDialog.Builder(CaseLoadingActivity.this);
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
