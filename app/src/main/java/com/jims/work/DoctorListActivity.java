package com.jims.work;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jims.work.bean.GoodsInfo;
import com.jims.work.utils.Constants;
import com.jims.work.utils.MyListView;
import com.jims.work.utils.NumberUtils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by Just on 2016/12/29.
 */
public class DoctorListActivity extends Activity implements
        OnClickListener {

    private ArrayList<GoodsInfo> goodsList = new ArrayList<GoodsInfo>();
    private ArrayList<GoodsInfo> goodsListCopy = new ArrayList<GoodsInfo>();	//备份，用于排序后恢复

   /* private MenuDrawer mDrawer;*/
    private GoodsListAdapter mListAdapter;
    private boolean isGlobalMenuShow;
    private View mLayoutGlobalMenu;
    private ImageView mImgOverlay;
    private MyListView mListView;
    private View mOverlayHeader;
    private int mLastFirstPosition;
    private ImageView mImgGlobal;
    private ImageView mImgGlobalList;

    private int durationRotate = 700;// 旋转动画时间
    private int durationAlpha = 500;// 透明度动画时间
    // private int gridCode = -1;
    // private int listCode = -1;
    private GoodsGridAdapter mGridAdapter;
    private ImageView mImgMenuList;

    private boolean isGrid; // 是否为Grid列表
    private boolean isSortUp;	//是否为价格升序排列
    private ImageView mImgMenuGrid;
    private ImageView mImgGlobalGrid;
    private int menuSize;

    private TextView mTvSaleVolume;
    private TextView mTvSaleVolumeList;
    private TextView mTvSaleVolumeGrid;
    private TextView mTvPrice;
    private TextView mTvPriceList;
    private TextView mTvPriceGrid;
    private ImageView mImgPriceGrid;
    private ImageView mImgPriceList;
    private ImageView mImgPrice;
    private ProgressBar mProgressBar;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_list);
        context=DoctorListActivity.this;

