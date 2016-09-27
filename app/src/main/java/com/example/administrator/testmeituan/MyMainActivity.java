package com.example.administrator.testmeituan;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/26.
 */
public class MyMainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(MyMainActivity.this);//<LinearLayout></LinearLayout>
        //设置LinerLayout属性
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        //设置排布方向
        linearLayout.setOrientation(LinearLayout.VERTICAL);//方向为垂直
        //设置背景
        linearLayout.setBackgroundColor(getResources().getColor(android.R.color.white));//设置白色
        //LinearLayout----->ViewGrouo---->View
        //创建导航栏对象添加到最外层布局
        LinearLayout linearLayoutsub = new LinearLayout(MyMainActivity.this);
        //设置LinerLayout属性
        linearLayoutsub.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        //设置排布方向
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);//方向为水平
        //设置背景
        linearLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));//设置蓝色
        linearLayout.addView(linearLayoutsub);//将子布局添加到付布局里面

        //创建TextView 添加到导航栏
        TextView textView = new TextView(MyMainActivity.this);
        //将内容设置成“重庆”
        textView.setText(getResources().getString(R.string.chongqing));
        //设置宽高
        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                                                    LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(textLayoutParams);//给TextView设置布局
        //给TextView放图片
        Drawable rigth = getResources().getDrawable(R.mipmap.ic_qq);
        rigth.setBounds(0,0,10,10);
         textView.setCompoundDrawables(null,null,rigth,null);//在TextView的右边设置图片
        textView.setPadding(0,0,10,10);//设置TextView内间距
        linearLayoutsub.addView(textView);//将TextView控件放到导航栏里

        //创建EditText添加到导航栏
        EditText editText = new EditText(MyMainActivity.this);
        //将内容设置成“重庆”
        editText.setHint(getResources().getString(R.string.tishi));
        //设置宽高
        LinearLayout.LayoutParams editLayoutParams = new LinearLayout.LayoutParams(0,
                                            LinearLayout.LayoutParams.WRAP_CONTENT,1);
        textView.setLayoutParams(editLayoutParams);//给TextView设置布局
        //给TextView放图片
        Drawable left = getResources().getDrawable(R.mipmap.ic_search_textbox_normal);
        rigth.setBounds(0,0,10,10);
        textView.setCompoundDrawables(left,null,null,null);//在TextView的右边设置图片
        textView.setPadding(10,10,10,10);//设置TextView内间距
        linearLayoutsub.addView(editText);//将TextView控件放到导航栏里

        //创建TextView 添加到导航栏
        TextView textView1 = new TextView(MyMainActivity.this);
        //将内容设置成“重庆”
        textView.setText(getResources().getString(R.string.wode));
        //设置宽高
        LinearLayout.LayoutParams text1LayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(text1LayoutParams);//给TextView设置布局
        //给TextView放图片
        Drawable top = getResources().getDrawable(R.mipmap.ic_my);
        top.setBounds(0,0,10,10);
        textView1.setCompoundDrawables(null,top,null,null);//在TextView的右边设置图片
        textView1.setPadding(10,10,10,10);//设置TextView内间距
        linearLayoutsub.addView(textView1);//将TextView控件放到导航栏里
        setContentView(linearLayout);//将整个布局添加到Activity中
        //设置Drawable 必须用setBounds()


    }
}
