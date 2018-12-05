package com.msi.studyonandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.msi.studyonandroid.listview.ListViewActivity;
import com.msi.studyonandroid.uiview.CalculatorActivity;
import com.msi.studyonandroid.uiview.LoginActivity;
import com.msi.studyonandroid.uiview.UIViewActivity;

public class MainActivity extends AppCompatActivity {

    private Button btn2uiview;
    private Button btn2login;
    private Button btn2calculator;
    private Button btn2listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2uiview = findViewById(R.id.btn2uiview);
        btn2login = findViewById(R.id.btn2login);
        btn2calculator = findViewById(R.id.btn2calculator);
        btn2listview = findViewById(R.id.btn2listview);

        setOnClickListeners();
    }


    // 监听器
    private void setOnClickListeners() {
        Onclick onclick = new Onclick();

        btn2uiview.setOnClickListener(onclick);
        btn2login.setOnClickListener(onclick);
        btn2calculator.setOnClickListener(onclick);
        btn2listview.setOnClickListener(onclick);
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
            }
        }
    }
}
