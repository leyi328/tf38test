package com.hzyc.yy.demo_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/{

    //alt+回车  万能帮助方案
    private Button one,two;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one = (Button) findViewById(R.id.one);
        two = (Button) findViewById(R.id.one);


        /*one.setOnClickListener(this);
        two.setOnClickListener(this);*/
       /* one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        two.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //触碰
                //手机屏幕上的像素点
                //碰一次触发一次

                //手指头一直放在屏幕上  事件一直触发
                return false;
            }
        });*/

    }

   /* @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "点击", Toast.LENGTH_SHORT).show();
    }*/

    //自己设计了一个函数 作为单击事件 one和two的
    //V 很重要  V接收触发事件的控件  one点击触发 方法的时候 one == V
    public void onClick(View v){
        int id = v.getId();

        Log.i("信息打印",""+id);
        Log.i("信息打印",""+R.id.one);
        Log.i("信息打印",""+R.id.two);
        switch (id){
            case R.id.one:
                Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
                break;
            case R.id.two:
                Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
