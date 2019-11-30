package com.example.lesson.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.lesson.Adapters.LessonAdapter_OneSub;
import com.example.lesson.Objects.Question;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    public List<Lesson> lessons=new ArrayList<Lesson>();
    private void createLessons(){
        Lesson lesson1=new Lesson("软件构造");
        SubLesson subLesson1=new SubLesson(1,"敏捷开发");
        Question question1=new Question(1);
        subLesson1.addQuestion(question1);
        long ms = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date(ms));
        SubLesson subLesson2=new SubLesson(3,"二叉树");
        Question question2=new Question(2);
        subLesson1.addQuestion(question1);
        subLesson1.addQuestion(question2);
        subLesson1.setPublishDate(date);
        subLesson2.addQuestion(question2);
        subLesson2.setPublishDate(date);
        lesson1.addSubLesson(subLesson1);
        lesson1.addSubLesson(subLesson2);
        lessons.add(lesson1);
        Lesson lesson2=new Lesson("数据结构");
        lesson2.addSubLesson(subLesson1);
        lessons.add(lesson2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_layout);
        Button unfinishedButton=findViewById(R.id.unfinished);
        unfinishedButton.setOnClickListener(this);
        //replacedFragment(new QuestionsUnfinished());
    }

    private void createUnfinishedFrame() {
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView recyclerView=findViewById(R.id.Questions);
        recyclerView.setLayoutManager(layoutManager);
        LessonAdapter_OneSub adapter = new LessonAdapter_OneSub(lessons,QuestionsActivity.this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.unfinished:
                createLessons();
                createUnfinishedFrame();
                break;
            default:
                break;
        }
    }
}
