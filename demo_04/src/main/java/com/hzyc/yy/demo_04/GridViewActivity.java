package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new Image_Text());
    }

    //虚拟的数据
    private List<Map<String,Object>> getList(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 1; i<=16; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("imageView",R.drawable.image1);
            map.put("name","名称"+i);

            list.add(map);
        }
        return list;
    }

    class Image_Text extends BaseAdapter{

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
            //需要去外部获取适配效果（真正的用法）
            View view;
            if(convertView == null){
                //获取并加载到 一个新的布局 这个布局就是我们写好的适配效果
                view = LayoutInflater.from(GridViewActivity.this).inflate(R.layout.gridview_child,null);
            }else{
                view = convertView;
            }
            //直接这么写  加载是onCreate里面的 默认布局
            //findViewById()
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView = (TextView) view.findViewById(R.id.name);

            imageView.setImageResource(Integer.parseInt(getList().get(position).get("imageView").toString()));
            textView.setText(getList().get(position).get("name").toString());
            return view;
        }
    }
}
