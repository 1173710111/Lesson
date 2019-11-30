package com.example.lesson.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lesson.R;
import com.github.mikephil.charting.charts.PieChart;


public class ScoreActivity extends AppCompatActivity {

    private PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);
    }
}