//		initMenu();
        initView();
        initGoods();
        setOnListener();
        initListView();
        mProgressBar.setVisibility(View.GONE);
    }

    private void initGoods() {
        goodsList.add(new GoodsInfo("李云龙","承德附属医院","心血管内科","副主任医师","100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压",context.getResources().getDrawable(R.drawable.doctor1,null), "服饰鞋包", 153.00, "好评96%", 1224, 1, 0));
        goodsList.add(new GoodsInfo("李运昌","承德市中心医院","神经外科","副主任医师","100002", "脑肿瘤、脑外伤、呕吐、脑缺血、脑积水、动脉瘤", context.getResources().getDrawable(R.drawable.doctor2,null), "服饰鞋包", 479.00, "好评95%", 645, 0, 0));
        goodsList.add(new GoodsInfo("周慧敏","承德妇幼保健院","小儿科","副主任医师","100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎",context.getResources().getDrawable(R.drawable.doctor3,null), "服饰鞋包", 149.00, "暂无评价", 1856, 0, 0));
        goodsList.add(new GoodsInfo("李云龙","承德附属医院","心血管内科","副主任医师","100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor4,null), "服饰鞋包", 153.00, "好评96%", 1224, 1, 0));
        goodsList.add(new GoodsInfo("李运昌","承德市中心医院","神经外科","副主任医师","100002", "脑肿瘤、脑外伤、呕吐、脑缺血、脑积水、动脉瘤", context.getResources().getDrawable(R.drawable.doctor5,null), "服饰鞋包", 479.00, "好评95%", 645, 0, 0));
        goodsList.add(new GoodsInfo("周慧敏","承德妇幼保健院","小儿科","副主任医师","100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎", context.getResources().getDrawable(R.drawable.doctor1,null), "服饰鞋包", 149.00, "暂无评价", 1856, 0, 0));
        goodsList.add(new GoodsInfo("李云龙","承德附属医院","心血管内科","副主任医师","100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor2,null), "服饰鞋包", 479.00, "好评95%", 645, 0, 0));
        goodsList.add(new GoodsInfo("周慧敏","承德妇幼保健院","小儿科","副主任医师","100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎",context.getResources().getDrawable(R.drawable.doctor3,null), "服饰鞋包", 149.00, "暂无评价", 1856, 0, 0));
        goodsList.add(new GoodsInfo("李云龙","承德附属医院","心血管内科","副主任医师","100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor4,null), "服饰鞋包", 153.00, "好评96%", 1224, 1, 0));
        goodsList.add(new GoodsInfo("李运昌","承德市中心医院","神经外科","副主任医师","100002", "脑肿瘤、脑外伤、呕吐、脑缺血、脑积水、动脉瘤", context.getResources().getDrawable(R.drawable.doctor5,null), "服饰鞋包", 479.00, "好评95%", 645, 0, 0));
        goodsList.add(new GoodsInfo("周慧敏","承德妇幼保健院","小儿科","副主任医师","100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎", context.getResources().getDrawable(R.drawable.doctor1,null), "服饰鞋包", 149.00, "暂无评价", 1856, 0, 0));
        goodsListCopy.addAll(goodsList);
    }

//	private void initMenu() {
//		Intent intent = getIntent();
//		CategoryItem categoryItem = (CategoryItem) intent
//				.getSerializableExtra(Constants.INTENT_KEY.MENU_TO_GOODS_LIST);
//		// gridCode = getIntent().getIntExtra("gridCode", -1);
//		// listCode = getIntent().getIntExtra("listCode", -1);
//		mDrawer = MenuDrawer
//				.attach(this, MenuDrawer.Type.OVERLAY, Position.END);
//		mDrawer.setMenuView(R.layout.menudrawer);
//		mDrawer.setContentView(R.layout.activity_goods_list);
//		// 菜单无阴影
//		mDrawer.setDropShadowEnabled(false);
//		filterMenuFragment = new FilterMenuFragment();
//		// filterMenuFragment.setGoodsCode(listCode, gridCode);
//		filterMenuFragment.setCategoryItem(categoryItem);
//		getSupportFragmentManager().beginTransaction()
//				.add(R.id.menu_container, filterMenuFragment).commit();
//	}

    /**
     * 设置菜单宽度
     */
    @Override
    protected void onResume() {
        super.onResume();
        // 若不将menuSize设为成员变量，在从第二层菜单返回时，会造成菜单消失
//		if (menuSize == 0) {
//			int screenWidth = ScreenUtils.getScreenWidth(this);
//			menuSize = screenWidth / 7 * 6;
//			mDrawer.setMenuSize(menuSize);
//		}
    }



    private void setOnListener() {
        findViewById(R.id.img_back).setOnClickListener(this);
        findViewById(R.id.btn_global).setOnClickListener(this);
        findViewById(R.id.btn_filter).setOnClickListener(this);
        findViewById(R.id.btn_price).setOnClickListener(this);
        findViewById(R.id.btn_salse_volume).setOnClickListener(this);
        findViewById(R.id.layout_category_search_bar).setOnClickListener(this);
        mOverlayHeader.setOnClickListener(this);
        mLayoutGlobalMenu.setOnClickListener(this);
        mImgOverlay.setOnClickListener(this);


    }

    private void initView() {
        mImgPrice = (ImageView) findViewById(R.id.img_price);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvSaleVolume = (TextView) findViewById(R.id.tv_salse_volume);
        mLayoutGlobalMenu = findViewById(R.id.layout_global_menu);
        mOverlayHeader = findViewById(R.id.overlayHeader);
        mImgOverlay = (ImageView) findViewById(R.id.img_overlay);
        mImgGlobal = (ImageView) findViewById(R.id.img_global);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

    }

    private void initListView() {
        mListView = (MyListView) findViewById(R.id.listView1);
        View head = getLayoutInflater().inflate(R.layout.head_goods_list, null);
        mListView.addHeaderView(head, null, false);
        mListAdapter = new GoodsListAdapter();
        mListView.setAdapter(mListAdapter);
        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                GoodsInfo info = goodsList.get(position - 1);
                gotoDetail(info);
            }
        });
        // 滚动到最上方时隐藏mOverlayHeader
        mListView.setOnScroll2TopListener(new MyListView.OnScroll2TopListener() {

            @Override
            public void scroll2Top() {
                mOverlayHeader.setVisibility(View.VISIBLE);
            }
        });
        // 向上滚动后右下角出现回到顶部按钮
        mListView.setOnScrollListener(new OnScrollListener() {
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (firstVisibleItem < mLastFirstPosition) {
                    mOverlayHeader.setVisibility(View.VISIBLE);
                } else if (firstVisibleItem > mLastFirstPosition) {
                    mOverlayHeader.setVisibility(View.VISIBLE);
                }
                mLastFirstPosition = firstVisibleItem;

                if (firstVisibleItem > 0) {
                    mImgOverlay.setVisibility(View.VISIBLE);
                } else {
                    mImgOverlay.setVisibility(View.INVISIBLE);
                }
            }

            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

        });
        mImgPriceList = (ImageView) head.findViewById(R.id.img_price);
        mTvPriceList = (TextView) head.findViewById(R.id.tv_price);
        mTvSaleVolumeList = (TextView) head.findViewById(R.id.tv_salse_volume);
        mImgGlobalList = (ImageView) head.findViewById(R.id.img_global);

        head.findViewById(R.id.btn_global).setOnClickListener(this);
        head.findViewById(R.id.btn_filter).setOnClickListener(this);
        head.findViewById(R.id.btn_price).setOnClickListener(this);
        head.findViewById(R.id.btn_salse_volume).setOnClickListener(this);
        head.findViewById(R.id.layout_category_search_bar).setOnClickListener(
                this);
        head.findViewById(R.id.img_back).setOnClickListener(this);

    }

    /**
     * 商品详情
     * @param info
     */
    private void gotoDetail(GoodsInfo info) {
        Intent intent = new Intent(this, DoctorListActivity.class);
        //intent.putExtra(Constants.INTENT_KEY.INFO_TO_DETAIL, info);
        startActivity(intent);
    }

    /**
     * 将二级菜单的选择结果设置给一级菜单
     *
     *
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
                inflate = getLayoutInflater().inflate(
                        R.layout.item_goods_list_list, null);
                holder = new ViewHolder();
                holder.imgIcon = (ImageView) inflate.findViewById(R.id.img_icon);
                holder.imgVip = (ImageView) inflate.findViewById(R.id.img_icon_vip);
                holder.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
                holder.tvPrice = (TextView) inflate.findViewById(R.id.tv_price);
                holder.tvPercent = (TextView) inflate.findViewById(R.id.tv_percent);
                holder.tvNum = (TextView) inflate.findViewById(R.id.tv_num);
                holder.tvname = (TextView) inflate.findViewById(R.id.tv_name);
                holder.tvclasses = (TextView) inflate.findViewById(R.id.tv_classes);
                holder.tvhospital = (TextView) inflate.findViewById(R.id.tv_hospital);
                holder.tvposition = (TextView) inflate.findViewById(R.id.tv_position);
                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            GoodsInfo goodsInfo = goodsList.get(position);
            holder.tvTitle.setText(goodsInfo.getGoodsName());
            holder.tvPrice.setText(NumberUtils.formatPrice(goodsInfo.getGoodsPrice()));
            holder.tvPercent.setText(goodsInfo.getGoodsPercent());
            holder.tvNum.setText(goodsInfo.getGoodsComment() + "人");
            holder.tvname.setText(goodsInfo.getGoodsname());
            holder.tvclasses.setText(goodsInfo.getGoodsclasses());
            holder.tvhospital.setText(goodsInfo.getGoodshospital());
            holder.tvposition.setText(goodsInfo.getGoodsposition());
           // UILUtils.displayImage(DoctorListActivity.this, goodsInfo.getGoodsIcon(), holder.imgIcon);
            if (goodsInfo.getIsPhone() == 1) {
                holder.imgVip.setVisibility(View.VISIBLE);
            } else {
                holder.imgVip.setVisibility(View.INVISIBLE);
            }
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

    class GoodsGridAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            ViewHolder holder = null;
            if (convertView == null) {
                inflate = getLayoutInflater().inflate(
                        R.layout.item_goods_list_grid, null);
                holder = new ViewHolder();
                holder.imgIcon = (ImageView) inflate.findViewById(R.id.img_icon);
                holder.tvTitle = (TextView) inflate.findViewById(R.id.tv_title);
                holder.tvPrice = (TextView) inflate.findViewById(R.id.tv_price);
                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            GoodsInfo goodsInfo = goodsList.get(position);
            holder.tvTitle.setText(goodsInfo.getGoodsName());
            holder.tvPrice.setText(NumberUtils.formatPrice(goodsInfo.getGoodsPrice()));
           // UILUtils.displayImage(DoctorListActivity.this, goodsInfo.getGoodsIcon(), holder.imgIcon);
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

            case R.id.btn_global: // 综合
                showGlobalMenu();
                break;
            case R.id.layout_global_menu: // 综合下拉菜单
                showGlobalMenu();
                break;
            case R.id.img_overlay:
                mListView.setSelection(0);
                break;
            case R.id.btn_filter: // 筛选
                toggleFilterMenu();
                break;
            case R.id.btn_price: // 价格排序
                sortByPrice();
                break;
            case R.id.btn_salse_volume: // 销量排序
                sortByVolume();
                break;
            case R.id.layout_category_search_bar: // 搜索
                gotoSearch();
                break;
            case R.id.img_back: // 返回
                Intent intent=new Intent(DoctorListActivity.this,DoctorClassActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.overlayHeader:
                break;

            default:
                break;
        }
    }

    /**
     * 排序
     */
    private void sortByPrice() {
        mProgressBar.setVisibility(View.VISIBLE);
        isSortUp = !isSortUp;
        if (isSortUp) {
            sortUp();
        } else {
            sortDown();
        }
    }

    /**
     * 按价格升序
     */
    private void sortUp() {
        int darkgray = getResources().getColor(R.color.darkgray);
        mTvSaleVolume.setTextColor(darkgray);
        mTvSaleVolumeList.setTextColor(darkgray);
        mTvSaleVolumeGrid.setTextColor(darkgray);
        mTvPrice.setTextColor(Color.RED);
        mTvPriceList.setTextColor(Color.RED);
        mTvPriceGrid.setTextColor(Color.RED);
        mImgPrice.setImageResource(R.mipmap.sort_button_price_up);
        mImgPriceList.setImageResource(R.mipmap.sort_button_price_up);
        mImgPriceGrid.setImageResource(R.mipmap.sort_button_price_up);
        Collections.sort(goodsList, new Comparator<GoodsInfo>() {

            @Override
            public int compare(GoodsInfo lhs, GoodsInfo rhs) {
                return Double.compare(lhs.getGoodsPrice(), rhs.getGoodsPrice());
            }
        });
        mListAdapter.notifyDataSetChanged();
        mGridAdapter.notifyDataSetChanged();
        mProgressBar.setVisibility(View.GONE);
    }

    /**
     * 按价格降序
     */
    private void sortDown() {
        mImgPrice.setImageResource(R.mipmap.sort_button_price_down);
        mImgPriceList.setImageResource(R.mipmap.sort_button_price_down);
        mImgPriceGrid.setImageResource(R.mipmap.sort_button_price_down);
        Collections.sort(goodsList, new Comparator<GoodsInfo>() {

            @Override
            public int compare(GoodsInfo lhs, GoodsInfo rhs) {
                return Double.compare(rhs.getGoodsPrice(), lhs.getGoodsPrice());
            }
        });
        mListAdapter.notifyDataSetChanged();
        mGridAdapter.notifyDataSetChanged();
        mProgressBar.setVisibility(View.GONE);
    }

    /**
     * 销量排序：还原排序
     */
    private void sortByVolume() {
        mProgressBar.setVisibility(View.VISIBLE);
        isSortUp = false;
        int darkgray = getResources().getColor(R.color.darkgray);
        mTvSaleVolume.setTextColor(Color.RED);
        mTvSaleVolumeList.setTextColor(Color.RED);
        mTvSaleVolumeGrid.setTextColor(Color.RED);
        mTvPrice.setTextColor(darkgray);
        mTvPriceList.setTextColor(darkgray);
        mTvPriceGrid.setTextColor(darkgray);
        mImgPrice.setImageResource(R.mipmap.sort_button_price);
        mImgPriceList.setImageResource(R.mipmap.sort_button_price);
        mImgPriceGrid.setImageResource(R.mipmap.sort_button_price);
        goodsList.clear();
        goodsList.addAll(goodsListCopy);
        mListAdapter.notifyDataSetChanged();
        mGridAdapter.notifyDataSetChanged();
        mProgressBar.setVisibility(View.GONE);
    }



    public void toggleFilterMenu() {
//		mDrawer.toggleMenu();
    }

    private void gotoSearch() {
//		Intent intent = new Intent(this, SearchActivity.class);
//		startActivity(intent);
//		// activity开启无动画
//		overridePendingTransition(0, 0);
    }

    /**
     * 显示综合菜单；图标动画
     */
    private void showGlobalMenu() {
        isGlobalMenuShow = !isGlobalMenuShow;
        if (isGlobalMenuShow) {
            ObjectAnimator.ofFloat(mImgGlobal, "rotation", 0, 180)
                    .setDuration(durationRotate).start();
            ObjectAnimator.ofFloat(mImgGlobalList, "rotation", 0, 180)
                    .setDuration(durationRotate).start();
            ObjectAnimator.ofFloat(mImgGlobalGrid, "rotation", 0, 180)
                    .setDuration(durationRotate).start();
            mLayoutGlobalMenu.setVisibility(View.VISIBLE);
            ObjectAnimator.ofFloat(mLayoutGlobalMenu, "alpha", 0, 1)
                    .setDuration(durationAlpha).start();
        } else {
            ObjectAnimator.ofFloat(mImgGlobal, "rotation", 180, 360)
                    .setDuration(durationRotate).start();
            ObjectAnimator.ofFloat(mImgGlobalList, "rotation", 180, 360)
                    .setDuration(durationRotate).start();
            ObjectAnimator.ofFloat(mImgGlobalGrid, "rotation", 180, 360)
                    .setDuration(durationRotate).start();
            ObjectAnimator.ofFloat(mLayoutGlobalMenu, "alpha", 1, 0)
                    .setDuration(durationAlpha).start();
            mLayoutGlobalMenu.postDelayed(new Runnable() {

                @Override
                public void run() {
                    mLayoutGlobalMenu.setVisibility(View.INVISIBLE);
                }
            }, durationAlpha);
        }

    }

//	/**
//	 * 点击返回时，先关闭菜单
//	 */
//	@Override
//	public void onBackPressed() {
//		// TODO
//		// 获取当前栈中的片段数
//		FragmentManager fm = getSupportFragmentManager();
//		int count = fm.getBackStackEntryCount();
//		if (count == 0) {
////			final int drawerState = mDrawer.getDrawerState();
////			if (drawerState == MenuDrawer.STATE_OPEN
////					|| drawerState == MenuDrawer.STATE_OPENING) {
////				mDrawer.closeMenu();
////				return;
////			}
//		}
//		super.onBackPressed();
//	}

    class ViewHolder {
        ImageView imgIcon;
        ImageView imgVip;
        TextView tvTitle;
        TextView tvPrice;
        TextView tvPercent;
        TextView tvNum;
        TextView tvname;
        TextView tvhospital;
        TextView tvclasses;
        TextView tvposition;
    }
}
