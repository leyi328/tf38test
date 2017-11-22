package com.hzyc.yy.demo_07;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter<String> arrayAdapter;
    private String[] str = {"喜欢", "不喜欢", "一般般"};
    private String[] str1 = {"健身", "篮球", "游泳", "音乐", "吃饭", "旅游"};
    private Button alertDialog;
    //写一个dialog公共事件处理
    private DialogInterface.OnClickListener dc = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case -1:
                    Toast.makeText(Main2Activity.this, "喜欢" + which, Toast.LENGTH_SHORT).show();
                    break;
                case -2:
                    Toast.makeText(Main2Activity.this, "不喜欢" + which, Toast.LENGTH_SHORT).show();
                    break;
                case -3:
                    Toast.makeText(Main2Activity.this, "一般般" + which, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner = (Spinner) findViewById(R.id.spinner);
        alertDialog = (Button) findViewById(R.id.alertDialog);
        arrayAdapter = new ArrayAdapter<String>(Main2Activity.this, R.layout.support_simple_spinner_dropdown_item, getList());
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object object = spinner.getSelectedItem();
                Toast.makeText(Main2Activity.this, object.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        alertDialog.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                //Java的一种设计模式
                //什么是设计模式
                //对象.方法.方法.方法.方法.方法
               /* AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                //建造者模式
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("问卷调查")
                        .setMessage("您喜欢看好莱坞电影吗?")
                        .setPositiveButton("喜欢", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main2Activity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("不喜欢", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main2Activity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main2Activity.this, "一般般"+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/


               /* AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                //建造者模式
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("问卷调查")
                        .setMessage("您喜欢看好莱坞电影吗?")
                        .setPositiveButton("喜欢",dc)
                        .setNegativeButton("不喜欢",dc)
                        .setNeutralButton("一般",dc)
                        .show();*/

               /* AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                //建造者模式
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("问卷调查")
                        .setSingleChoiceItems(str, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(Main2Activity.this, ""+which, Toast.LENGTH_SHORT).show();
                                *//*switch (which){
                                    case -1 :
                                        Toast.makeText(Main2Activity.this, "喜欢"+which, Toast.LENGTH_SHORT).show();
                                        break;
                                    case -2 :
                                        Toast.makeText(Main2Activity.this, "不喜欢"+which, Toast.LENGTH_SHORT).show();
                                        break;
                                    case -3 :
                                        Toast.makeText(Main2Activity.this, "一般般"+which, Toast.LENGTH_SHORT).show();
                                        break;
                                }*//*
                            }
                        })
                        .show();*/


                /*AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                //建造者模式
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("问卷调查")
                        .setMultiChoiceItems(str1, new boolean[]{true, true, true, false, false, false}, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(Main2Activity.this, ""+which, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();*/

                //我对于安卓控件的源生效果是不满意的
                //1.修改主题  修改 values/styles
                //2.通过代码  去修改主题
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this/*R.style.MyCommonDialog*/);
                //建造者模式
                builder.setIcon(R.mipmap.ic_launcher)
                        .setTitle("页面风格")
                        .setView(R.layout.login);


                AlertDialog dialog = builder.create();

                dialog.show();
                //如果 小米  华为  UI (安卓系统  界面和我们界面不一样的（APP html5） 系统界面（原生控件）)
                //3种办法
                //1.定义主题  （自定义主题）  通过style.xml 上网找比较漂亮的主题

                //2.写代码修改控件的主题
               /* Window dialogWindow = dialog.getWindow();
                WindowManager m = dialogWindow.getWindowManager();
                Display d = m.getDefaultDisplay();//获取屏幕宽和高
                WindowManager.LayoutParams layout = dialogWindow.getAttributes();//获得dialog属性
                layout.width = (int) (d.getWidth() * 0.6);
                layout.height = (int) (d.getHeight() * 0.4);
                layout.alpha = 0.5f;
                layout.gravity = Gravity.BOTTOM;
                dialogWindow.setAttributes(layout);*/
                //3.重绘  js  当我们不满足于安卓控件效果 可以把控件重新制作重新绘画一个
                //  自己重新画一个控件 用它去替代安卓原有的控件
            }
        });
    }

    public List<String> getList() {
        List<String> list = new ArrayList<String>();
        list.add("长春市");
        list.add("吉林市");
        list.add("四平市");
        return list;
    }
}
