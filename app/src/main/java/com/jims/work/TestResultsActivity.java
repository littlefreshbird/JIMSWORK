package com.jims.work;


import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jims.work.adapter.CheckAdapter;
import com.jims.work.bean.BaseBean;
import com.jims.work.bean.BaseCheckBean;
import com.jims.work.bean.CheckResult;
import com.jims.work.bean.TestResult;
import com.jims.work.service.CheckTestService;
import com.jims.work.utils.MyListView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TestResultsActivity extends BaseActivity1  {
    /*private java.util.List<CheckResult> List = new ArrayList<CheckResult>();
    private ArrayList<CheckResult> ListCopy = new ArrayList<CheckResult>();	//备份，用于排序后恢复*/
    private ArrayList<TestResult> testList = new ArrayList<TestResult>();
    private ArrayList<TestResult> testListCopy = new ArrayList<TestResult>();	//备份，用于排序后恢复
    private TestListAdapter mListAdapter;
    private CheckAdapter checkAdapter;
    private MyListView mListView,mListView1;
    private List<CheckResult> checkList;
    CheckTestService checkTestService;
    @Override
    public int getLayoutId() {
        return R.layout.activity_test_results;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("检查检验");
    }

    @Override
    public void initDatas() {
        TabHost m = (TabHost) findViewById(R.id.tabhost);
        m.setup();

        LayoutInflater i = LayoutInflater.from(this);
        i.inflate(R.layout.result_layout1, m.getTabContentView());
        i.inflate(R.layout.result_layout2, m.getTabContentView());

        m.addTab(m.newTabSpec("tab1").setIndicator("检查结果").setContent(R.id.LinearLayout01));
        m.addTab(m.newTabSpec("tab2").setIndicator("检验结果").setContent(R.id.LinearLayout02));

//查询检查结果
        Retrofit retrofit =
                new Retrofit.Builder(). baseUrl("http://192.168.2.212:8080/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        checkTestService = retrofit.create(CheckTestService.class);
        int id=1;
        Call<ResponseBody> call = checkTestService.checkList(id);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    try {
                        String result = response.body().string();
                        Log.e("result", result);
                        BaseBean b = JSON.parseObject(result, BaseBean.class);
                        if (b.getRespcode().equals("0")) {
                            Gson gson = new Gson();
                            Type type = new TypeToken<BaseCheckBean>() {}.getType();
                            BaseCheckBean baseCheckBean = gson.fromJson(result, type);
                            if (baseCheckBean != null) {
                                checkList = baseCheckBean.getData();
                                if (checkList.size() != 0) {
                                    //初始化适配器，并且绑定数据
                                    checkAdapter = new CheckAdapter(TestResultsActivity.this,checkList);
                                    mListView1.setAdapter(checkAdapter);
                                }else{
                                    Toast.makeText(TestResultsActivity.this,"暂无数据",Toast.LENGTH_SHORT);
                            }
                            }
                        }else{
                            Toast.makeText(TestResultsActivity.this,"查询失败",Toast.LENGTH_SHORT);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(TestResultsActivity.this, "请求失败"+call.request().url(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

        initGoods();
        initListView();
    }

    @Override
    public void configViews() {

    }
    private void initGoods() {
     /*   List.add(new CheckResult("CT检查","2017-03-17 09:50:42"));
        List.add(new CheckResult("X光检查","2017-03-28 15:50:42"));
        List.add(new CheckResult("B超","2017-03-29 17:50:42"));
        ListCopy.addAll(List);*/
        testList.add(new TestResult("全血","2017-03-17 09:50:42"));
        testList.add(new TestResult("全血","2017-03-28 15:50:42"));
        testList.add(new TestResult("全血","2017-03-29 17:50:42"));
        testListCopy.addAll(testList);
    }
    /**
     * 设置菜单宽度
     */
    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initListView() {
        mListView1 = (MyListView) findViewById(R.id.listView1);
        mListView = (MyListView) findViewById(R.id.listView2);
        //mListAdapter1=new CheckListAdapter();
        mListAdapter = new TestListAdapter();
        //mListView1.setAdapter(mListAdapter1);
        mListView.setAdapter(mListAdapter);
        //检查结果
        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                CheckResult info1 = checkList.get(position);
                gotoDetail1(info1);
            }
        });
        mListView1.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });
        //检验结果
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TestResult info = testList.get(position);
                gotoDetail(info);
            }
        });
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });


    }

    /**
     * 检查结果详情
     * @param info1
     */
    private void gotoDetail1(CheckResult info1) {
        Intent intent = new Intent(this, CheckResultActivity.class);

        startActivity(intent);
    }

    /**
     * 检验结果详情
     * @param info
     */
    private void gotoDetail(TestResult info) {
        Intent intent = new Intent(this, CheckResultActivity.class);

        startActivity(intent);
    }


    /**
     * 检验结果
     * @param
     * @param
     */
    class TestListAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            ViewHolder holder = null;
            if (convertView == null) {
                inflate = getLayoutInflater().inflate(
                        R.layout.item_test_result, null);
                holder = new ViewHolder();
                holder.test_name = (TextView) inflate.findViewById(R.id.test_name);
                holder.test_time = (TextView) inflate.findViewById(R.id.test_time);
                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            TestResult testResult2 = testList.get(position);
            holder.test_name.setText(testResult2.getTest_name());
            holder.test_time.setText(testResult2.getTest_time());
            return inflate;
        }

        @Override
        public int getCount() {
            return testList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

    }
    public class ViewHolder {

        TextView test_name;
        TextView test_time;


    }

}