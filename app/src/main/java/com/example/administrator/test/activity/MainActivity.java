package com.example.administrator.test.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.test.R;
import com.example.administrator.test.domain.NewsBean;
import com.example.administrator.test.utils.NewsUtil;

import java.util.ArrayList;

/**
 * 新闻案例本地版
 * 2017年12月8日19:31:53
 */
public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList<NewsBean> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initData();
        initAdapter();

    }

    private void initAdapter() {
        NewsAdapter newsAdapter = new NewsAdapter();
        lv.setAdapter(newsAdapter);
    }

    private void initData() {
        mList = NewsUtil.getAllNewsFromLocal(this);
    }

    private void initUI() {
        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsBean newsBean = mList.get(position);
                String new_url = newsBean.new_url;
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(new_url));
                startActivity(intent);
            }
        });
    }


    private class NewsAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public NewsBean getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(), R.layout.listview_item, null);
                holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
                holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
                holder.tv_des = (TextView) convertView.findViewById(R.id.tv_des);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            NewsBean item = getItem(position);
            holder.iv_icon.setImageBitmap(item.icon);
            holder.tv_title.setText(item.title);
            holder.tv_des.setText(item.des);
            return convertView;
        }
    }

    private static class ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
        TextView tv_des;
    }
}
