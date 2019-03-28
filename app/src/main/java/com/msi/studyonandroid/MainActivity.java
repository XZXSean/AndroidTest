package com.msi.studyonandroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.msi.studyonandroid.FilePersistence.FilePersistenceActivity;
import com.msi.studyonandroid.FilePersistence.SharedPreferencesActivity;
import com.msi.studyonandroid.fragment.FragmentActivity;
import com.msi.studyonandroid.glide.GlideRVActivity;
import com.msi.studyonandroid.listview.ListViewActivity;
import com.msi.studyonandroid.musicplayer.MusicPlayerActivity;
import com.msi.studyonandroid.recyclerview.RecylerviewActivity;
import com.msi.studyonandroid.service.ServiceActivity;
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

    private Button sendBroadCast;
    private Button sendLocalBroadCast;

    private Button btn2FilePersistence;
    private Button btn2SharedPreferences;

    private Button btn2Service;
    private Button btn2MusicPlayer;

    private Button btn2Fragment;

    //    网络状态监测广播
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;

    // 本地广播
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;
    private IntentFilter intentFilter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        localBroadcastManager = LocalBroadcastManager.getInstance(this); // 获取本地广播实例

        btn2uiview = findViewById(R.id.btn2uiview);
        btn2login = findViewById(R.id.btn2login);
        btn2calculator = findViewById(R.id.btn2calculator);
        btn2listview = findViewById(R.id.btn2listview);
        btn2recyclerview = findViewById(R.id.btn2recyclerview);
        btn2glide = findViewById(R.id.btn2glide);
        sendBroadCast = findViewById(R.id.sendBroadcast);
        sendLocalBroadCast = findViewById(R.id.sendLocalBroadcast);
        btn2FilePersistence = findViewById(R.id.btn2FilePersistence);
        btn2SharedPreferences = findViewById(R.id.btn2SharedPreferences);
        btn2Service = findViewById(R.id.btn2service);
        btn2MusicPlayer = findViewById(R.id.btn2musicplayer);
        btn2Fragment = findViewById(R.id.btn2fragment);
        setOnClickListeners();

        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.com.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);

        // 本地广播监听
        intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.msi.studyonandroid.LOCAL_BROADCAST");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver,intentFilter2);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
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
        sendBroadCast.setOnClickListener(onclick);
        sendLocalBroadCast.setOnClickListener(onclick);
        btn2FilePersistence.setOnClickListener(onclick);
        btn2SharedPreferences.setOnClickListener(onclick);
        btn2Service.setOnClickListener(onclick);
        btn2MusicPlayer.setOnClickListener(onclick);
        btn2Fragment.setOnClickListener(onclick);
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
                case R.id.sendBroadcast:
                    intent = new Intent("com.msi.studyonandroid.broadcast.MY_BROADCAST");
                    intent.addFlags(0x01000000);
                    sendBroadcast(intent);
                    Log.i("sendBroadcast", "onClick: sendBroadcast");
                    break;
                case R.id.sendLocalBroadcast:
                    // 发送本地广播
                    intent = new Intent("com.msi.studyonandroid.LOCAL_BROADCAST");
                    localBroadcastManager.sendBroadcast(intent);
                    Log.i("LocalBoradcast", "onClick: sendlocalBroadcast");
                    break;
                case R.id.btn2FilePersistence:
                    intent = new Intent(MainActivity.this,FilePersistenceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2SharedPreferences:
                    intent = new Intent(MainActivity.this,SharedPreferencesActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2service:
                    intent = new Intent(MainActivity.this,ServiceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2musicplayer:
                    intent = new Intent(MainActivity.this,MusicPlayerActivity.class);
                    startActivity(intent);
                    break;
                case R.id.btn2fragment:
                    intent = new Intent(MainActivity.this, FragmentActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }



    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"Network changes",Toast.LENGTH_SHORT).show();
            Log.i("networkchangesReceiver", "onReceive: networkchangereciver");
        }
    }

    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context,"received local broadcast",Toast.LENGTH_LONG).show();
            Log.i("LocalBoradcast", "onReceive: local broadcast");
        }
    }


}
