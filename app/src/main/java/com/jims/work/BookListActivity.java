package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.jims.work.adapter.BookListItemAdapter;
import com.jims.work.bean.Level0Item;
import com.jims.work.bean.Level1Item;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListActivity extends BaseActivity1 {

    BookListItemAdapter mBookListItemAdapter;
    ArrayList<MultiItemEntity> list;
    @BindView(R.id.rv)
    RecyclerView rv;
    static BookListActivity mBookListActivity;
    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, BookListActivity.class)
                .putExtra("id", bookId));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_book_list;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("挂号列表");
    }

    @Override
    public void initDatas() {
        mBookListActivity=this;
        rv.setLayoutManager(new LinearLayoutManager(this));
        list = generateData();
        mBookListItemAdapter = new BookListItemAdapter(list, BookListActivity.this);


        rv.setAdapter(mBookListItemAdapter);
        expandAll();
    }
    private void expandAll() {
        for (int i = 0; i <list.size() ; i++) {
            mBookListItemAdapter.expand(i + mBookListItemAdapter.getHeaderLayoutCount(), false, false);
        }
    }
    @Override
    public void configViews() {

    }
    private ArrayList<MultiItemEntity> generateData() {



        String[] names={"李玉兰","李玉珍","李云龙"};
        String[] classes={"儿科","儿科","儿科"};
        String[] hospital={"附属医院","承钢医院","承钢医院"};
        String[] position={"主任医师","副主任医师","副主任医师"};
        String[] detail={"湿疹，营养不良","","感冒，发烧"};

        String[] date={"2017-04-10","2017-04-11","2017-04-12"};
        String[] week={"星期一","星期二","星期三"};
        String[] longtime={"上午","下午","全天"};
        String[] last={"5","4","10"};

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Level0Item lv0 = new Level0Item(names[i],classes[i],position[i],hospital[i],detail[i]);
            for (int j = 0; j < date.length; j++) {
                Level1Item lv1 = new Level1Item(date[j],week[j],longtime[j],"剩余票数："+last[j]);

                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        return res;
    }
}
