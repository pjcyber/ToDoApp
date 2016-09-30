package com.codepath.pborrayo.todoapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codepath.pborrayo.todoapp.alertdialog.CustomAlertDialog;
import com.codepath.pborrayo.todoapp.R;
import com.codepath.pborrayo.todoapp.model.Item;

import java.util.List;

/**
 * Created by pborrayo on 9/29/16.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private List<Item> items;
    private Context context;
    private int currentPosition;

    public RecyclerViewAdapter(List<Item> items) {
        this.items = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,  final int position) {
        holder.itemText.setText(items.get(position).itemText);
        holder.itemView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                new CustomAlertDialog().createAlertDialog(context, RecyclerViewAdapter.this, items
                    .get(position).itemText).show();
                currentPosition = position;
            }
        });

        holder.itemView.setOnLongClickListener(new OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                removeItem(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView itemText;

        public MyViewHolder(final View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.item_text);
        }
    }

    public void addItem(String info) {
        Item item = new Item(info);
        this.items.add(item);
        item.save();
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        Item item = items.get(position);
        items.remove(position);
        item.delete();
        notifyDataSetChanged();
    }

    public void updateItem(String info) {
        Item item = items.get(currentPosition);
        item.itemText = info;
        item.save();
        notifyDataSetChanged();
    }

}
