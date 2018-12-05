package com.msi.studyonandroid.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.msi.studyonandroid.R;


public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ListView listView2 = findViewById(R.id.listview_lv2);
        final String[] arr1 = {"aaa", "bbb", "ccc", "ddd", "eee", "fff"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,arr1);
        listView2.setAdapter(adapter1);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ListViewActivity.this, "item"+i+":"+arr1[i],Toast.LENGTH_LONG).show();
            }
        });


    }
}
