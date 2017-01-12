package com.jims.work;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jims.work.adapter.CommentAdapter;
import com.jims.work.adapter.CommentReplyAdapter;
import com.jims.work.bean.Comment;
import com.jims.work.bean.Reply;
import com.jims.work.fragment.ServiceFragment;

import java.util.ArrayList;
import java.util.List;

import static com.jims.work.R.id.ratingbar;

/**
 * Created by Just on 2017/1/11.
 */

public class ReplyActivity extends AppCompatActivity {
    private ListView lv_user_comments;
    private Button btn_comment, btn_reply;
    private EditText edt_reply;
    private CommentAdapter commentAdapter;
    private CommentReplyAdapter commentReplyAdapter;
    private static final int ONE_COMMENT_CODE = -1;
    private List<Comment> commentList;
    private List<Reply> replyList;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reply);
        ratingBar = (RatingBar)findViewById(R.id.ratingbar);
        setCustomActionBar();
        initView();
        initCommentData();
    }

    private void initView() {
        lv_user_comments = (ListView) this.findViewById(R.id.lv_comments);
       // btn_comment = (Button) this.findViewById(R.id.btn_main_send);
        commentList = new ArrayList<Comment>();
     //   btn_comment.setOnClickListener(addCommentListener);
    }

    private void initCommentData() {
        Comment comment = new Comment();
        comment.setUsername("花医生");
        comment.setContent("我是一楼");
        commentList.add(comment);

        Comment comment2 = new Comment();
        comment2.setUsername("黄医生");
        comment2.setContent("估计是废了");
        commentList.add(comment2);

        commentReplyAdapter = null;
        commentAdapter = new CommentAdapter(this, commentList,
                replyToCommentListener, commentReplyAdapter,
                replyToReplyListener);
        lv_user_comments.setAdapter(commentAdapter);
    }

    /**
     * 发表评论的监听
     */
    private View.OnClickListener addCommentListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            onCreateDialog(ONE_COMMENT_CODE, ONE_COMMENT_CODE);
        }
    };

    /**
     * 回复评论的监听（回复楼主）
     */
    private View.OnClickListener replyToCommentListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            onCreateDialog(ONE_COMMENT_CODE, position);
        }
    };
    /**
     * 评价监听
     */
    private View.OnClickListener pinglunToCommentListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            onCreateDialog(ONE_COMMENT_CODE, position);
        }
    };
    /**
     * 互相回复的监听（楼中楼）
     */
    private View.OnClickListener replyToReplyListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int parentPosition = (Integer) v.getTag(R.id.tag_first);
            int childPosition = (Integer) v.getTag(R.id.tag_second);
            onCreateDialog(parentPosition, childPosition);
        }
    };

    /**
     * 弹出评论的对话框
     *
     * @param parentPositon
     *            父节点的position
     * @param childPostion
     *            子节点的position
     * @return
     */
    protected Dialog onCreateDialog(final int parentPositon,
                                    final int childPostion) {
        final Dialog customDialog = new Dialog(this);
        LayoutInflater inflater = getLayoutInflater();
        View mView = inflater.inflate(R.layout.dialog_comment, null);
        edt_reply = (EditText) mView.findViewById(R.id.edt_comments);
        btn_reply = (Button) mView.findViewById(R.id.btn_send);

        customDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        customDialog.setContentView(mView);
        customDialog.show();

        btn_reply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (childPostion) {
                    case ONE_COMMENT_CODE:
                        if (TextUtils.isEmpty(edt_reply.getText().toString())) {
                            Toast.makeText(ReplyActivity.this, "内容不能为空",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Comment comment = new Comment();
                            comment.setUsername("方医生");
                            comment.setContent(edt_reply.getText().toString());

                            commentList.add(comment);
                            commentAdapter.clearList();
                            commentAdapter.updateList(commentList);
                            commentAdapter.notifyDataSetChanged();
                            customDialog.dismiss();
                            edt_reply.setText("");
                        }
                        break;
                    default:
                        if (TextUtils.isEmpty(edt_reply.getText().toString())) {
                            Toast.makeText(ReplyActivity.this, "内容不能为空",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Reply reply = new Reply();
                            reply.setUsername("刘" + parentPositon + childPostion);
                            reply.setContent(edt_reply.getText().toString());

                            if (parentPositon != -1) {
                                reply.setReplyTo(commentList.get(parentPositon)
                                        .getReplyList().get(childPostion)
                                        .getUsername());
                                commentList.get(parentPositon).getReplyList()
                                        .add(reply);
                            } else {
                                replyList = commentList.get(childPostion)
                                        .getReplyList();
                                replyList.add(reply);
                                commentList.get(childPostion).setReplyList(
                                        replyList);
                            }

                            commentAdapter.clearList();
                            commentAdapter.updateList(commentList);
                            commentAdapter.notifyDataSetChanged();
                            customDialog.dismiss();
                            edt_reply.setText("");
                        }
                        break;
                }
            }
        });
        return customDialog;
    }
    //调用menu中的main资源
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mf=getMenuInflater();
        mf.inflate(R.menu.main1,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.huifu:
                onCreateDialog(ONE_COMMENT_CODE, ONE_COMMENT_CODE);
                return true;
            case R.id.jietie:
                Toast.makeText(this, "已结帖", Toast.LENGTH_SHORT).show();
                return true;
            case android.R.id.home:
                ServiceFragment serviceFragment=new ServiceFragment();
                serviceFragment.setMenuVisibility(true);
                /*Intent intent1=new Intent(ReplyActivity.this,MainActivity.class);//点击回主页
                startActivity(intent1);*/
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void setCustomActionBar() {
        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
        View mActionBarView = LayoutInflater.from(this).inflate(R.layout.actionbar_reply, null);
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
}
