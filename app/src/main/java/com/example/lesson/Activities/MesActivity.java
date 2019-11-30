package com.example.lesson.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lesson.R;


public class MesActivity extends AppCompatActivity {

    private Button button_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);

        Button button_back = (Button)findViewById(R.id.btn_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView addresser = (TextView)findViewById(R.id.editaddresser) ;
        TextView message = (TextView)findViewById(R.id.editdetail) ;
        //获得Intent
        Intent intent = this.getIntent();
        //从Intent获得额外信息，设置为TextView的文本
        addresser.setText(intent.getStringExtra("addresser"));
        message.setText(intent.getStringExtra("message"));
    }

}
