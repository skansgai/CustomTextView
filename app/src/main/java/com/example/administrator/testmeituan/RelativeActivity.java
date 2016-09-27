package com.example.administrator.testmeituan;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/9/26.
 */
public class RelativeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout relativeLayout = new RelativeLayout(RelativeActivity.this);
        RelativeLayout.LayoutParams relativeLlayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(relativeLlayoutParams);
        relativeLayout.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        TextView textView_address = new TextView(RelativeActivity.this);
        textView_address.setId(R.id.text_address);
        RelativeLayout.LayoutParams textaddress_LayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textaddress_LayoutParams.setMargins(5,5,5,5);
        textaddress_LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textView_address.setLayoutParams(textaddress_LayoutParams);
        textView_address.setText(getResources().getString(R.string.chongqing));

        Drawable rightDrawable = getResources().getDrawable(R.mipmap.ic_qq);
        rightDrawable.setBounds(0,0,20,20);
        textView_address.setCompoundDrawables(null,null,rightDrawable,null);
        textView_address.setGravity(Gravity.CENTER);
        relativeLayout.addView(textView_address);

        TextView textView_mine = new TextView(RelativeActivity.this);
        textView_address.setId(R.id.text_mine);
        RelativeLayout.LayoutParams textmine_LayoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        textmine_LayoutParams.setMargins(5,5,5,5);
        textmine_LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        textView_mine.setLayoutParams(textmine_LayoutParams);
        textView_mine.setText(getResources().getString(R.string.wode));
        Drawable topDrawable = getResources().getDrawable(R.mipmap.ic_search_textbox_normal);
        topDrawable.setBounds(0,0,20,20);
        textView_mine.setCompoundDrawables(null,topDrawable,null,null);
        textView_mine.setGravity(Gravity.CENTER);
        relativeLayout.addView(textView_mine);

        EditText editText = new EditText(RelativeActivity.this);
        editText.setId(R.id.edit_view);
        RelativeLayout.LayoutParams editLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        editLayoutParams.setMargins(5,5,5,5);
        //editLayoutParams.addRule(textView_address.Ali,editText);
        setContentView(relativeLayout);
    }
}
