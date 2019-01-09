package com.msi.studyonandroid.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.msi.studyonandroid.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> implements View.OnClickListener{
    private Context context;
    public LinearAdapter(Context context) {
        this.context = context;
    }


    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    private OnItemClickListener onItemClickListener;

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null){
            onItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    @NonNull
    @Override
    public LinearViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.i("xzx", "onCreateViewHolder: *************************: "+i);
        // 此处只用 inflate(int) 会出错
        // return new LinearViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_linear_item));
        View view = LayoutInflater.from(context).inflate(R.layout.layout_linear_item,viewGroup,false);
        view.setOnClickListener(this);
        return new LinearViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull LinearViewHolder viewHolder, final int i) {
        Log.i("xzx", "onCreateViewHolder: ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^: "+i);
        viewHolder.textView.setText("Hello World!");
        /*viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"click " + i, Toast.LENGTH_SHORT).show();
            }
        });*/
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemViewType(int position) {
        Log.i("xzx", "onCreateViewHolder: ################################: "+position);
        return super.getItemViewType(position);
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
