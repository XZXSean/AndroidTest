package com.msi.studyonandroid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.msi.studyonandroid.R;

public class HorRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView ruHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_recycler_view);
    }
}
