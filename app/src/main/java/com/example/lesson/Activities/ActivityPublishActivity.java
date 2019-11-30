package com.example.lesson.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.lesson.R;

import java.util.Calendar;

public class ActivityPublishActivity extends AppCompatActivity implements View.OnTouchListener {

    private AlertDialog alertDialog_date;
    private AlertDialog alertDialog_file;
    private AlertDialog alertDialog_delete;

    private EditText startDateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_layout);

        init();
    }

    public void init() {
        Button btn_show_act_list = (Button) findViewById(R.id.show_file_btn);
        Button btn_delete_act_list = (Button) findViewById(R.id.show_file_delete_btn);

        startDateTime = (EditText) this.findViewById(R.id.show_activity_datetime);

        startDateTime.setOnTouchListener(this);

    }

    public void showMutilAlertDialog_choose(View view) {
        final String[] items = {"1", "2", "3", "4"};
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("添加文件");
        /**
         *第一个参数:弹出框的消息集合，一般为字符串集合
         * 第二个参数：默认被选中的，布尔类数组
         * 第三个参数：勾选事件监听
         */
        alertBuilder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(ActivityPublishActivity.this, "选择添加" + items[i], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivityPublishActivity.this, "取消选择" + items[i], Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog_file.dismiss();
            }
        });

        alertBuilder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog_file.dismiss();
            }
        });
    }

    public void showMutilAlertDialog_delete(View view) {
        final String[] items2 = {"1", "2", "3", "4"};
        AlertDialog.Builder alertBuilder2 = new AlertDialog.Builder(this);
        alertBuilder2.setTitle("删除文件");
        /**
         *第一个参数:弹出框的消息集合，一般为字符串集合
         * 第二个参数：默认被选中的，布尔类数组
         * 第三个参数：勾选事件监听
         */
        alertBuilder2.setMultiChoiceItems(items2, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(ActivityPublishActivity.this, "选择删除" + items2[i], Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivityPublishActivity.this, "取消选择" + items2[i], Toast.LENGTH_SHORT).show();
                }
            }
        });
        alertBuilder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog_delete.dismiss();
            }
        });

        alertBuilder2.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialog_delete.dismiss();
            }
        });


        alertDialog_delete = alertBuilder2.create();
        alertDialog_delete.show();
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            View view = View.inflate(this, R.layout.date_time_dialog, null);
            final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker);
            final TimePicker timePicker = (android.widget.TimePicker) view.findViewById(R.id.time_picker);
            builder.setView(view);

            Calendar cal = Calendar.getInstance();
            cal.setTimeInMillis(System.currentTimeMillis());
            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null);

            timePicker.setIs24HourView(true);
            timePicker.setCurrentHour(cal.get(Calendar.HOUR_OF_DAY));
            timePicker.setCurrentMinute(Calendar.MINUTE);

            if (v.getId() == R.id.show_activity_datetime) {
                final int inType = startDateTime.getInputType();
                startDateTime.setInputType(InputType.TYPE_NULL);
                startDateTime.onTouchEvent(event);
                startDateTime.setInputType(inType);
                startDateTime.setSelection(startDateTime.getText().length());

                builder.setTitle("选取起始时间");
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        StringBuffer sb = new StringBuffer();
                        sb.append(String.format("%d-%02d-%02d",
                                datePicker.getYear(),
                                datePicker.getMonth() + 1,
                                datePicker.getDayOfMonth()));
                        sb.append("  ");
                        sb.append(timePicker.getCurrentHour())
                                .append(":").append(timePicker.getCurrentMinute());

                        startDateTime.setText(sb);
                        startDateTime.requestFocus();

                        dialog.cancel();
                    }
                });

            }
            Dialog dialog = builder.create();
            dialog.show();
        }


        return true;

    }
}
