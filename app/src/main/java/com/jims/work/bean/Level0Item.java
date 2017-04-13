package com.jims.work.bean;


import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.jims.work.adapter.BookListItemAdapter;

/**
 * Created by luoxw on 2016/8/10.
 */
public class Level0Item extends AbstractExpandableItem<Level1Item> implements MultiItemEntity {
    public String names;


    public  String classes;

    public String position;
    public String hospital;
    public String detail;

    public Level0Item(String names, String classes, String position, String hospital, String detail) {
        this.names = names;
        this.classes = classes;
        this.position = position;
        this.hospital = hospital;
        this.detail = detail;
    }

    @Override
    public int getItemType() {
        return BookListItemAdapter.TYPE_LEVEL_0;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
