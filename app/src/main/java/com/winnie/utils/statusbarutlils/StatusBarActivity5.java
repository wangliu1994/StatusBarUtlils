package com.winnie.utils.statusbarutlils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * @author : winnie
 * @date : 2018/11/22
 * @desc
 */
public class StatusBarActivity5 extends AppCompatActivity {

    private ViewGroup mRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_bar5);

        //1、LAYOUT_FULLSCREEN：使状态栏出现的时候，不会重新调整activity的高度，状态栏覆盖在activity之上。
        //2、LAYOUT_FULLSCREEN 、LAYOUT_STABLE：让应用的主体内容占用系统状态栏的空间；
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        mRootView = findViewById(R.id.layout);

        mRootView.setPadding(mRootView.getPaddingLeft(),
                mRootView.getPaddingTop() + ScreenUtils.getStatusBarHeight(),
                mRootView.getPaddingRight(), mRootView.getPaddingBottom());
    }
}
