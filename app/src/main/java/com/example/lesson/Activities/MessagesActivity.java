package com.example.lesson.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lesson.Adapters.MessageAdapter;
import com.example.lesson.Objects.Message;
import com.example.lesson.R;

import java.util.LinkedList;
import java.util.List;

public class MessagesActivity extends AppCompatActivity implements View.OnClickListener {

    public List<Message> messages = new LinkedList<Message>();

    private Context mContext;
    private MessageAdapter mAdapter = null;
    private ListView list_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        bindViews();

        mContext = MessagesActivity.this;
        createMessages();
        mAdapter = new MessageAdapter((LinkedList<Message>) messages, mContext);
        list_message.setAdapter(mAdapter);

        list_message.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //用position跳转详情页面
                String addresser = messages.get(position).getAddresser();
                String message = messages.get(position).getMessage();
                Intent intent = new Intent();
                //传数据
                intent.putExtra("addresser",addresser);
                intent.putExtra("message",message);
                intent.setClass(MessagesActivity.this,MesActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createMessages(){
        messages.add(new Message("软件构造","哈哈哈哈哈"));
        messages.add( new Message("数据结构","嘿嘿嘿嘿嘿"));
        messages.add(new Message("计算机系统","嘻嘻嘻嘻嘻"));

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.mes_myself:
                Intent intent7 = new Intent(MessagesActivity.this, MainActivity.class);    //跳转设置
                startActivity(intent7);
                break;
            case R.id.mes_mylessons:
                Intent intent8 = new Intent(MessagesActivity.this, MylessonsActivity.class);    //跳转设置
                startActivity(intent8);
                break;
            case R.id.mes_messages:
                Intent intent9 = new Intent(MessagesActivity.this, MessagesActivity.class);    //跳转设置
                startActivity(intent9);
                break;
            case R.id.mes_btn_sys:
                Toast.makeText(mContext, "点了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mes_btn_get:
                //按要求筛选、更新、在Adapter里面
                //notifyDataSetChanged();
                break;
            case R.id.mes_btn_sea:
                Intent intent6 = new Intent(MessagesActivity.this, SearchMessageActivity.class);    //跳转设置
                startActivity(intent6);
                break;
        }
    }

    private void bindViews(){

        Button button1 = (Button) findViewById(R.id.mes_myself);
        Button button2 = (Button) findViewById(R.id.mes_mylessons);
        Button button3 = (Button) findViewById(R.id.mes_messages);

        Button button_ing = (Button) findViewById(R.id.mes_btn_sys);
        Button button_fin = (Button) findViewById(R.id.mes_btn_get);
        Button button_sea = (Button) findViewById(R.id.mes_btn_sea);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        button_ing.setOnClickListener(this);
        button_fin.setOnClickListener(this);
        button_sea.setOnClickListener(this);

        list_message = (ListView)findViewById(R.id.list_message);
    }
}
