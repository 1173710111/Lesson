package com.example.lesson.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.lesson.R;

public class LoginActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private Button signin;
    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        radioGroup=findViewById(R.id.identity);
        signin=findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.stu:
                        loginCheck();
                        Intent intent1=new Intent(LoginActivity.this,MainStuActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.tea:
                        loginCheck();
                        Intent intent2=new Intent(LoginActivity.this,MainTeaActivity.class);
                        startActivity(intent2);
                        break;
                    default:
                        break;
                }
            }
        });
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
    private void loginCheck(){

    }
}
