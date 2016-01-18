package com.example.priyasindkar.foldaleviewdemo;

/**
 * Created by priyasindkar on 18-01-2016.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FlipAdapter extends BaseAdapter {
    int[] images = new int[]{R.drawable.books, /*R.drawable.images, R.drawable.android,*/ R.drawable.android2};


    static class Item {
        static long id = 0;

        long mId;

        public Item() {
            mId = id++;
        }

        long getId() {
            return mId;
        }
    }

    private LayoutInflater inflater;

    private List<Item> items = new ArrayList<Item>();

    public FlipAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        for (int i = 0; i < 2; i++) {
            items.add(new Item());
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.page, parent, false);

            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.image = (ImageView) convertView.findViewById(R.id.image);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.text.setText(String.valueOf(position));
        holder.image.setImageResource(images[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView text;
        ImageView image;
        Button firstPage;
        Button lastPage;
    }

    /*@Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.first_page:
                if(callback != null){
                    callback.onPageRequested(0);
                }
                break;
            case R.id.last_page:
                if(callback != null){
                    callback.onPageRequested(getCount()-1);
                }
                break;
        }
    }*/

    public void addItems(int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(new Item());
        }
        notifyDataSetChanged();
    }

    public void addItemsBefore(int amount) {
        for (int i = 0; i < amount; i++) {
            items.add(0, new Item());
        }
        notifyDataSetChanged();
    }
}
