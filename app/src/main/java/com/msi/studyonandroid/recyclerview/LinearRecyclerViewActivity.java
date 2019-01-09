package com.msi.studyonandroid.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.msi.studyonandroid.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);

        rvMain = findViewById(R.id.rv_main);
        // set Manager
        rvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        // set Adapter
        LinearAdapter linearAdapter = new LinearAdapter(LinearRecyclerViewActivity.this);
        linearAdapter.setOnItemClickListener(new LinearAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(LinearRecyclerViewActivity.this,"click position = " + position,Toast.LENGTH_LONG).show();
            }
        });
        rvMain.setAdapter(linearAdapter);

    }

}
