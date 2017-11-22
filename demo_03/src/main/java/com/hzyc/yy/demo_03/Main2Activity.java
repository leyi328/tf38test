package com.hzyc.yy.demo_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private CheckBox lq,zq,pq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lq = (CheckBox) findViewById(R.id.lq);
        zq = (CheckBox) findViewById(R.id.zq);
        pq = (CheckBox) findViewById(R.id.pq);
    }


    public void check(View view){
        int id = view.getId();
        String str = "";
        CheckBox checkBox = (CheckBox)view;
        boolean bol = checkBox.isChecked();

       /* if(R.id.one == id){
            if(){
                str +-"";
            }
        }
        if(){

        }*/
        /*switch (id){
            case R.id.lq:
                if(bol){
                    str += "篮球";
                }
                break;
            case R.id.zq:

                if(bol){
                    str += "足球";
                }
                break;
            case R.id.pq:
                if(bol){
                    str += "排球";
                }
                break;
        }
        Toast.makeText(Main2Activity.this, str, Toast.LENGTH_SHORT).show();*/
    }

}
