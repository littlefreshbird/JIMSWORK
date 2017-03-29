package com.jims.work;

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

public class DoctorDetailActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);
        ButterKnife.bind(this);
        setCustomActionBar();
        initview();
    }

    private void initview() {
        tvlongIntro.setText(R.string.doctormessage);
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

    public void setCustomActionBar() {
        ActionBar.LayoutParams lp = new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar, null);
        TextView textView = ButterKnife.findById(mActionBarView, android.R.id.title);
        textView.setText("医生详情");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setCustomView(mActionBarView, lp);
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setDisplayShowHomeEnabled(false);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.action_bar_back);
        actionBar.setElevation(2);
    }

    @OnClick({R.id.btnJoinCollection, R.id.btnRead})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnJoinCollection:
                Intent intent = new Intent(this, SubscibeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRead:
                Intent i = new Intent(this, BooksureActivity.class);
                startActivity(i);
                break;
        }
    }
}
