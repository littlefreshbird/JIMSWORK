package com.jims.work.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.jims.work.R;
import com.jims.work.ReplyActivity;
import com.jims.work.adapter.InquiryaskAdapter;
import com.jims.work.bean.MyAsklistInfor;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 我的问诊
 */
public class OneFragment extends Fragment implements Callback<MyAsklistInfor> {



    private View view;// ��ǰfragment

    private ArrayList<MyAsklistInfor> asksList = new ArrayList<MyAsklistInfor>();
    private InquiryaskAdapter mListAdapter;
    private MyListView mListView;

    //InquiryAskService inquiryAskService;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, null);

        /**
         * 实例化Retrofit
         * Converter 转换器 可以转换任意数据类型
         */
        /*Retrofit retrofit =
                new Retrofit.Builder().baseUrl("http://www.tngou.net")
						.addConverterFactory(GsonConverterFactory.create())
						.build();
		inquiryAskService = retrofit.create(InquiryAskService.class);
		Call<MyAsklistInfor> call = inquiryAskService.getList("cook",0, 1, 20);
		call.enqueue((Callback<MyAsklistInfor>) this);*/

        initGoods();
        initview();
        return view;
    }


    private void initGoods() {
        asksList.add(new MyAsklistInfor("2017/3/12 9：56", "待评价", "2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合", "", "李云龙", "心血管内科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/15 11：15", "已评价", "神经内科", "", "李运昌", "神经内科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/22 18：45", "待评价", "最近睡眠质量差，是什么原因？", "", "周慧敏", "神经外科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/15 11：15", "已评价", "神经内科", "", "李运昌", "神经内科", "免费咨询"));
        asksList.add(new MyAsklistInfor("2017/3/22 18：45", "待评价", "最近食欲差，精神状态不好？", "", "周慧敏", "神经外科", "免费咨询"));

    }

    // 初始化
    private void initview() {
        mListView = (MyListView) view.findViewById(R.id.listView);
        mListAdapter = new InquiryaskAdapter(getActivity(), asksList);
        mListView.setAdapter(mListAdapter);
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
        // 向上滚动后右下角出现回到顶部按钮
  /*      mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

                if (firstVisibleItem > 0) {
                    imgOverlay.setVisibility(View.VISIBLE);
                } else {
                    imgOverlay.setVisibility(View.INVISIBLE);
                }
            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

        });*/

    }

    @Override
    public void onResponse(Call<MyAsklistInfor> call, Response<MyAsklistInfor> response) {

    }

    @Override
    public void onFailure(Call<MyAsklistInfor> call, Throwable t) {

    }






	/*// 异步请求 成功
    @Override
	public void onResponse(Call<MyAsklistInfor> call, Response<MyAsklistInfor> response) {
		Toast.makeText(getActivity(), "请求成功", Toast.LENGTH_SHORT).show();
		List<MyAsklistInfor> list = response.body().getList();
		adapter.addAll(list);
	}

	// 异步请求 失败
	@Override
	public void onFailure(Call<MyAsklistInfor> call, Throwable t) {
		Toast.makeText(getActivity(), "请求失败"+call.request().url(), Toast.LENGTH_SHORT).show();
		t.printStackTrace();
	}*/
}
