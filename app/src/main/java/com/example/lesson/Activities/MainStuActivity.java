package com.example.lesson.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lesson.R;

public class MainStuActivity extends AppCompatActivity implements View.OnClickListener {

/*    private List<Option> mData = null;
    private Context mContext;
    private OptionAdapter mAdapter = null;
    private ListView list_option;*/

    private Button button11, button22, button33, button44, button55, button66, button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_stu_layout);



/*        //列表
        mContext = MainActivity.this;
        bindViews();
        mData = new LinkedList<Option>();
        mData.add(new Option("选课"));
        mData.add(new Option("课程"));
        mData.add(new Option("课件"));
        mData.add(new Option("习题"));
        mData.add(new Option("活动"));
        mData.add(new Option("讨论"));
        mAdapter = new OptionAdapter((LinkedList<Option>) mData, mContext);
        list_option.setAdapter(mAdapter);*/

        Button button11 = (Button) findViewById(R.id.ce_lessons);
        Button button22 = (Button) findViewById(R.id.ce_mylessons);
        Button button33 = (Button) findViewById(R.id.ce_ppts);
        Button button44 = (Button) findViewById(R.id.ce_questions);
        Button button55 = (Button) findViewById(R.id.ce_activities);
        Button button66 = (Button) findViewById(R.id.ce_mydiscussions);

        Button button1 = (Button) findViewById(R.id.rb_myself);
        Button button2 = (Button) findViewById(R.id.rb_mylessons);
        Button button3 = (Button) findViewById(R.id.rb_messages);

        button11.setOnClickListener(this);
        button22.setOnClickListener(this);
        button33.setOnClickListener(this);
        button44.setOnClickListener(this);
        button55.setOnClickListener(this);
        button66.setOnClickListener(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ce_lessons:
                Intent intent1 = new Intent(MainStuActivity.this, LessonInfoActivity.class);    //跳转设置
                startActivity(intent1);
                break;
            case R.id.ce_mylessons:
                Intent intent2 = new Intent(MainStuActivity.this, MylessonsActivity.class);    //跳转设置
                startActivity(intent2);
                break;
            case R.id.ce_ppts:
                Intent intent3 = new Intent(MainStuActivity.this, MyPPTsActivity.class);    //跳转设置
                startActivity(intent3);
                break;
            case R.id.ce_questions:
                Intent intent4 = new Intent(MainStuActivity.this, QuestionsActivity.class);
                startActivity(intent4);
                break;
            case R.id.ce_activities:
                Intent intent5 = new Intent(MainStuActivity.this, MyActivitiesActivity.class);
                startActivity(intent5);
                break;
            case R.id.ce_mydiscussions:
                Intent intent6 = new Intent(MainStuActivity.this, MyDiscussionsActivity.class);
                startActivity(intent6);
                break;
            case R.id.rb_myself:
                Intent intent7 = new Intent(MainStuActivity.this, MainStuActivity.class);    //跳转设置
                startActivity(intent7);
                break;
            case R.id.rb_mylessons:
                Intent intent8 = new Intent(MainStuActivity.this, MylessonsActivity.class);    //跳转设置
                startActivity(intent8);
                break;
            case R.id.rb_messages:
                Intent intent9 = new Intent(MainStuActivity.this, MessagesActivity.class);    //跳转设置
                startActivity(intent9);
                break;
        }
    }

    /*private void bindViews(){
        list_option = (ListView)findViewById(R.id.list_option);
    }*/
}
