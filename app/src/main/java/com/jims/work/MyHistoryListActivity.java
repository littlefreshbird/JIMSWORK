package com.jims.work;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.jims.work.adapter.GirdDropDownAdapter;
import com.jims.work.adapter.ListDropDownAdapter;
import com.jims.work.adapter.MyhistoryListAdapter;
import com.jims.work.bean.MyhistoryInfo;
import com.jims.work.utils.Constants;
import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyHistoryListActivity extends AppCompatActivity {

    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;


    private Context context;
    private String headers[] = Constants.MyString.HEADERS;
    private String department[] = Constants.MyString.DEPARTMENT;
    private String sex[] = Constants.MyString.SEX;
    private String synthetic[] = Constants.MyString.SYNTHETIC;
    private String professional[] = Constants.MyString.PROFESSIONAL;
    private ArrayList<MyhistoryInfo> doctorsList = new ArrayList<MyhistoryInfo>();


    ListDropDownAdapter sexAdapter, syntheticAdapter, professionalAdapter;
    GirdDropDownAdapter departmentAdapter;
    MyhistoryListAdapter mDoctorsListAdapter;
    private List<View> popupViews = new ArrayList<>();
    private int constellationPosition = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_doctor_list);
        ButterKnife.bind(this);
        context = MyHistoryListActivity.this;
        initGoods();
        initview();
    }

    private void initGoods() {
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第一附属医院", "心血管内科", "副主任医师", "100001","2016-12-15", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002","2016-12-01", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003","2016-11-10", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第三附属医院", "心血管内科", "副主任医师", "100001","2016-09-07", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002","2016-04-02", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003","2016-03-02", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第二附属医院", "心血管内科", "副主任医师", "100001","2016-03-01", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003","2016-02-01", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李云龙", "承德市第一附属医院", "心血管内科", "副主任医师", "100001","2016-01-31", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002","2015-09-17", "就诊时间：", "就诊人：", "张强"));
        doctorsList.add(new MyhistoryInfo("周慧敏", "承德市妇幼保健院", "小儿科", "副主任医师", "100003","2015-08-14", "就诊时间：", "就诊人：", "张强"));

    }

    private void initview() {
        //init department menu
        final View constellationView = getLayoutInflater().inflate(R.layout.custom_layout, null);
        final GridView departmentView = ButterKnife.findById(constellationView,R.id.constellation);
        departmentAdapter = new GirdDropDownAdapter(this, Arrays.asList(department));
        departmentView.setAdapter(departmentAdapter);

        //init sex menu
        final ListView sexView = new ListView(this);
        sexView.setDividerHeight(0);
        sexAdapter = new ListDropDownAdapter(this, Arrays.asList(sex));
        sexView.setAdapter(sexAdapter);
        //init sex menu
        final ListView syntheticView = new ListView(this);
        syntheticView.setDividerHeight(0);
        syntheticAdapter = new ListDropDownAdapter(this, Arrays.asList(synthetic));
        syntheticView.setAdapter(syntheticAdapter);
        //init sex menu
        final ListView professionalView = new ListView(this);
        professionalView.setDividerHeight(0);
        professionalAdapter = new ListDropDownAdapter(this, Arrays.asList(professional));
        professionalView.setAdapter(professionalAdapter);

        //init context view
        final ListView mListView = new ListView(this);
        mListView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mDoctorsListAdapter = new MyhistoryListAdapter(this, doctorsList);
        mListView.setAdapter(mDoctorsListAdapter);

        //init popupViews
        popupViews.add(constellationView);
        popupViews.add(sexView);
        popupViews.add(syntheticView);
        popupViews.add(professionalView);

        //add item click event
        departmentView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                departmentAdapter.setCheckItem(position);
                dropDownMenu.setTabText(position == 0 ? headers[0] : department[position]);
                dropDownMenu.closeMenu();
            }
        });
        sexView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sexAdapter.setCheckItem(position);
                dropDownMenu.setTabText(position == 0 ? headers[1] : sex[position]);
                dropDownMenu.closeMenu();
            }
        });
        syntheticView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                syntheticAdapter.setCheckItem(position);
                dropDownMenu.setTabText(position == 0 ? headers[2] : synthetic[position]);
                dropDownMenu.closeMenu();
            }
        });
        professionalView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                professionalAdapter.setCheckItem(position);
                dropDownMenu.setTabText(position == 0 ? headers[3] : professional[position]);
                dropDownMenu.closeMenu();
            }
        });


        //init dropdownview
        dropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, mListView);

    }

    @Override
    public void onBackPressed() {
        //退出activity前关闭菜单
        if (dropDownMenu.isShowing()) {
            dropDownMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
