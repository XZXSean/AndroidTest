package com.msi.studyonandroid.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.msi.studyonandroid.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {
    private Context context;
    public LinearAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 此处只用 inflate(int) 会出错
        // return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item));
        return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item,viewGroup,false));
    }
    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder viewHolder, final int i) {
        viewHolder.textView.setText("Hello World!");
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

        private TextView textView ;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title_ll);
        }
    }
}
