package com.example.lesson.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.util.List;

public class SubLessonAdapter extends RecyclerView.Adapter<SubLessonAdapter.SubViewHolder> {

    private List<SubLesson> subLessons;
    private  Context context;

    public SubLessonAdapter(List<SubLesson> objects, Context context)
    {
        this.subLessons=objects;
        this.context=context;
    }

    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.sublesson_item,viewGroup,false);
        SubViewHolder holder=new SubViewHolder(view);
        return  holder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull SubViewHolder viewHolder, int i) {
        SubLesson subLesson=subLessons.get(i);
        viewHolder.SubLessonNumber.setText(subLesson.getNumber());
        viewHolder.SubLessonName.setText(subLesson.getName());
        viewHolder.SubLessonDate.setText(subLesson.getPublishDate());
       // Toast.makeText(context,"success",Toast.LENGTH_SHORT).show();
        LinearLayoutManager layoutManager=new LinearLayoutManager(context,LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        viewHolder.questions.setLayoutManager(layoutManager);
        QuestionAdapter quesAdapter=new QuestionAdapter(subLesson.getQuestions(),context);
        viewHolder.questions.setAdapter(quesAdapter);
    }

    @Override
    public int getItemCount() {
        return subLessons.size();
    }

    static class SubViewHolder extends RecyclerView.ViewHolder{
        TextView SubLessonNumber;
        TextView SubLessonName;
        TextView SubLessonDate;
        RecyclerView questions;
        public SubViewHolder( View view) {
            super(view);
            SubLessonNumber=view.findViewById(R.id.SubLessonNumber);
            SubLessonName=view.findViewById(R.id.SubLessonName);
            SubLessonDate=view.findViewById(R.id.SubLessonDate);
            questions=view.findViewById(R.id.questions);
        }
    }

}
