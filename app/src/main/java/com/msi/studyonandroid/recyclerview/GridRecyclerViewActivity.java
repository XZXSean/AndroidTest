package com.msi.studyonandroid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.msi.studyonandroid.R;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rv_grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);

        rv_grid = findViewById(R.id.rv_grid);
        rv_grid.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        rv_grid.setAdapter(new GridAdapter(GridRecyclerViewActivity.this));
    }
}
