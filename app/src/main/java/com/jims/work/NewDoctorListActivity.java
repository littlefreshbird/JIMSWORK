package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.jims.work.adapter.DoctorsListAdapter;
import com.jims.work.adapter.GirdDropDownAdapter;
import com.jims.work.adapter.ListDropDownAdapter;
import com.jims.work.bean.DoctorsInfo;
import com.jims.work.utils.Constants;
import com.yyydjk.library.DropDownMenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewDoctorListActivity extends BaseActivity1 {

    @BindView(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;


    private Context context;
    private String headers[] = Constants.MyString.HEADERS;
    private String department[] = Constants.MyString.DEPARTMENT;
    private String sex[] = Constants.MyString.SEX;
    private String synthetic[] = Constants.MyString.SYNTHETIC;
    private String professional[] = Constants.MyString.PROFESSIONAL;
    private ArrayList<DoctorsInfo> doctorsList = new ArrayList<DoctorsInfo>();


    ListDropDownAdapter sexAdapter, syntheticAdapter, professionalAdapter;
    GirdDropDownAdapter departmentAdapter;
    DoctorsListAdapter mDoctorsListAdapter;
    private List<View> popupViews = new ArrayList<>();
    private int constellationPosition = 0;

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, NewDoctorListActivity.class)
                .putExtra("id", bookId));
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_new_doctor_list;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("找医生");
    }

    @Override
    public void initDatas() {
        context = NewDoctorListActivity.this;
        initGoods();
        initview();
    }

    @Override
    public void configViews() {

    }

    private void initGoods() {
        doctorsList.add(new DoctorsInfo("李云龙", "承德附属医院", "心血管内科", "副主任医师", "100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor1, null), "", "153.00", "好评96%", 1224, 1, 0));
        doctorsList.add(new DoctorsInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "脑肿瘤、脑外伤、呕吐、脑缺血、脑积水、动脉瘤", context.getResources().getDrawable(R.drawable.doctor2, null), "", "479.00", "好评95%", 645, 0, 0));
        doctorsList.add(new DoctorsInfo("周慧敏", "承德妇幼保健院", "小儿科", "副主任医师", "100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎", context.getResources().getDrawable(R.drawable.doctor3, null), "", "149.00", "暂无评价", 1856, 0, 0));
        doctorsList.add(new DoctorsInfo("李云龙", "承德附属医院", "心血管内科", "副主任医师", "100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor4, null), "", "153.00", "好评96%", 1224, 1, 0));
        doctorsList.add(new DoctorsInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "脑肿瘤、脑外伤、呕吐、脑缺血、脑积水、动脉瘤", context.getResources().getDrawable(R.drawable.doctor5, null), "", "479.00", "好评95%", 645, 0, 0));
        doctorsList.add(new DoctorsInfo("周慧敏", "承德妇幼保健院", "小儿科", "副主任医师", "100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎", context.getResources().getDrawable(R.drawable.doctor1, null), "", "149.00", "暂无评价", 1856, 0, 0));
        doctorsList.add(new DoctorsInfo("李云龙", "承德附属医院", "心血管内科", "副主任医师", "100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor2, null), "", "479.00", "好评95%", 645, 0, 0));
        doctorsList.add(new DoctorsInfo("周慧敏", "承德妇幼保健院", "小儿科", "副主任医师", "100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎", context.getResources().getDrawable(R.drawable.doctor3, null), "", "149.00", "暂无评价", 1856, 0, 0));
        doctorsList.add(new DoctorsInfo("李云龙", "承德附属医院", "心血管内科", "副主任医师", "100001", "胸闷、心悸、高血压、心功能不全、心脏病、肺动脉高压", context.getResources().getDrawable(R.drawable.doctor4, null), "", "153.00", "好评96%", 1224, 1, 0));
        doctorsList.add(new DoctorsInfo("李运昌", "承德市中心医院", "神经外科", "副主任医师", "100002", "脑肿瘤、脑外伤、呕吐、脑缺血、脑积水、动脉瘤", context.getResources().getDrawable(R.drawable.doctor5, null), "", "479.00", "好评95%", 645, 0, 0));
        doctorsList.add(new DoctorsInfo("周慧敏", "承德妇幼保健院", "小儿科", "副主任医师", "100003", "新生儿疾病、发育、幼儿急疹、母乳性黄疸、手足口病、尿布皮炎", context.getResources().getDrawable(R.drawable.doctor1, null), "", "149.00", "暂无评价", 1856, 0, 0));

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
        mDoctorsListAdapter = new DoctorsListAdapter(this, doctorsList);
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
