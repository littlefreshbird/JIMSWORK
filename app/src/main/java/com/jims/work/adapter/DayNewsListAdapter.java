package com.jims.work.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jims.work.R;
import com.jims.work.fragment.HealthFragment;
import com.jims.work.model.ListCanlendarItemModel;
import com.kelin.calendarlistview.library.BaseCalendarListAdapter;
import com.kelin.calendarlistview.library.CalendarHelper;
import com.squareup.picasso.Picasso;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DayNewsListAdapter extends BaseCalendarListAdapter<ListCanlendarItemModel> {


    public DayNewsListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getSectionHeaderView(String date, View convertView, ViewGroup parent) {
        HeaderViewHolder headerViewHolder;

        if (convertView != null) {
            headerViewHolder = (HeaderViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.listitem_calendar_header, null);
            headerViewHolder = new HeaderViewHolder();
            headerViewHolder.dayText = (TextView) convertView.findViewById(R.id.header_day);
            headerViewHolder.yearMonthText = (TextView) convertView.findViewById(R.id.header_year_month);
            headerViewHolder.isFavImage = (ImageView) convertView.findViewById(R.id.header_btn_fav);
            convertView.setTag(headerViewHolder);
        }

        Calendar calendar = CalendarHelper.getCalendarByYearMonthDay(date);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String dayStr = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
        if (day < 10) {
            dayStr = "0" + dayStr;
        }
        headerViewHolder.dayText.setText(dayStr);
        headerViewHolder.yearMonthText.setText(HealthFragment.YEAR_MONTH_FORMAT.format(calendar.getTime()));
        return convertView;
    }

    @Override
    public View getItemView(ListCanlendarItemModel model, String date, int pos, View convertView, ViewGroup parent) {
        ViewHolder contentViewHolder;
        if (convertView != null) {
            contentViewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.listitem_calendar_content, null);
            contentViewHolder = new ViewHolder(convertView);
            convertView.setTag(contentViewHolder);
        }

        contentViewHolder.title.setText(model.getTitle());
        contentViewHolder.time.setText(date);
        contentViewHolder.address.setText(model.getAddress());
        contentViewHolder.keshi.setText(model.getKeshi());
        contentViewHolder.state.setText(model.getState());
        if (model.getState().equals("未开始")) {
            contentViewHolder.state.setBackground(convertView.getContext().getResources().getDrawable(R.drawable.free_treat_unstart,null));
            contentViewHolder.state.setTextColor(convertView.getContext().getResources().getColor(R.color.lightcoral));
        }else if (model.getState().equals("进行中")) {
            contentViewHolder.state.setBackground(convertView.getContext().getResources().getDrawable(R.drawable.free_treat_starting,null));
            contentViewHolder.state.setTextColor(convertView.getContext().getResources().getColor(R.color.color_theme));
        }else if (model.getState().equals("已结束")) {
            contentViewHolder.state.setBackground(convertView.getContext().getResources().getDrawable(R.drawable.free_treat_started,null));
            contentViewHolder.state.setTextColor(convertView.getContext().getResources().getColor(R.color.gray));
        }
//        GenericDraweeHierarchy hierarchy = GenericDraweeHierarchyBuilder.newInstance(convertView.getResources())
//                .setRoundingParams(RoundingParams.asCircle())
//                .build();
//        contentViewHolder.newsImageView.setHierarchy(hierarchy);
//        contentViewHolder.newsImageView.setImageURI(Uri.parse(model.getImages().get(0)));
        Picasso.with(convertView.getContext()).load(Uri.parse(model.getImages())).placeholder(R.drawable.load_logo).error(R.drawable.load_logo)
                .into(contentViewHolder.image);
        return convertView;
    }

    private static class HeaderViewHolder {
        TextView dayText;
        TextView yearMonthText;
        ImageView isFavImage;
    }


    static  class ViewHolder {
        @BindView(R.id.image)
        ImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.state)
        TextView state;
        @BindView(R.id.keshi)
        TextView keshi;
        @BindView(R.id.address)
        TextView address;
        @BindView(R.id.time)
        TextView time;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
