package com.jims.work.bean;


import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.jims.work.adapter.BookListItemAdapter;

/**
 * Created by luoxw on 2016/8/10.
 */

public class Level1Item  implements MultiItemEntity {


        public String date;
        public String week;
        public String longtime;
        public String last;

    public Level1Item(String date, String week, String longtime, String last) {
        this.date = date;
        this.week = week;
        this.longtime = longtime;
        this.last = last;
    }

    @Override
        public int getItemType() {
            return BookListItemAdapter.TYPE_LEVEL_1;
        }
    }