package com.winnie.utils.statusbarutlils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * @author winnie
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void statusBar1(View view) {
        startActivity(new Intent(this, StatusBarActivity1.class));
    }

    public void statusBar2(View view) {
        startActivity(new Intent(this, StatusBarActivity2.class));
    }

    public void statusBar3(View view) {
        startActivity(new Intent(this, StatusBarActivity3.class));
    }
}
