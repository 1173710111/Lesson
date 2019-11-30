package com.example.lesson.Activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lesson.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityActivity extends AppCompatActivity implements View.OnClickListener {

    private int getMemberNumber=5;
    private int getMemberNumberNow=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        createView();
        TextView memberNumberNow=findViewById(R.id.memberNumberNow);
        memberNumberNow.setText(getMemberNumberNow+"");
        TextView memberNumber=findViewById(R.id.memberNumber);
        memberNumber.setText("/"+getMemberNumber);
        Button addMember=findViewById(R.id.addMember);
        addMember.setOnClickListener(ActivityActivity.this);
    }

    private void createView(){
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addMember:
                addMember();
        }
    }

    private void addMember() {
        final List<String> membersToAdd=new ArrayList<String>();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("所有成员");
        final String[] memberNames=new String[createMember().size()];
        final boolean[] checkedItems = new boolean[createMember().size()];
        for (int i=0;i<createMember().size();i++){
            checkedItems[i]=false;
            memberNames[i]=createMember().get(i);
        }
        builder.setMultiChoiceItems(memberNames, checkedItems, new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checkedItems[which]=isChecked;
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i=0;i<memberNames.length;i++){
                    if (checkedItems[i]){
                        membersToAdd.add(memberNames[i]);
                    }
                }
                addMember_sub(membersToAdd);
            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();

    }
    private void addMember_sub(List<String> membersToAdd){
        //Toast.makeText(this, ""+membersToAdd.get(1), Toast.LENGTH_SHORT).show();
        final LinearLayout layout=findViewById(R.id.members);
        final TextView memberNumberNow=findViewById(R.id.memberNumberNow);
        for (String name:membersToAdd){
            final TextView textView=new TextView(this);
            textView.setText(name);
            layout.addView(textView);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder;
                    builder = new AlertDialog.Builder(ActivityActivity.this);
                    builder.setMessage("确定将此人移出队伍？");
                    builder.setCancelable(false);
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            layout.removeView(textView);
                            getMemberNumberNow--;
                            memberNumberNow.setText(getMemberNumberNow+"");
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    builder.show();
                }
            });
        }
        this.getMemberNumberNow+=membersToAdd.size();
        memberNumberNow.setText(getMemberNumberNow+"");
    }

    private List<String> createMember(){
        List<String> members=new ArrayList<String>();
        members.add("王一");
        members.add("赵二");
        members.add("张三");
        members.add("李四");
        members.add("王五");
        members.add("陆六");
        members.add("李华");
        members.add("李红");
        members.add("王五");
        members.add("陆六");
        members.add("李华");
        members.add("李红");
        return members;
    }

    private void createCheckBox(List<String> membersName,View view){

    }
}
