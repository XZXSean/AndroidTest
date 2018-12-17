package com.msi.studyonandroid.FilePersistence;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.msi.studyonandroid.R;

public class SharedPreferencesActivity extends AppCompatActivity {
    private static final String TAG = "SharedPreferencesActivi";
    private MyDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        Button savaData = findViewById(R.id.sava_data_sharedP);
        savaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("shareddata",MODE_PRIVATE).edit();
                editor.putString("name","Tom");
                editor.putInt("age",28);
                editor.putBoolean("married",false);
                editor.apply();
                Log.d(TAG, "onClick: savedata int sharedate");
            }
        });
        
        Button restoreData = findViewById(R.id.restore_data_sharedP);
        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("shareddata",MODE_PRIVATE);
                String name = preferences.getString("name","");
                int age = preferences.getInt("age",0);
                boolean married = preferences.getBoolean("married",false);
                Log.d(TAG, "onClick: name is "+name);
                Log.d(TAG, "onClick: age is "+age);
                Log.d(TAG, "onClick: married is "+married);
            }
        });

        databaseHelper = new MyDatabaseHelper(SharedPreferencesActivity.this,"BookStore.db",null,1);
        // Button createDataBase
        Button createDatabase = findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.getWritableDatabase();
            }
        });


        Button addData = findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
