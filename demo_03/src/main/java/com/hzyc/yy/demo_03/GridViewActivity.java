package com.hzyc.yy.demo_03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class GridViewActivity extends AppCompatActivity {

    private GridView gridView;

    private int [] data = {R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1,
            R.drawable.image1,R.drawable.image1,R.drawable.image1,R.drawable.image1};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.gridView);
        //1.怎么放控件？ （通过适配器）
            //适配器咋写？
        //2.放完之后怎么显示？
        //把适配器 给 gridView
        gridView.setAdapter(new MyAdapter());

        //添加事件
       /* gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public Object getItem(int position) {
            return data[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        //数组的长度是多少  这个方法会调用多少遍
        //gridView调用getView
        //每调用一次  一个item将会得到一个具体的控件并且显示出来
        //返回给gridView一个带数据的完整的控件
        //获取到数据   把数据放入大合适的控件中 最后返回这个控件
        public View getView(int position, View convertView, ViewGroup parent) {
            //选择控件
            ImageView imageView;
            //判断适配器第几次调用这个方法  （有缓存）
            //convertView == null 判断有没有缓存
            if(convertView == null){
                imageView = new ImageView(GridViewActivity.this);
                imageView.setPadding(8,8,8,8);
            }else{
                imageView = (ImageView) convertView;
            }

            //把数据放入到控件中
            imageView.setImageResource(data[position]);
            return imageView;
        }
    }
}
