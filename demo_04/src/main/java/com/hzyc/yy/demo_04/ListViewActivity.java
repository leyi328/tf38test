package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    //private ArrayAdapter<String> arrayAdapter;//专门适配文字
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView) findViewById(R.id.listView);
        //arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,getList());
        listView.setAdapter(new MyAdapter(getList(),ListViewActivity.this));
        //listView.setAdapter(arrayAdapter);

        //事件添加
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<String> getList(){
        List<String> list = Arrays.asList("数据1","数据2","数据3","数据4","数据5","数据6",
                "数据7","数据8","数据1","数据2","数据3","数据4","数据5","数据6","数据7","数据8"
                ,"数据1","数据2","数据3","数据4","数据5","数据6","数据7","数据8");
        return list;
    }

   /* class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return getList().size();
        }
        @Override
        public Object getItem(int position) {
            return getList().get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView;
            if(convertView == null){
                textView = new TextView(ListViewActivity.this);
                textView.setTextSize(23);
            }else{
                textView = (TextView) convertView;
            }
            textView.setText(getList().get(position));
            return textView;
        }
    }*/
}
