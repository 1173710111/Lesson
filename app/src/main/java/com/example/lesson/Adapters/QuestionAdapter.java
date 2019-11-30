package com.example.lesson.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.lesson.Activities.QuestionActivity;
import com.example.lesson.Objects.Question;
import com.example.lesson.R;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private List<Question> questionList;
    private Context context;

    public QuestionAdapter(List<Question> questionList,Context context) {
        this.questionList = questionList;
        this.context=context;
    }

    public QuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.question_item,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.question.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position=holder.getAdapterPosition();
                Question question=questionList.get(position);
                position++;
                String str="第"+position+"题";
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context, QuestionActivity.class);
                intent.putExtra("questionNumber",str);
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Question question=questionList.get(i);
        viewHolder.question.setText(question.getNumber()+"");
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        Button question;
        public ViewHolder( View view) {
            super(view);
            question=view.findViewById(R.id.question);
        }
    }
}
