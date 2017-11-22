package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //控件的代码形式
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.通过代码显示它
        //2.写代码比较方便
        //3.获取它的一些方法
        relativeLayout = (RelativeLayout) findViewById(R.id.rl1);

        //控件样子具体形式 靠猜
        //需要通过一个xml中已有的控件进行添加
        TextView textView = new TextView(MainActivity.this);
        textView.setText("我爱你中国");
        textView.setTextSize(23);
        relativeLayout.addView(textView);

    }
}
