package com.jims.work.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jims.work.R;
import com.jims.work.adapter.CalendarItemAdapter;
import com.jims.work.adapter.DayNewsListAdapter;
import com.jims.work.fragment.base.BaseFragment;
import com.jims.work.model.CustomCalendarItemModel;
import com.jims.work.retrofit.RetrofitProvider;
import com.jims.work.service.NewsService;
import com.kelin.calendarlistview.library.CalendarHelper;
import com.kelin.calendarlistview.library.CalendarListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HealthFragment extends BaseFragment {
    @BindView(R.id.calendar_listview)
    CalendarListView calendarListView;
    private View layout;
    public static final SimpleDateFormat DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat YEAR_MONTH_FORMAT = new SimpleDateFormat("yyyy年MM月");

    private DayNewsListAdapter dayNewsListAdapter;
    private CalendarItemAdapter calendarItemAdapter;
    //key:date "yyyy-mm-dd" format.
    private TreeMap<String, List<NewsService.News.StoriesBean>> listTreeMap = new TreeMap<>();

    private Handler handler = new Handler();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (layout != null) {
            // 防止多次new出片段对象，造成图片错乱问题
            return layout;
        }
        layout = inflater.inflate(R.layout.fragment_health, container, false);


        ButterKnife.bind(this, layout);
        dayNewsListAdapter = new DayNewsListAdapter(getContext());
        calendarItemAdapter = new CalendarItemAdapter(getContext());
        calendarListView.setCalendarListViewAdapter(calendarItemAdapter, dayNewsListAdapter);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -7);
       // loadNewsList(DAY_FORMAT.format(calendar.getTime()));
        //actionBar.setTitle(YEAR_MONTH_FORMAT.format(calendar.getTime()));

        // deal with refresh and load more event.
        calendarListView.setOnListPullListener(new CalendarListView.onListPullListener() {
            @Override
            public void onRefresh() {
                String date = listTreeMap.firstKey();
                Calendar calendar = CalendarHelper.getCalendarByYearMonthDay(date);
                calendar.add(Calendar.MONTH, -1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
              //  loadNewsList(DAY_FORMAT.format(calendar.getTime()));
            }

            @Override
            public void onLoadMore() {
                String date = listTreeMap.lastKey();
                Calendar calendar = CalendarHelper.getCalendarByYearMonthDay(date);
                calendar.add(Calendar.MONTH, 1);
                calendar.set(Calendar.DAY_OF_MONTH, 1);
               // loadNewsList(DAY_FORMAT.format(calendar.getTime()));
            }
        });

        //
        calendarListView.setOnMonthChangedListener(new CalendarListView.OnMonthChangedListener() {
            @Override
            public void onMonthChanged(String yearMonth) {
                Calendar calendar = CalendarHelper.getCalendarByYearMonth(yearMonth);
                //actionBar.setTitle(YEAR_MONTH_FORMAT.format(calendar.getTime()));
                loadCalendarData(yearMonth);
                Toast.makeText(getContext(), YEAR_MONTH_FORMAT.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
            }
        });

        calendarListView.setOnCalendarViewItemClickListener(new CalendarListView.OnCalendarViewItemClickListener() {
            @Override
            public void onDateSelected(View View, String selectedDate, int listSection, SelectedDateRegion selectedDateRegion) {

            }
        });
        return layout;
    }


    //this code is just for generate test date for ListView!
    private void loadNewsList(String date) {
        Calendar calendar = getCalendarByYearMonthDay(date);
        String key = CalendarHelper.YEAR_MONTH_FORMAT.format(calendar.getTime());

        // just not care about how data to create.
        Random random = new Random();
        final List<String> set = new ArrayList<>();
        while (set.size() < 5) {
            int i = random.nextInt(29);
            if (i > 0) {
                if (!set.contains(key + "-" + i)) {
                    if (i < 10) {
                        set.add(key + "-0" + i);
                    } else {
                        set.add(key + "-" + i);
                    }
                }
            }
        }
        for (int i = 0; i < set.size(); i++) {
            String day = set.get(i);
            NewsService.News news = new NewsService.News();
            news.setDate(day);

            if (listTreeMap.get(day) != null) {
                List<NewsService.News.StoriesBean> list = listTreeMap.get(day);

            } else {
                List<NewsService.News.StoriesBean> list = new ArrayList<NewsService.News.StoriesBean>();
                list=news.getStories();

                listTreeMap.put(day, list);
            }
        }

        dayNewsListAdapter.setDateDataMap(listTreeMap);
        dayNewsListAdapter.notifyDataSetChanged();
        calendarItemAdapter.notifyDataSetChanged();

    }



    // date (yyyy-MM),load data for Calendar View by date,load one month data one times.
    // generate test data for CalendarView,imitate to be a Network Requests. update "calendarItemAdapter.getDayModelList()"
    //and notifyDataSetChanged will update CalendarView.
    private void loadCalendarData(final String date) {
        new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Random random = new Random();
                            if (date.equals(calendarListView.getCurrentSelectedDate().substring(0, 7))) {
                                for (String d : listTreeMap.keySet()) {
                                    if (date.equals(d.substring(0, 7))) {
                                        CustomCalendarItemModel customCalendarItemModel = calendarItemAdapter.getDayModelList().get(d);
                                        if (customCalendarItemModel != null) {
                                            customCalendarItemModel.setNewsCount(listTreeMap.get(d).size());
                                            customCalendarItemModel.setFav(random.nextBoolean());
                                        }

                                    }
                                }
                                calendarItemAdapter.notifyDataSetChanged();
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

    }    public static Calendar getCalendarByYearMonthDay(String yearMonthDay) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(DAY_FORMAT.parse(yearMonthDay).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }
}
