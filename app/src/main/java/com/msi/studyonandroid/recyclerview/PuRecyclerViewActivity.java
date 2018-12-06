package com.msi.studyonandroid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.msi.studyonandroid.R;

public class PuRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv_pu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        rv_pu = findViewById(R.id.rv_pu);
        rv_pu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        rv_pu.setAdapter(new StaggeredAdapter(PuRecyclerViewActivity.this));
    }
}
