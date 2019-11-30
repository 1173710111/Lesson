package com.example.lesson.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lesson.Adapters.ActivityAdapter;
import com.example.lesson.Adapters.ActivityLessonsAdapter;
import com.example.lesson.Objects.Activity;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.Objects.Question;
import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LessonActivitiesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.lesson_activities_layout);
        TextView lessonName = (TextView) super.findViewById(R.id.LessonName);
        String lesson = getIntent().getStringExtra("lesson");
        lessonName.setText(lesson);
        Lesson lesson1=new Lesson(lesson);
        test(lesson1);
        RecyclerView activities=findViewById(R.id.acitvities);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        activities.setLayoutManager(layoutManager);
        ActivityAdapter adapter=new ActivityAdapter(lesson1.getActivityList(),this);
        activities.setAdapter(adapter);
    }

    private void test(Lesson lesson1){
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
        lesson1.addActivity(activity3);
    }

}
