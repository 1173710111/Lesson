package com.example.lesson.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lesson.Activities.ActivityActivity;
import com.example.lesson.Activities.ActivitiesOneLessonActivity;
import com.example.lesson.Objects.Activity;
import com.example.lesson.Objects.Lesson;
import com.example.lesson.R;

import java.util.List;

public class ActivityLessonsAdapter extends RecyclerView.Adapter<ActivityLessonsAdapter.ViewHolder> {
    private List<Lesson> lessonList;
    private Context context;
    public ActivityLessonsAdapter(List<Lesson> lessons, Context context) {
        this.lessonList=lessons;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_lessons_item,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);

        holder.lessonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Lesson lesson=lessonList.get(position);
                //Toast.makeText(context, "click"+lesson.getName(), Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, ActivitiesOneLessonActivity.class);
                intent.putExtra("lesson",lesson.getName());
                context.startActivity(intent);
            }
        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Lesson lesson=lessonList.get(position);
                Activity activity=lesson.getActivityList().get(0);
                //Toast.makeText(context, "click"+position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, ActivityActivity.class);
                intent.putExtra("activity",""+activity.getNumber());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Lesson lesson=lessonList.get(i);
        viewHolder.lessonName.setText(lesson.getName());
        String type=new String("");
        Activity activity=lesson.getActivityList().get(0);
        switch (activity.getType()){
            case "homework":
                type+="作业";
                break;
            case "discuss":
                type+="课堂讨论";
                break;
                default:
                    break;
        }
       viewHolder.activityType.setText(type);
       viewHolder.activityTitle.setText(activity.getTitle());
       viewHolder.activityDDL.setText("截止时间"+activity.getDdl());
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView lessonName;
        TextView activityType;
        TextView activityTitle;
        TextView activityDDL;
        CardView card;
        public ViewHolder( View view) {
            super(view);
            lessonName=view.findViewById(R.id.LessonName);
            activityType=view.findViewById(R.id.activityType);
            activityTitle=view.findViewById(R.id.activityTitle);
            activityDDL=view.findViewById(R.id.activityDDL);
            card=view.findViewById(R.id.card);
        }
    }

}
