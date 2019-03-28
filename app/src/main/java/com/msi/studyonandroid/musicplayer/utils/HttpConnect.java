package com.msi.studyonandroid.musicplayer.utils;

import android.util.Log;

import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnect {
    private static final String TAG = "HttpConnect";

    private static final String BASE_URL = "https://api.bzqll.com/music/tencent/";
    private static final String KEY = "579621905";

    public class SearchType {
        public static final String SONG = "song";   // 音乐
        public static final String ALBUM = "album"; // 专辑
        public static final String LIST = "list";   // 歌单搜索
        public static final String MV = "mv";       // MV
        public static final String USER = "user";   // 用户
        public static final String LRC = "lrc";     // 歌词
    }

    public static void getSearch(String s, String type) {
        HttpConnect.getSearch(s, type, 100, 0);
    }

    public static void getSearch(String s, String type, int limit, int offset) {
        String path = BASE_URL + "search?key=" + KEY;
        path += "&s=" + s;
        path += "&type=" + type;
        path += "&limit=" + limit + "&offset=" + offset;
        Log.i(TAG, "getSearch(): url = " + path);
        final String finalPath = path;
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(finalPath);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(6000);
                    connection.connect();
                    if (connection.getResponseCode() == 200) {
                        Log.i(TAG, "connect success");
                        InputStream inputStream = connection.getInputStream();
                        Log.i(TAG, inputStream.toString());
                        //JSONObject responseJson = new JSONPar
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public static void getSongList(String id) {
        String path = BASE_URL + "songList?key=" + KEY;
        path += "&id=" + id;
        Log.i(TAG, "getSongList(): url = " + path);
        final String finalPath = path;
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(finalPath);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(6000);
                    connection.connect();
                    if (connection.getResponseCode() == 200) {
                        Log.i(TAG, "connect success");
                        InputStream inputStream = connection.getInputStream();
                        Log.i(TAG, inputStream.toString());
                        //JSONObject responseJson = new JSONPar
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

}
