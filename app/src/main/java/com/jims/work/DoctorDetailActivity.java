package com.jims.work;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jims.work.view.DrawableCenterButton;
import com.jims.work.view.TagGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoctorDetailActivity extends BaseActivity1 {

    @BindView(R.id.ivBookCover)
    ImageView ivBookCover;
    @BindView(R.id.tvBookListTitle)
    TextView tvBookListTitle;
    @BindView(R.id.tvBookListAuthor)
    TextView tvBookListAuthor;
    @BindView(R.id.tvCatgory)
    TextView tvCatgory;
    @BindView(R.id.tvWordCount)
    TextView tvWordCount;
    @BindView(R.id.tvLatelyUpdate)
    TextView tvLatelyUpdate;
    @BindView(R.id.btnJoinCollection)
    DrawableCenterButton btnJoinCollection;
    @BindView(R.id.btnRead)
    DrawableCenterButton btnRead;
    @BindView(R.id.tvLatelyFollower)
    TextView tvLatelyFollower;
    @BindView(R.id.tvRetentionRatio)
    TextView tvRetentionRatio;
    @BindView(R.id.tvSerializeWordCount)
    TextView tvSerializeWordCount;
    @BindView(R.id.tag_group)
    TagGroup tagGroup;
    @BindView(R.id.tvlongIntro)
    TextView tvlongIntro;
    @BindView(R.id.tvMoreReview)
    TextView tvMoreReview;
    @BindView(R.id.rvHotReview)
    RecyclerView rvHotReview;
    @BindView(R.id.tvCommunity)
    TextView tvCommunity;
    @BindView(R.id.tvHelpfulYes)
    TextView tvHelpfulYes;
    @BindView(R.id.rlCommunity)
    RelativeLayout rlCommunity;
    @BindView(R.id.tvRecommendBookList)
    TextView tvRecommendBookList;
    @BindView(R.id.rvRecommendBoookList)
    RecyclerView rvRecommendBoookList;
    @BindView(R.id.btnBook)
    DrawableCenterButton btnBook;

    public static void startActivity(Context context, String bookId) {
        context.startActivity(new Intent(context, DoctorDetailActivity.class)
                .putExtra("id", bookId));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_doctor_detail;
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setNavigationIcon(R.drawable.action_bar_back);
        toolbarTitle.setText("医生详情");
    }

    @Override
    public void initDatas() {
        tvlongIntro.setText(R.string.doctormessage);
    }

    @Override
    public void configViews() {

    }




    @OnClick({R.id.btnJoinCollection, R.id.btnRead})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnJoinCollection:
                Intent intent = new Intent(this, SubscibeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRead:

                break;
        }
    }

    @OnClick(R.id.btnBook)
    public void onClick() {
        Intent i = new Intent(this, BooksureActivity.class);
        startActivity(i);
    }
}
