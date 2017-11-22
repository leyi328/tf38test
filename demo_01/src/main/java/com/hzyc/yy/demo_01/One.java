package com.hzyc.yy.demo_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One extends AppCompatActivity {

    private Button loginButton;
    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //从login中取出 button按钮 id = loginButton  赋值给成员变量
        loginButton = (Button)findViewById(R.id.loginButton);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        //按钮添加单击事件

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //取出 用户名和密码我输入的
                //如果用户名和密码都等于admin 登录成功 否则 登录失败
                String name = username.getText().toString().trim();
                String psd = password.getText().toString().trim();
                if("admin".equals(name) && "admin".equals(psd)){
                    Toast.makeText(One.this, "登录成功!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(One.this, "登录失败!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
