package com.hzyc.yy.demo_06;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button toTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toTwo = (Button) findViewById(R.id.toTwo);

       /* toTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.tip_right, R.anim.tip_left);

                //一些动画效果  动画的概念
                //res下面创建一个文件 装动画效果的配置文件

                //1 补间动画
                //2 帧动画
            }


        });*/

        //注册上下文菜单
        //默认会注册到控件长点击事件上  为了防止误操作
        registerForContextMenu(toTwo);
    }

    //2.上下文菜单
    //one.xml 继续使用
    //初始化上下文
    //menu 仍然是菜单区域
    //需要我们手动注册  去onCreate方法中注册
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.one, menu);
    }


    //1.实现第一种菜单  选项菜单
    //默认显示在页面的右上角
    //menu 表示屏幕中的菜单区域
    //默认注册的 不需要注册就会显示的
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //加载菜单文件
        MenuInflater menuInflater = getMenuInflater();
        //填充菜单文件
        menuInflater.inflate(R.menu.one, menu);
        return true;
    }

    //实现选项菜单的点击应用
    //只要我单击菜单item就会调用这个方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        switch (i) {
            case R.id.save:
                Toast.makeText(MainActivity.this, "保存", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.update:
                Toast.makeText(MainActivity.this, "更新", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "删除", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }*/
}
