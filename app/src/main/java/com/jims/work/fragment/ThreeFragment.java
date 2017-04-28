package com.jims.work.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.jims.work.R;
import com.jims.work.ReplyActivity;
import com.jims.work.adapter.CurrentserviceAdapter;
import com.jims.work.bean.MyServicelistInfor;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

import static com.jims.work.R.id.listView1;

public class ThreeFragment extends Fragment implements View.OnClickListener {
	private ArrayList<MyServicelistInfor> ListCopy = new ArrayList<MyServicelistInfor>();
	private ArrayList<MyServicelistInfor> serviceList = new ArrayList<MyServicelistInfor>();

	private View view;// ��ǰfragment
	private CurrentserviceAdapter mListAdapter;
	private ImageView mImgOverlay;
	private MyListView mListView;
	private ProgressBar mProgressBar;
	//private List<MyServicelistInfor> serviceList;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_three, null);
		initGoods();
		initView();
		setOnListener();
		initListView();
		mProgressBar.setVisibility(View.GONE);
		return view;
	}


	private void initGoods() {
		serviceList.add(new MyServicelistInfor("2017/3/12 9:56","待评价","2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合","","李云龙","心血管内科","图文咨询"));
		serviceList.add(new MyServicelistInfor("2017/3/15 11:15","已评价","神经内科","","李运昌",  "神经内科", "电话咨询"));
		serviceList.add(new MyServicelistInfor("2017/3/22 18:45","待评价","最近睡眠质量差，是什么原因？","","周慧敏",  "神经外科", "图文咨询"));
		ListCopy.addAll(serviceList);
	}
	/**
	 * 设置菜单宽度
	 */
	@Override
	public void onResume() {
		super.onResume();

	}


	private void setOnListener() {
		mImgOverlay.setOnClickListener(this);

	}

	private void initView() {
		mImgOverlay = (ImageView) view.findViewById(R.id.img_overlay);
		mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar1);

	}

	private void initListView() {
		mListView = (MyListView) view.findViewById(listView1);
		mListAdapter = new CurrentserviceAdapter(getActivity(), serviceList);
		mListView.setAdapter(mListAdapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				MyServicelistInfor info = serviceList.get(position);
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
		mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
			public void onScroll(AbsListView view, int firstVisibleItem,
								 int visibleItemCount, int totalItemCount) {

				if (firstVisibleItem > 0) {
					mImgOverlay.setVisibility(View.VISIBLE);
				} else {
					mImgOverlay.setVisibility(View.INVISIBLE);
				}
			}

			public void onScrollStateChanged(AbsListView view, int scrollState) {
			}

		});


	}



	@Override
	public void onClick(View v) {
		switch (v.getId()) {

			case R.id.img_overlay:
				mListView.setSelection(0);

				break;

			default:
				break;
		}
	}



}
