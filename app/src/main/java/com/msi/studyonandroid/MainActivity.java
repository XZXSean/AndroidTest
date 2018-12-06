package com.msi.studyonandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.msi.studyonandroid.glide.GlideImageActivity;
import com.msi.studyonandroid.glide.GlideRVActivity;
import com.msi.studyonandroid.listview.ListViewActivity;
import com.msi.studyonandroid.recyclerview.RecylerviewActivity;
import com.msi.studyonandroid.uiview.CalculatorActivity;
import com.msi.studyonandroid.uiview.LoginActivity;
import com.msi.studyonandroid.uiview.UIViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn2uiview;
    private Button btn2login;
    private Button btn2calculator;
    private Button btn2listview;
    private Button btn2recyclerview;
    private Button btn2glide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2uiview = findViewById(R.id.btn2uiview);
        btn2login = findViewById(R.id.btn2login);
        btn2calculator = findViewById(R.id.btn2calculator);
        btn2listview = findViewById(R.id.btn2listview);
        btn2recyclerview = findViewById(R.id.btn2recyclerview);
        btn2glide = findViewById(R.id.btn2glide);


        setOnClickListeners();
    }


    // 监听器
    private void setOnClickListeners() {
        Onclick onclick = new Onclick();

        btn2uiview.setOnClickListener(onclick);
        btn2login.setOnClickListener(onclick);
        btn2calculator.setOnClickListener(onclick);
        btn2listview.setOnClickListener(onclick);
        btn2recyclerview.setOnClickListener(onclick);
        btn2glide.setOnClickListener(onclick);
    }

    private class Onclick implements View.OnClickListener {

        Intent intent = null;

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn2uiview:
                    intent = new Intent(MainActivity.this, UIViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2login:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2calculator:
                    intent = new Intent(MainActivity.this,CalculatorActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2recyclerview:
                    intent = new Intent(MainActivity.this,RecylerviewActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2glide:
                    intent = new Intent(MainActivity.this,GlideRVActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }
}
