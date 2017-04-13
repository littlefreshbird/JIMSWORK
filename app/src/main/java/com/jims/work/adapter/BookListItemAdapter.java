package com.jims.work.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;



import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.jims.work.BooksureActivity;
import com.jims.work.R;
import com.jims.work.bean.Level0Item;
import com.jims.work.bean.Level1Item;
import com.jims.work.utils.Utils;

import java.util.List;

/**
 * Created by luoxw on 2016/8/9.
 */
public class BookListItemAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private static final String TAG = BookListItemAdapter.class.getSimpleName();

    public static final int TYPE_LEVEL_0 = 0;
    public static final int TYPE_LEVEL_1 = 1;
    public  Context mContext;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public BookListItemAdapter(List<MultiItemEntity> data, Context context) {
        super(data);
        addItemType(TYPE_LEVEL_0, R.layout.item_book_list_item0);
        addItemType(TYPE_LEVEL_1, R.layout.item_book_list_item1);
        mContext=context;
    }



    @Override
    protected void convert(final BaseViewHolder holder, final MultiItemEntity item) {
        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_0:
                holder.setImageResource(R.id.img_icon, R.drawable.doctor1);

                final Level0Item lv0 = (Level0Item)item;
                holder.setText(R.id.tv_name, lv0.names)
                        .setText(R.id.tv_classes, lv0.classes)
                        .setText(R.id.tv_position, lv0.position)
                        .setText(R.id.tv_hospital, lv0.hospital)
                        .setText(R.id.tv_detail, lv0.detail)
                        .setImageResource(R.id.iv, lv0.isExpanded() ? R.mipmap.arrow_b : R.mipmap.arrow_r);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getAdapterPosition();
                        Log.d(TAG, "Level 0 item pos: " + pos);
                        if (lv0.isExpanded()) {
                            collapse(pos);
                        } else {
//                            if (pos % 3 == 0) {
//                                expandAll(pos, false);
//                            } else {
                                expand(pos);
//                            }
                        }
                    }
                });
                break;
            case TYPE_LEVEL_1:
                final Level1Item lv1 = (Level1Item)item;
                holder.setText(R.id.tv_date, lv1.date)
                        .setText(R.id.tv_week, lv1.week)
                        .setText(R.id.tv_longtime, lv1.longtime)
                        .setText(R.id.tv_last, lv1.last)
                        .setImageResource(R.id.img_icon, R.mipmap.eyr);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        BooksureActivity.startActivity(mContext,"11");


                    }
                });
                break;

        }
    }
}
