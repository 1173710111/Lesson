package com.example.lesson.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson.Adapters.QuestionAdapter;
import com.example.lesson.Objects.Question;
import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {
    private String rightAnswer=new String();
    private String yourAnswer=new String();
    private String jiexi=new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_layout);
        createView();
        Button anser=findViewById(R.id.button1);
        anser.setOnClickListener(this);
        Button jiexi=findViewById(R.id.button2);
        jiexi.setOnClickListener(this);
        //Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
        //replacedFragment(new QuestionsUnfinished());
    }

    private void createView(){
        TextView name=findViewById(R.id.SubLessonNameInQuestion);
        TextView date=findViewById(R.id.SubLessonDateInQuestion);
        TextView number=findViewById(R.id.QuestionNumber);
        Intent intent=getIntent();
        name.setText("敏捷开发");
        date.setText("2017-11-12");
        number.setText(intent.getStringExtra("questionNumber"));
        RecyclerView questions=findViewById(R.id.Questions);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        questions.setLayoutManager(layoutManager);
        SubLesson subLesson1=new SubLesson(1,"敏捷开发");
        test(subLesson1);
        QuestionAdapter adapter=new QuestionAdapter(subLesson1.getQuestions(),this);
        questions.setAdapter(adapter);
    }

    private void test(SubLesson subLesson1){
       Question question1=new Question(1);
        Question question2=new Question(2);
        subLesson1.addQuestion(question1);
        long ms = System.currentTimeMillis();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new Date(ms));
        subLesson1.addQuestion(question1);
        subLesson1.addQuestion(question2);
        subLesson1.setPublishDate(date);
        this.rightAnswer="A";
        this.yourAnswer="B";
        this.jiexi="略。";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                AlertDialog.Builder dialog=new AlertDialog.Builder(QuestionActivity.this);
                dialog.setTitle("答案");
                dialog.setMessage("正确答案："+rightAnswer+"\n"+"你的答案："+yourAnswer);
                dialog.setCancelable(false);
                dialog.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            case R.id.button2:
                AlertDialog.Builder dialog2=new AlertDialog.Builder(QuestionActivity.this);
                dialog2.setTitle("解析");
                dialog2.setMessage(jiexi);
                dialog2.setCancelable(false);
                dialog2.setNegativeButton("关闭", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog2.show();
                break;

                default:
                    break;
        }
    }
}
