package com.example.administrator.testmeituan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MainActivity extends AppCompatActivity {


    List<HashMap<String,Object>> meituanlist= new ArrayList<HashMap<String,Object>>();
    SimpleAdapter simpleAdapter;

//    List<String> listStrings =new ArrayList<>();
//    Map<String,Integer> map = new HashMap<String ,Integer>();

    //一个Item的基本属性名
    String[] from = {"image2","name1","name2","name3","newuser","show"};
                  //image2
    //上爬资源数组

    //[0][0],[0][1],
    String[][] str={{"正新鸡排","[全国]【官方】正新鸡排尊享ban单人套餐","9.8","新用户优惠","1553"},
            //[]
            {"鱼香肉食","[全国]【官方】正新鸡排尊享ban单人套餐","55","新用户优惠","13"},
            {"宫保鸡丁","[全国]【官方】正新鸡排尊享ban单人套餐","29.8","新用户优惠","3253"},
            {"麻辣香锅","[全国]【官方】正新鸡排尊享ban单人套餐","82.8","新用户优惠","53"},
            {"串串香","[全国]【官方】正新鸡排尊享ban单人套餐","90","新用户优惠","1253"}};

    //一个Item的每个属性的布局的控件ID数组
    int[] to = {R.id.image2,R.id.name1,R.id.name2,R.id.name3,R.id.newuser,R.id.show};
    //图片资源ID
    int[] go = {R.mipmap.ic_launcher, R.mipmap.ic_meituan1, R.mipmap.ic_meituan2, R.mipmap.ic_meituan3, R.mipmap.ic_meituan};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        ListView mgslistView = (ListView) findViewById(R.id.listview);
        getDate();
        simpleAdapter = new SimpleAdapter(MainActivity.this,
                meituanlist,
                R.layout.layout_two,
                from,
                to);
    mgslistView.setAdapter(simpleAdapter);
    }
    private void getDate(){
        for(int i=0;i<go.length;i++){
            HashMap<String,Object> map1 = new HashMap<String,Object>();
            map1.put("image2",go[i]);
            map1.put("name1",str[i][0]);//商品名
            map1.put("name2",str[i][1]);//详细说明
            map1.put("name3",str[i][2]);//价格
            map1.put("newuser",str[i][3]);//优惠
            map1.put("show",str[i][4]);//销量
            meituanlist.add(map1);//添加到meituanlist集合
        }
        }

    }
