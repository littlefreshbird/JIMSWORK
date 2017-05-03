package com.jims.work.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jims.work.R;
import com.jims.work.ReplyActivity;
import com.jims.work.adapter.InquiryaskAdapter;
import com.jims.work.bean.BaseAskBean;
import com.jims.work.bean.BaseBean;
import com.jims.work.bean.MyAsklistInfor;
import com.jims.work.service.InquiryAskService;
import com.jims.work.utils.MyListView;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.jims.work.R.id.listView;


/**
 * 我的问诊
 */
public class OneFragment extends Fragment  {



    private View view;// ��ǰfragment

    //private ArrayList<MyAsklistInfor> asksList = new ArrayList<MyAsklistInfor>();
    private InquiryaskAdapter mListAdapter;
    private MyListView mListView;
    private List<MyAsklistInfor> asksList;
    InquiryAskService inquiryAskService;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, null);

        /**
         * 实例化Retrofit
         * Converter 转换器 可以转换任意数据类型
         */

        Retrofit retrofit =
                new Retrofit.Builder(). baseUrl("http://192.168.2.212:8080/")
						.addConverterFactory(GsonConverterFactory.create())
						.build();
		inquiryAskService = retrofit.create(InquiryAskService.class);

        int id=1;
        Call<ResponseBody> call = inquiryAskService.getList(id);
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
                            Type type = new TypeToken<BaseAskBean>() {}.getType();
                            BaseAskBean baseAskBean = gson.fromJson(result, type);
                            if (baseAskBean != null) {
                                asksList = baseAskBean.getData();
                                if (asksList != null) {
                                    //初始化适配器，并且绑定数据
                                    mListAdapter = new InquiryaskAdapter(getActivity(),asksList);
                                    mListView.setAdapter(mListAdapter);
                                }
                            }else{
                                Toast.makeText(getActivity(),"暂无数据",Toast.LENGTH_SHORT);
                            }
                        }else{
                            Toast.makeText(getActivity(),"查询失败",Toast.LENGTH_SHORT);
                        }
                        } catch (IOException e) {
                        e.printStackTrace();
                    }

                    }
                }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getActivity(), "请求失败"+call.request().url(), Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });

       // initGoods();
        initview();
        return view;
    }

/*
    private void initGoods() {
        asksList.add(new MyAsklistInfor("2017/3/12 9：56", "待评价", "2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合", "", "李云龙", "心血管内科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/15 11：15", "已评价", "神经内科", "", "李运昌", "神经内科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/22 18：45", "待评价", "最近睡眠质量差，是什么原因？", "", "周慧敏", "神经外科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/15 11：15", "已评价", "神经内科", "", "李运昌", "神经内科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/22 18：45", "待评价", "最近食欲差，精神状态不好？", "", "周慧敏", "神经外科", "免费咨询"));

    }*/

    // 初始化
    private void initview() {
        mListView = (MyListView) view.findViewById(listView);
        //mListAdapter = new InquiryaskAdapter(getActivity(), asksList);
        //mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                MyAsklistInfor info = asksList.get(position);
                Intent intent=new Intent(getActivity(), ReplyActivity.class);
                startActivity(intent);
            }
        });
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
//				mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });

    }





}
