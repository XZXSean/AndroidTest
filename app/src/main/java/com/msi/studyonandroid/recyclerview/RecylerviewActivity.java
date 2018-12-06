package com.msi.studyonandroid.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.msi.studyonandroid.R;

public class RecylerviewActivity extends AppCompatActivity {

    private Button btn_linear_rv;
    private Button btn_hor_rv;
    private Button btn_grid_rv;
    private Button btn_pu_rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recylerview);

        btn_linear_rv = findViewById(R.id.btn_linear_rv);
        btn_linear_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerviewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btn_hor_rv = findViewById(R.id.btn_hor_rv);
        btn_hor_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerviewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btn_grid_rv = findViewById(R.id.btn_grid_rv);
        btn_grid_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerviewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_pu_rv = findViewById(R.id.btn_pu_rv);
        btn_pu_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerviewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }
}
