package com.example.administrator.myqqspace;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import view.NoScrollListView;

/**
 * Created by Administrator on 2016/12/15.
 */
public class NoMainActivity extends Activity {
    private NoScrollListView noScrollListView;

    /* --------- 数据源----------- */
    //记录回复说说用户的集合
    private ArrayList<String> name;
    //记录被回复说说用户的集合
    private ArrayList<String> toName;
    //记录评论内容的集合
    private ArrayList<String> content;

    /* --------- 适配器------------*/
    private CommentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noscroll_listview);

        noScrollListView = (NoScrollListView) findViewById(R.id.listview);

        name = new ArrayList<>();
        toName = new ArrayList<>();
        content = new ArrayList<>();

        //添加数据 ,Demo只添加5条评论
        name.add("白雪公主");
        toName.add("小矮人");
        content.add("你们好啊~");

        name.add("女巫");
        toName.add("白雪公主");
        content.add("我来杀你了~");

        name.add("小矮人");
        toName.add("白雪公主");
        content.add("白雪公主，早上好啊~");

        name.add("王子");
        toName.add("");//没有回复人是toname为空，不添加会有下标越界
        content.add("这条说说很有道理的样子啊~");

        name.add("国王");
        toName.add("");
        content.add("我很喜欢这条说说~");

        name.add("白雪公主");
        toName.add("王子");
        content.add("你也是XX的朋友啊？");

        adapter = new CommentAdapter(name,toName,content,this);
        noScrollListView.setAdapter(adapter);

    }
}
