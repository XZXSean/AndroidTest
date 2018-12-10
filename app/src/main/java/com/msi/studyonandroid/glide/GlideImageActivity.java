package com.msi.studyonandroid.glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.msi.studyonandroid.R;

public class GlideImageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_image);

        ImageView iv1 = findViewById(R.id.iv1_glide);
        ImageView iv2 = findViewById(R.id.iv2_glide);
        ImageView iv3 = findViewById(R.id.iv3_glide);
        ImageView iv4 = findViewById(R.id.iv4_glide);


        Glide.with(GlideImageActivity.this) // 网络图片
                .load("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg")
                .into(iv1);
        Glide.with(GlideImageActivity.this) // 本地图片
                .load(R.drawable.xiaohui)
                .into(iv2);
        // 占位图
        Glide.with(GlideImageActivity.this)
                .load("https://b-ssl.duitang.com/uploads/item/201703/24/20170324202328_uSt4M.jpeg")
                .placeholder(R.drawable.ic_launcher_foreground) // 图片加载出来前显示的图片
                .error(R.drawable.ic_launcher_background)   // 图片加载失败后显示的图片
                .into(iv3);
        // 缩略图
        Glide.with(GlideImageActivity.this)
                .load("http://pic28.photophoto.cn/20130818/0020033143720852_b.jpg")
                .thumbnail(0.02f)
                .into(iv4);

        
    }
}
