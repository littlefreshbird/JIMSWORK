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

import com.jims.work.BooksureActivity;
import com.jims.work.R;
import com.jims.work.bean.MyServicelistInfor;
import com.jims.work.utils.MyListView;

import java.util.ArrayList;

public class ThreeFragment extends Fragment implements View.OnClickListener {

	private View view;// ��ǰfragment

	private ArrayList<MyServicelistInfor> goodsList = new ArrayList<MyServicelistInfor>();
	private ArrayList<MyServicelistInfor> goodsListCopy = new ArrayList<MyServicelistInfor>();	//备份，用于排序后恢复

	private GoodsListAdapter mListAdapter;
	private ImageView mImgOverlay;
	private MyListView mListView;
	private ProgressBar mProgressBar;

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
		goodsList.add(new MyServicelistInfor("2017/3/12 9：56","待评价","2010年4月做的阑尾手术，术后伤口一直不愈合，2010年11月再次做了窦道切除手术，至今伤口任然不愈合","","李云龙","心血管内科","图文咨询"));
		goodsList.add(new MyServicelistInfor("2017/3/15 11：15","已评价","神经内科","","李运昌",  "神经内科", "电话咨询"));
		goodsList.add(new MyServicelistInfor("2017/3/22 18：45","待评价","最近睡眠质量差，是什么原因？","","周慧敏",  "神经外科", "图文咨询"));

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
		mListView = (MyListView) view.findViewById(R.id.listView1);

		mListAdapter = new GoodsListAdapter();
		mListView.setAdapter(mListAdapter);
		mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
									int position, long id) {
				MyServicelistInfor Infor = goodsList.get(position);
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
	private void gotoDetail(MyServicelistInfor info) {
		Intent intent = new Intent(getActivity(), BooksureActivity.class);

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
				inflate = getActivity().getLayoutInflater().inflate(R.layout.item_myservice_list, null);
				holder = new ViewHolder();
				holder.myservice_time = (TextView) inflate.findViewById(R.id.myservice_time);
				holder.myservice_evaluate = (TextView) inflate.findViewById(R.id.myservice_evaluate);
				holder.myservice_content = (TextView) inflate.findViewById(R.id.myservice_content);

				holder.myservice_doctorimg = (ImageView) inflate.findViewById(R.id.myservice_doctorimg);
				holder.myservice_doctorname = (TextView) inflate.findViewById(R.id.myservice_doctorname);
				holder.myservice_doctorclass = (TextView) inflate.findViewById(R.id.myservice_doctorclass);
				holder.myservice_kind = (TextView) inflate.findViewById(R.id.myservice_kind);
				inflate.setTag(holder);
			} else {
				inflate = convertView;
				holder = (ViewHolder) inflate.getTag();
			}
			MyServicelistInfor Info = goodsList.get(position);
			if (Info.getMyservice_time().equals("")) {
				holder.myservice_time.setVisibility(View.GONE);
			}
			else{holder.myservice_time.setText(Info.getMyservice_time());}

			if (Info.getMyservice_content().equals("")) {
				holder.myservice_content.setVisibility(View.GONE);
			}
			else{holder.myservice_content.setText(Info.getMyservice_content());}


			holder.myservice_evaluate.setText(Info.getMyservice_evaluate());
			holder.myservice_doctorname.setText(Info.getMyservice_doctorname());
			//holder.myservice_doctorimg.set(Info.getMyservice_doctorimg());
			holder.myservice_doctorclass.setText(Info.getMyservice_doctorclass());
			holder.myservice_kind.setText(Info.getMyservice_kind());
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
		TextView myservice_time;
		TextView myservice_evaluate;
		TextView myservice_content;
		ImageView myservice_doctorimg;
		TextView myservice_doctorname;
		TextView myservice_doctorclass;
		TextView myservice_kind;
	}
}
