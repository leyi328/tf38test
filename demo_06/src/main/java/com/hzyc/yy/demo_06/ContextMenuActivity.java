package com.hzyc.yy.demo_06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContextMenuActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ActionMode actionMode; //表示整个菜单
    //有自己内部实现过程
    private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.one,menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int i = item.getItemId();
            switch (i) {
                case R.id.save:
                    Toast.makeText(ContextMenuActivity.this, "保存", Toast.LENGTH_SHORT).show();
                    //关闭菜单
                    mode.finish();
                    return true;
                case R.id.update:
                    Toast.makeText(ContextMenuActivity.this, "更新", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.delete:
                    Toast.makeText(ContextMenuActivity.this, "删除", Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode = null;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        listView = (ListView) findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getList());
        listView.setAdapter(arrayAdapter);

        //注册菜单
        //registerForContextMenu(listView);

        //注册actionMode菜单
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                //判断菜单如果它是显示的 不需要在重复创建
                if (actionMode != null){
                    return false;
                }
                //在listView的长点击事件上注册了actionMode菜单
                actionMode = ContextMenuActivity.this.startActionMode(callback);
                return true;
            }
        });

    }

    public List<String> getList(){
        List<String> list = new ArrayList<String>();
        for(int i = 1; i<=20; i++){
            list.add("数据"+i);
        }
        return list;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater mf = getMenuInflater();
        mf.inflate(R.menu.one, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int i = item.getItemId();
        switch (i) {
            case R.id.save:
                Toast.makeText(this, "保存", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.update:
                Toast.makeText(this, "更新", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(this, "删除", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }
}
