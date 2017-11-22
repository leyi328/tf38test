package com.hzyc.yy.demo_04;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017-11-04.
 */
public class MyAdapter extends BaseAdapter {

    private List<String> list;
    private Context context;

    //安卓程序中 生命周期是一体的共享的
    //传值只有一种方法 通过构造方法直接传值
    public MyAdapter(List<String> list,Context context){
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;
        if (convertView == null) {
            textView = new TextView(context);
            textView.setTextSize(23);
        } else {
            textView = (TextView) convertView;
        }
        textView.setText(list.get(position));
        return textView;
    }

}
