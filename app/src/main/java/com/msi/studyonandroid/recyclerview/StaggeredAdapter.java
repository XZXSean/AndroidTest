package com.msi.studyonandroid.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.msi.studyonandroid.R;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.LinearViewHolder> {
    private Context context;
    public StaggeredAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i("xzx", "onCreateViewHolder: *************************: "+i);
        // 此处只用 inflate(int) 会出错
        // return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item));
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_staggered_item,viewGroup,false));
    }
    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder viewHolder, final int i) {
        Log.i("xzx", "onCreateViewHolder: *************************: "+i);
        if (0 == i % 3){
            viewHolder.imageView.setImageResource(R.drawable.ic_launcher_foreground);
        } else if (1 == i % 3){
            viewHolder.imageView.setImageResource(R.drawable.ic_launcher_background);
        } else {
             viewHolder.imageView.setImageResource(R.drawable.xiaohui);

        }



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"click " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView ;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_pu);
        }
    }
}
