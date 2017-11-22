package com.hzyc.yy.demo_07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button popUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popUp = (Button) findViewById(R.id.popUp);

        popUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,v);
                MenuInflater menuInflater = popupMenu.getMenuInflater();
                menuInflater.inflate(R.menu.one,popupMenu.getMenu());
                //弹出的  show显示
                //智能菜单
                popupMenu.show();


                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

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
                    }
                });
            }
        });
    }
}
