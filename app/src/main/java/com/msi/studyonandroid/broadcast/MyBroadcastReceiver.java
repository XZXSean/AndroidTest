package com.msi.studyonandroid.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received in myBroadcaseReceiver",Toast.LENGTH_LONG).show();
        Log.i(TAG, "onReceive: ");
    }
}
