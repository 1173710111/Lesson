package com.example.lesson.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson.Activities.LessonActivity;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.util.List;

public class LessonAdapter_OneSub extends RecyclerView.Adapter<LessonAdapter_OneSub.ViewHolder> {
    private List<Lesson> lessonList;
    private Context context;

    public LessonAdapter_OneSub(List<Lesson> lessonList, Context context) {
        this.lessonList = lessonList;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lesson_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.lessonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Lesson lesson=lessonList.get(position);
                //Toast.makeText(context, "click"+position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, LessonActivity.class);
                intent.putExtra("lesson",lesson.getName());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Lesson lesson=lessonList.get(position);
        holder.lessonName.setText(lesson.getName());
        SubLesson subLesson=lesson.getSubLessonList().get(lesson.getSubLessonList().size()-1);
        holder.subLessonNumber.setText(subLesson.getNumber());
        holder.subLessonName.setText(subLesson.getName());
        holder.subLessonDate.setText(subLesson.getPublishDate());
        LinearLayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        holder.questions.setLayoutManager(layoutManager);
        QuestionAdapter quesAdapter=new QuestionAdapter(subLesson.getQuestions(),context);
        holder.questions.setAdapter(quesAdapter);
        //Toast.makeText(context,""+lesson.getSubLessonList().size(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView lessonName;
        TextView subLessonNumber;
        TextView subLessonName;
        TextView subLessonDate;
        RecyclerView questions;
        View lessonView;
        public ViewHolder( View view) {
            super(view);
            lessonView=view;
            lessonName=view.findViewById(R.id.LessonName);
            subLessonNumber=view.findViewById(R.id.SubLessonNumber);
            subLessonName=view.findViewById(R.id.SubLessonName);
            subLessonDate= view.findViewById(R.id.SubLessonDate);
            questions=view.findViewById(R.id.questions);
        }
    }
}
