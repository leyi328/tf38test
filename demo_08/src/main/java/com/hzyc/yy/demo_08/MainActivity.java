package com.hzyc.yy.demo_08;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button dataPicker, timePicker, progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataPicker = (Button) findViewById(R.id.datePicker);
        timePicker = (Button) findViewById(R.id.timePicker);
        progressDialog = (Button) findViewById(R.id.progressDialog);

        dataPicker.setOnClickListener(new View.OnClickListener() {

            //获取系统时间
            Calendar calendar = Calendar.getInstance();

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String sj = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        Toast.makeText(MainActivity.this, sj, Toast.LENGTH_SHORT).show();
                    }
                }, year, month, day);

                datePickerDialog.show();
            }
        });

        timePicker.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();

            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            @Override
            public void onClick(View v) {
                TimePickerDialog tpd = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String sj = hourOfDay + ":" + minute;
                        Toast.makeText(MainActivity.this, sj, Toast.LENGTH_SHORT).show();
                    }
                }, hour, minute, false);

                tpd.show();
            }
        });

        progressDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd = new ProgressDialog(MainActivity.this);
                pd.setIcon(R.mipmap.ic_launcher);
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd.setTitle("读取数据");
                pd.setMessage("请等待加载中.........");
                pd.show();

                pd.setMax(100);

                class MyThread extends Thread {
                    @Override
                    public void run() {
                        int i = 0;
                        while(true){
                            pd.setProgress(i+=10);
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if( i == 100){
                                pd.dismiss();
                                break;
                            }
                        }

                    }
                }

                new MyThread().start();

                //会动啊  一点点长 长满结束
                //IO流
                //线程  休眠（睡觉 会睡醒  接着干活）
             /*   for (int i = 1; i<=100; i++){
                    pd.setProgress(i);
                }*/
            }
        });
    }
}
