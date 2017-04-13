package com.jims.work;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jims.work.bean.InCart;
import com.jims.work.utils.NumberUtils;
import com.jims.work.utils.ScreenUtils;
import com.jims.work.view.SwipeMenu;
import com.jims.work.view.SwipeMenuCreator;
import com.jims.work.view.SwipeMenuItem;
import com.jims.work.view.SwipeMenuListView;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SubscibeActivity extends BaseActivity1 {
    @BindView(R.id.listView_cart)
    SwipeMenuListView listViewCart;

    @BindView(R.id.btn_check_all)
    CheckBox btnCheckAll;
    @BindView(R.id.tv_add_all)
    TextView tvAddAll;
    @BindView(R.id.tv_total)
    TextView tvTotal;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.btn_pay)
    RelativeLayout btnPay;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.layout_pay_bar)
    RelativeLayout layoutPayBar;
    @BindView(R.id.activity_subscibe)
    RelativeLayout activitySubscibe;
    private CartAdapter mAdapter;
    private ArrayList<InCart> mData = new ArrayList<InCart>();
    private HashMap<String, Boolean> inCartMap = new HashMap<String, Boolean>();// 用于存放选中的项

    private double price; // 总价
    private int num; // 选中的商品数


    private CompoundButton.OnCheckedChangeListener checkAllListener = new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            btnCheckAll.setChecked(isChecked);

            if (isChecked) {
                checkAll();
            } else {
                inCartMap.clear();
            }
            notifyCheckedChanged();
            mAdapter.notifyDataSetChanged();
        }

    };
    /**
     * 全选，将数据加入inCartMap
     */
    private void checkAll() {
        for (int i = 0; i < mData.size(); i++) {
            inCartMap.put(mData.get(i).getListId(), true);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_subscibe;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("订阅服务");
    }

    @Override
    public void initDatas() {
        initView();
        initListView();
    }

    @Override
    public void configViews() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                finish();
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {

        mData.add(new InCart("10001", "高血压随诊服务（三个月）",R.drawable.doc_service_phone_big_on, "300元/年，定期关注患者健康状况，不同阶段进行随诊服务", 300));
        mData.add(new InCart("10002", "糖尿病随诊服务（三个月）",R.drawable.doc_service_problem_big_on,  "300元/年，定期关注患者健康状况，不同阶段进行随诊服务", 300));
        mData.add(new InCart("10003", "契约式家庭医生服务（十二个月）",R.drawable.doc_service_hospital_guide_big_on, "把家庭医生签回家，随时享受六大免费服务", 50));


        btnCheckAll.setOnCheckedChangeListener(checkAllListener);
    }
    private void initListView() {

        mAdapter = new CartAdapter();
        listViewCart.setAdapter(mAdapter);
        // step 1. create a MenuCreator
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(SubscibeActivity.this);
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem
                        .setWidth(ScreenUtils.getScreenWidth(SubscibeActivity.this) / 3);
                // set item title
                deleteItem.setTitle("删除");
                // set item title fontsize
                deleteItem.setTitleSize(18);
                // set item title font color
                deleteItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(deleteItem);

            }
        };
        // set creator
        listViewCart.setMenuCreator(creator);

        // step 2. listener item click event
        listViewCart.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                // index是menu的菜单序号

            }
        });
        listViewCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                SubscibeDetailActivity.startActivity(SubscibeActivity.this,"11");
            }
        });
    }

    class CartAdapter extends BaseAdapter {

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = null;
            ViewHolder holder = null;
            if (convertView == null) {
                // 复用乱序问题
                inflate = getLayoutInflater().inflate(
                        R.layout.item_fragment_cart_list, null);
                holder = new ViewHolder(inflate);

                inflate.setTag(holder);
            } else {
                inflate = convertView;
                holder = (ViewHolder) inflate.getTag();
            }
            final InCart inCart = mData.get(position);
            holder.tvGoodsName.setText(inCart.getName());
            holder.tvGoodsPrice.setText(NumberUtils.formatPrice(inCart
                    .getPrice()));
            holder.tvGoodsDetail.setText(inCart.getDetail());
            holder.imgGoods.setImageResource(inCart.getIcon());


            // 避免由于复用触发onChecked()事件
            holder.btnCheck.setOnCheckedChangeListener(null);
            Boolean isChecked = inCartMap.get(inCart.getListId());
            if (isChecked != null && isChecked) {
                holder.btnCheck.setChecked(true);
            } else {
                holder.btnCheck.setChecked(false);
            }
            final ViewHolder holder2 = holder;

            holder.btnCheck
                    .setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                        @Override
                        public void onCheckedChanged(CompoundButton buttonView,
                                                     boolean isChecked) {
                            if (isChecked) {
                                inCartMap.put(inCart.getListId(), isChecked);
                                // 如果所有项都被选中，则点亮全选按钮
                                if (inCartMap.size() == mData.size()) {
                                    btnCheckAll.setChecked(true);

                                }
                            } else {
                                // 如果之前是全选状态，则取消全选状态
                                if (inCartMap.size() == mData.size()) {
                                    btnCheckAll.setOnCheckedChangeListener(null);

                                    btnCheckAll.setChecked(false);

                                }
                                inCartMap.remove(inCart.getListId());
                            }
                            notifyCheckedChanged();
                        }
                    });
            return inflate;
        }

        @Override
        public int getCount() {
            // 若mData.size() == 0，显示layoutNull
            if (mData.size() == 0) {
                listViewCart.setVisibility(View.GONE);

                layoutPayBar.setVisibility(View.GONE);
            } else {
                listViewCart.setVisibility(View.VISIBLE);

            }
            return mData.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        class ViewHolder {
            @BindView(R.id.btn_check)
            CheckBox btnCheck;
            @BindView(R.id.img_goods)
            ImageView imgGoods;
            @BindView(R.id.tv_goods_name)
            TextView tvGoodsName;
            @BindView(R.id.tv_goods_detail)
            TextView tvGoodsDetail;
            @BindView(R.id.tv_goods_price)
            TextView tvGoodsPrice;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
    private void notifyCheckedChanged() {
        price = 0;
        num = 0;
        for (int i = 0; i < mData.size(); i++) {
            Boolean isChecked = inCartMap.get(mData.get(i).getListId());
            if (isChecked != null && isChecked) {
                InCart inCart = mData.get(i);
                num+=1;
                price += inCart.getPrice();
            }
        }
        tvPrice.setText(NumberUtils.formatPrice(price));
        tvTotal.setText("总额：" + NumberUtils.formatPrice(price));
        tvCount.setText("(" + num + ")");


    }
}
