package com.example.lesson.Activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lesson.Adapters.LessonAdapter;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.R;

import java.util.LinkedList;
import java.util.List;

public class MylessonsActivity extends AppCompatActivity implements View.OnClickListener {

    public List<Lesson> lessons1 = new LinkedList<Lesson>();

    private Context mContext;
    private LessonAdapter mAdapter = null;
    private ListView list_lesson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_lessons_layout);

        bindViews();

        mContext = MylessonsActivity.this;
        createLessons();
        mAdapter = new LessonAdapter((LinkedList<Lesson>) lessons1, mContext);
        list_lesson.setAdapter(mAdapter);

        list_lesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //用position跳转详情页面
                Intent intent = new Intent(MylessonsActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
    }


    private void createLessons(){
        lessons1.add(new Lesson("软件构造"));
        lessons1.add( new Lesson("数据结构"));
        lessons1.add(new Lesson("计算机系统"));

    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.les_myself:
                Intent intent7 = new Intent(MylessonsActivity.this, MainStuActivity.class);    //跳转设置
                startActivity(intent7);
                break;
            case R.id.les_mylessons:
                Intent intent8 = new Intent(MylessonsActivity.this, MylessonsActivity.class);    //跳转设置
                startActivity(intent8);
                break;
            case R.id.les_messages:
                Intent intent9 = new Intent(MylessonsActivity.this, MessagesActivity.class);    //跳转设置
                startActivity(intent9);
                break;
            case R.id.les_btn_ing:
                Toast.makeText(mContext, "点了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.les_btn_fin:
                //按要求筛选、更新、在Adapter里面
                //notifyDataSetChanged();
                break;
            case R.id.les_btn_sea:
                Intent intent6 = new Intent(MylessonsActivity.this, SearchLessonActivity.class);    //跳转设置
                startActivity(intent6);
                break;
        }
    }

    private void bindViews(){

        Button button1 = (Button) findViewById(R.id.les_myself);
        Button button2 = (Button) findViewById(R.id.les_mylessons);
        Button button3 = (Button) findViewById(R.id.les_messages);

        Button button_ing = (Button) findViewById(R.id.les_btn_ing);
        Button button_fin = (Button) findViewById(R.id.les_btn_fin);
        Button button_sea = (Button) findViewById(R.id.les_btn_sea);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button_ing.setOnClickListener(this);
        button_fin.setOnClickListener(this);
        button_sea.setOnClickListener(this);

        list_lesson = (ListView)findViewById(R.id.list_lesson);
    }
}
