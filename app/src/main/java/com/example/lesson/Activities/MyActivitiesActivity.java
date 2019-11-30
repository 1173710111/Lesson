package com.example.lesson.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.lesson.Adapters.ActivityLessonsAdapter;
import com.example.lesson.Objects.Activity;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyActivitiesActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Lesson> lessons=new ArrayList<Lesson>();

    private void createLessons(){
        Lesson lesson1=new Lesson("软件构造");
        Lesson lesson2=new Lesson("数据结构");
        Activity activity1=new Activity(1,"homework","完成Lab1");
        Activity activity2=new Activity(2,"homework","完成Lab2");
        Activity activity3=new Activity(1,"discussion","正则表达式的用法");
        long ms = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = dateFormat.format(new Date(ms));
        activity1.setDdl(date);
        activity2.setDdl(date);
        activity3.setDdl(date);
        lesson1.addActivity(activity1);
        lesson1.addActivity(activity2);
        lesson2.addActivity(activity3);
        lessons.add(lesson1);
        lessons.add(lesson2);
        //lessons.add(lesson3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activities_layout);
        createLessons();
        Button allButton=findViewById(R.id.allActivities);
        allButton.setOnClickListener(this);
        //replacedFragment(new QuestionsUnfinished());
    }

    private void createAllFrame() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView recyclerView=findViewById(R.id.acitvities);
        recyclerView.setLayoutManager(layoutManager);
        ActivityLessonsAdapter adapter = new ActivityLessonsAdapter(lessons, MyActivitiesActivity.this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.allActivities:

                createAllFrame();
                break;
            default:
                break;
        }
    }
}
