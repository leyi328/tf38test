package com.hzyc.yy.demo_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button print;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        print = (Button) findViewById(R.id.print);

        print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //输出打印的格式
                //context == MainActivity.this
                //charsequce == String
                /*Toast.makeText(MainActivity.this, "张三", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "李四", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "王五", Toast.LENGTH_SHORT).show();*/

                Log.i("调试信息","信息调试内容1");
                Log.i("调试信息","信息调试内容2");
                Log.i("调试信息","信息调试内容3");
                Log.i("调试信息","信息调试内容4");
            }
        });
    }
}
