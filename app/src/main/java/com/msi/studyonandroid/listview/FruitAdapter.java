package com.msi.studyonandroid.listview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.msi.studyonandroid.R;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // 获取当前实例
        Fruit fruit = getItem(position);
        View view;  // 加载好的布局加入缓存，不需要重新加载
        ViewHolder viewHolder;  // 不需要重复进行获取控件实例
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.fruit_image);
            viewHolder.fruitInfo = view.findViewById(R.id.fruit_info);
            viewHolder.fruitName = view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);    // 将viewHolder存储在VIew中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
//        ImageView fruitImage = view.findViewById(R.id.fruit_image);
//        TextView fruitName = view.findViewById(R.id.fruit_name);
//        TextView fruitInfo = view.findViewById(R.id.fruit_info);
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        viewHolder.fruitInfo.setText(fruit.getInfo());
        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        TextView fruitInfo;
    }

}
