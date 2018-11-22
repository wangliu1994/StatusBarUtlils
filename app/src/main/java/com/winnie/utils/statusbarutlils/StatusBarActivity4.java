package com.winnie.utils.statusbarutlils;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author : winnie
 * @date : 2018/11/22
 * @desc
 */
public class StatusBarActivity4 extends AppCompatActivity {

    private ViewGroup mRootView;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar4);

        mRootView = findViewById(R.id.layout);
        mTextView = findViewById(R.id.title);

        //1.0 设置内容与底部的边距
        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) mRootView.getLayoutParams();
        if(params == null){
            params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT);
        }
        params.setMargins(params.leftMargin, params.topMargin, params.rightMargin,
                params.bottomMargin + ScreenUtils.getNavigationBarHeight());
        mRootView.setLayoutParams(params);

        //2.0 填充底部颜色
        View bottomView = new View(this);
        bottomView.setBackgroundColor(Color.BLACK);
        FrameLayout.LayoutParams params1 = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                ScreenUtils.getNavigationBarHeight(), Gravity.BOTTOM);
        ViewGroup decorView = (ViewGroup) getWindow().getDecorView();
        decorView.addView(bottomView, params1);

        //3.0设置内容与顶部的边距
        mRootView.setPadding(mRootView.getPaddingLeft(),
                mRootView.getPaddingTop() + ScreenUtils.getStatusBarHeight(),
                mRootView.getPaddingRight(), mRootView.getPaddingBottom());
    }
}
