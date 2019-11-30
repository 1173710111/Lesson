package com.example.lesson.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.lesson.Adapters.SubLessonAdapter;
import com.example.lesson.Objects.Question;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuestionsOneLessonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.questions_onelesson_layout);
        TextView lessonName = (TextView) super.findViewById(R.id.LessonName);
        String lesson = getIntent().getStringExtra("lesson");
        lessonName.setText(lesson);
        Lesson lesson1=new Lesson(lesson);
        test(lesson1);
        RecyclerView subLessons=findViewById(R.id.subLessons);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        subLessons.setLayoutManager(layoutManager);
        SubLessonAdapter subAdapter=new SubLessonAdapter(lesson1.getSubLessonList(),this);
        subLessons.setAdapter(subAdapter);
    }

    private void test(Lesson lesson1){
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
    }

}
