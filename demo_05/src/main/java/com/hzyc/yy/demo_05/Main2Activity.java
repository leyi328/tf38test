package com.hzyc.yy.demo_05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private Button backOne;
    private EditText backValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        backOne = (Button) findViewById(R.id.backOne);
        backValue = (EditText) findViewById(R.id.backValue);

        //得到意图
        Intent intent = getIntent();

       /* String value1 = intent.getStringExtra("name");
        String value2 = intent.getStringExtra("age");
        Toast.makeText(Main2Activity.this, value1+"@@@@@@"+value2, Toast.LENGTH_SHORT).show();*/

        Bundle bundle = intent.getExtras();
        String value1 = bundle.getString("name");
        String value2 = bundle.getString("age");
        Toast.makeText(Main2Activity.this, value1+"@@@@@@"+value2, Toast.LENGTH_SHORT).show();


        backOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                String value = backValue.getText().toString().trim();
                //返回的值 还放到意图中
                intent.putExtra("backValue",value);

                setResult(400,intent); //触发onActivityResult (回到的第一个页面)
                //还需要关闭当前页面
                Main2Activity.this.finish();
               /* startActivity();
                startActivityForResult();*/
            }
        });

        //获取data文件
        SharedPreferences spf = getSharedPreferences("data",0);
        String value = spf.getString("value","nothing");

        if(!"nothing".equals(value)){
                backValue.setText(value);
        }
    }


    //发短信啊  编辑一些信息  字数比较多 打了很多了
    //编辑的信息就没有了   现场保护  QQ  微信
    //来电话了 没电了 。。。

    //数据保护下来  数据存储的方法
    //XML存储

    //在当前APP被关闭线程被结束之前调用 保护一些数据
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        String value = backValue.getText().toString().trim();

        //if(value.equals("")) // 出现异常 空指针null
        if(!"".equals(value)){

            //在手机的内部创建一个xml文件用来存储保护数据
            //如果有data 获取data 如果没有data 创建data
            SharedPreferences spf = getSharedPreferences("data",0);
            //得到data文件的编辑权限
            SharedPreferences.Editor editor = spf.edit();
            editor.putString("value",value);
            boolean bol = editor.commit();
            Toast.makeText(Main2Activity.this, "保护数据状态="+bol, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Main2Activity.this, "没有数据不需要保护的", Toast.LENGTH_SHORT).show();
        }
    }

  /*  @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }*/


}
