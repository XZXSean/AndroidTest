package com.msi.studyonandroid.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.msi.studyonandroid.R;

import java.util.ArrayList;
import java.util.List;


public class ListViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // ArrayAdapter
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

        //
        ListView listView3 = findViewById(R.id.listview_lv3);
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(ListViewActivity.this,R.layout.fruit_item,fruitList);
        listView3.setAdapter(fruitAdapter);


    }

    private void initFruits(){
        for (int i = 0; i < 2; i++){
            Fruit apple = new Fruit("Apple", "This is apple",R.drawable.xiaohui);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana","This is banana",R.drawable.ic_launcher_background);
            fruitList.add(banana);
            Fruit pear = new Fruit("pear","This is pear",R.drawable.ic_launcher_foreground);
            fruitList.add(pear);
            Fruit cherry = new Fruit("cherry", "This is cherry",R.drawable.xiaohui);
            fruitList.add(cherry);

        }
    }
}
