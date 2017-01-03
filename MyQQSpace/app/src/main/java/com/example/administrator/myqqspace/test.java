package com.example.administrator.myqqspace;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
public class test extends Activity {
    List<String> nameList = new ArrayList<String>();
    List<String> toNameList = new ArrayList<String>();
    List<String> contentList = new ArrayList<String>();
    String[] name ={"冉娱鑫","王鹏","李军明"};
    String[] toname={"杨松松","","罗大维"};;
    String[] content ={"你好呀","快点敲代码！","来搞基不来搞基不来搞基不来搞基不来搞基不来搞基不"};
    TextView textView;
    LinearLayout rootLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rootLinearLayout = (LinearLayout) findViewById(R.id.rootLinearLayout);

        for(int i= 0 ; i<name.length;i++){
            nameList.add(name[i]);
            toNameList.add(toname[i]);
            contentList.add(content[i]);
            textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            Setdata setdata = new Setdata(test.this,textView,nameList.get(i),toNameList.get(i),contentList.get(i));
            setdata.mSetdata();
            rootLinearLayout.addView(textView);
        }
    }
}
