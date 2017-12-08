package com.example.administrator.test.utils;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.example.administrator.test.R;
import com.example.administrator.test.domain.NewsBean;

import java.util.ArrayList;

/**
 * Created by My on 2017/12/8.
 */

public class NewsUtil {
    public static ArrayList<NewsBean> getAllNewsFromLocal(Context context) {
        ArrayList<NewsBean> list = new ArrayList<>();
        NewsBean newsBean;
        for (int i = 0; i < 5; i++) {
            newsBean = new NewsBean();
            newsBean.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.wuhan);
            newsBean.title = "鸟瞰暴雨后的武汉 全市已转移16万人次";
            newsBean.des = "7月5-6日，武汉普降暴雨-大暴雨，中心城区、蔡甸部分地区出现特大暴雨。江夏大道汤逊湖大桥段，被湖水冲破的路障。记者贾代腾飞 陈卓摄";
            newsBean.new_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101020.html#p=1";
            list.add(newsBean);

            newsBean = new NewsBean();
            newsBean.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.eyu);
            newsBean.title = "安徽暴雨 三四十条鳄鱼逃至附近农田";
            newsBean.des = "因强降雨造成内涝，安徽省芜湖市芜湖县花桥镇鳄鱼湖农庄所养鳄鱼逃跑至附近农田。。据悉，溜出来的鳄鱼为散养的扬子鳄，比较温驯。初步预计有三四十条，具体数量未统计，其中最大的约1.8米长。图为网友拍摄到的农田中的鳄鱼。";
            newsBean.new_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101024.html#p=1";
            list.add(newsBean);

            newsBean = new NewsBean();
            newsBean.icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.qihuan);
            newsBean.title = "暴雨过后 南京理工大学变“奇幻森林";
            newsBean.des = "近日，持续强降雨，导致地势低洼的南京理工大学出现严重积水。这一组几张照片，南理工恍若童话世界中。网友：泡在水中的南理工，也可以倔强地刷出颜值新高度。";
            newsBean.new_url = "http://slide.news.sina.com.cn/s/slide_1_2841_101010.html#p=1";
            list.add(newsBean);
        }
        return list;
    }
}
