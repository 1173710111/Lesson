package com.example.lesson.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson.Activities.ActivityActivity;
import com.example.lesson.Activities.QuestionActivity;
import com.example.lesson.Objects.Activity;
import com.example.lesson.Objects.Question;
import com.example.lesson.Objects.SubLesson;
import com.example.lesson.R;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.SubViewHolder> {

    private List<Activity> activityList;
    private  Context context;

    public ActivityAdapter(List<Activity> objects, Context context)
    {
        this.activityList=objects;
        this.context=context;
    }

    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        final View view=LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_item,viewGroup,false);
        final SubViewHolder holder=new SubViewHolder(view);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                Activity activity=activityList.get(i);
                //Toast.makeText(context, "click"+position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, ActivityActivity.class);
                intent.putExtra("activity",""+activity.getNumber());
                context.startActivity(intent);
            }
        });
        return  holder;
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(@NonNull SubViewHolder viewHolder, int i) {
        Activity activity=activityList.get(i);
        String type=new String("");
        switch (activity.getType()){
            case "homework":
                type+="作业";
                break;
            case "discussion":
                type+="课堂讨论";
                break;
            default:
                break;
        }
        viewHolder.type.setText(type);
        viewHolder.title.setText(activity.getTitle());
        viewHolder.DDL.setText("截止时间"+activity.getDdl());

    }

    @Override
    public int getItemCount() {
        return activityList.size();
    }

    static class SubViewHolder extends RecyclerView.ViewHolder{
        TextView type;
        TextView title;
        TextView DDL;
        CardView card;
        public SubViewHolder( View view) {
            super(view);
            type=view.findViewById(R.id.activityType);
            title=view.findViewById(R.id.activityTitle);
            DDL=view.findViewById(R.id.activityDDL);
            card=view.findViewById(R.id.card);
        }
    }

}
