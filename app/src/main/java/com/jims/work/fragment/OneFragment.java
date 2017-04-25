package com.jims.work.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.ReplyActivity;
import com.jims.work.bean.MyAsklistInfor;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

/**
 * 我的问诊
 */
public class OneFragment extends Fragment implements View.OnClickListener {

	private View view;// ��ǰfragment

	private ArrayList<MyAsklistInfor> goodsList = new ArrayList<MyAsklistInfor>();
	private ArrayList<MyAsklistInfor> goodsListCopy = new ArrayList<MyAsklistInfor>();	//备份，用于排序后恢复

	private GoodsListAdapter mListAdapter;
	private ImageView mImgOverlay;
	private MyListView mListView;
	private ProgressBar mProgressBar;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_one, null);
		initGoods();
		initView();
		setOnListener();
		initListView();
		mProgressBar.setVisibility(View.GONE);
		return view;
	}

	private void initGoods() {
		goodsList.add(new MyAsklistInfor("2017/3/12 9：56","待评价","2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合","","李云龙","心血管内科","免费咨询"));
		goodsList.add(new MyAsklistInfor("2017/3/15 11：15","已评价","神经内科","","李运昌",  "神经内科", "免费咨询"));
		goodsList.add(new MyAsklistInfor("2017/3/22 18：45","待评价","最近睡眠质量差，是什么原因？","","周慧敏",  "神经外科", "免费咨询"));
		goodsList.add(new MyAsklistInfor("2017/3/15 11：15","已评价","神经内科","","李运昌",  "神经内科", "免费咨询"));
		goodsList.add(new MyAsklistInfor("2017/3/22 18：45","待评价","最近食欲差，精神状态不好？","","周慧敏",  "神经外科", "免费咨询"));
		goodsListCopy.addAll(goodsList);
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
		mListView = (MyListView) view.findViewById(R.id.listView);

		mListAdapter = new GoodsListAdapter();
		mListView.setAdapter(mListAdapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				MyAsklistInfor Infor = goodsList.get(position);
				gotoDetail(Infor);
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

	/**
	 * 商品详情
	 * @param info
	 */
	private void gotoDetail(MyAsklistInfor info) {
		Intent intent = new Intent(getActivity(), ReplyActivity.class);

		startActivity(intent);
	}

	/**
	 * 将二级菜单的选择结果设置给一级菜单
	 * @param
	 * @param
	 */
//	public void setSelectedResult(String result) {
//		filterMenuFragment.setSelectedResult(result);
//	}

	class GoodsListAdapter extends BaseAdapter {

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View inflate = null;
			ViewHolder holder = null;
			if (convertView == null) {
				inflate = getActivity().getLayoutInflater().inflate(R.layout.simple1_item, null);
				holder = new ViewHolder();
				holder.begin_time = (TextView) inflate.findViewById(R.id.begin_time);
				holder.myask_evaluate = (TextView) inflate.findViewById(R.id.myask_evaluate);
				holder.myask_content = (TextView) inflate.findViewById(R.id.myask_content);

				holder.myask_doctorimg = (ImageView) inflate.findViewById(R.id.myask_doctorimg);
				holder.myask_doctorname = (TextView) inflate.findViewById(R.id.myask_doctorname);
				holder.myask_doctorclass = (TextView) inflate.findViewById(R.id.myask_doctorclass);
				holder.myask_kind = (TextView) inflate.findViewById(R.id.myask_kind);
				inflate.setTag(holder);
			} else {
				inflate = convertView;
				holder = (ViewHolder) inflate.getTag();
			}
			MyAsklistInfor Info = goodsList.get(position);
			if (Info.getBegin_time().equals("")) {
				holder.begin_time.setVisibility(View.GONE);
			}
			else{holder.begin_time.setText(Info.getBegin_time());}

			if (Info.getMyask_content().equals("")) {
				holder.myask_content.setVisibility(View.GONE);
			}
			else{holder.myask_content.setText(Info.getMyask_content());}


			holder.myask_evaluate.setText(Info.getMyask_evaluate());
			holder.myask_doctorname.setText(Info.getMyask_doctorname());
			//holder.myservice_doctorimg.set(Info.getMyservice_doctorimg());
			holder.myask_doctorclass.setText(Info.getMyask_doctorclass());
			holder.myask_kind.setText(Info.getMyask_kind());
			//  UILUtils.displayImage(MyDoctorssListActivity.this, DoctorsInfo.getGoodsIcon(), holder.imgIcon);

			return inflate;
		}

		@Override
		public int getCount() {
			return goodsList.size();
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


	public class ViewHolder {
		TextView begin_time;
		TextView myask_evaluate;
		TextView myask_content;
		ImageView myask_doctorimg;
		TextView myask_doctorname;
		TextView myask_doctorclass;
		TextView myask_kind;
	}
}
