package com.hzyc.yy.demo_04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CaiPinActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_pin);
        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new Image_Text());
    }

    private List<Map<String,Object>> getList(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 1; i<=16; i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("photo",R.drawable.image1);
            map.put("cname","名称"+i);
            map.put("price",12.2+i);
            map.put("rating",i%5);
            map.put("bz","小米手机");

            list.add(map);
        }
        return list;
    }

    class Image_Text extends BaseAdapter {

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
                view = LayoutInflater.from(CaiPinActivity.this).inflate(R.layout.caipin_child,null);
            }else{
                view = convertView;
            }
            //直接这么写  加载是onCreate里面的 默认布局
            //findViewById()
            ImageView imageView = (ImageView) view.findViewById(R.id.photo);
            TextView cname = (TextView) view.findViewById(R.id.cname);
            TextView price = (TextView) view.findViewById(R.id.price);
            RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            TextView bz = (TextView) view.findViewById(R.id.bz);

            imageView.setImageResource(Integer.parseInt(getList().get(position).get("photo").toString()));
            cname.setText(getList().get(position).get("cname").toString());
            price.setText(getList().get(position).get("price").toString());
            ratingBar.setRating(Float.parseFloat(getList().get(position).get("rating").toString()));
            bz.setText(getList().get(position).get("bz").toString());
            return view;
        }
    }
}
