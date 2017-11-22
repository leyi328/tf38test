package com.hzyc.yy.demo_05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button toTwo;
    private EditText name,age;

    @Override
    //一般来讲只执行一次
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("生命周期", "onCreate()");
        setContentView(R.layout.activity_main);
        toTwo = (Button) findViewById(R.id.toTwo);
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);

        toTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个意图 intent
                String value1 = name.getText().toString().trim();
                String value2 = age.getText().toString().trim();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                //1.直接通过intent传值
                /*intent.putExtra("name",value1);
                intent.putExtra("age",value2);*/

                //2.javabean模式  bundle模式
                Bundle bundle = new Bundle();
                bundle.putString("name",value1);
                bundle.putString("age",value2);
                intent.putExtras(bundle);

                //3.接收返回值   One 跳转了  Two    Two在返回One

                startActivityForResult(intent,200);  //触发 setResult（第二个面）

                //发送这个意图  只能送值  不能接收返回值
                //startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //javaWeb  jsp  500   404   ajax 01234   200
        //tomcat 会接收处理请求  响应请求  （匹配一个响应  200 - 505）  404  403  500
        if(requestCode == 200 && resultCode == 400){
            String backValue = data.getStringExtra("backValue");
            Toast.makeText(MainActivity.this, backValue, Toast.LENGTH_SHORT).show();
        }
    }

    //在一个了类初始化的时候 来加载一些数据（类的初始化）
    //类  对象  = new 类的构造方法();
    //构造方法   原型模式 new 100个对象  代码执行100次
    public MainActivity(){
        //代码
    }

    //优先级更高 只要类扫描类的东西就会加载
    //类无论new多少个对象类本身无论加载多少次  代码只执行一次
    //单例模式
    //对象重量级的？   加载的速度慢  初始化的时间长
    //hibernate orm模式的（非sql模式） 写 save  底层拼写sql  发送 执行
    //数据库只认识 sql语言   mybatis 写sql 发送 执行
    static{
        //类块  静态代码块
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("生命周期","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("生命周期","onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("生命周期","onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("生命周期","onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("生命周期","onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("生命周期","onRestart()");
    }
}
