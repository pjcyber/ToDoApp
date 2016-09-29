package com.codepath.pborrayo.todoapp.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.activeandroid.ActiveAndroid;
import com.codepath.pborrayo.todoapp.CustomAlertDialog;
import com.codepath.pborrayo.todoapp.model.Item;
import com.codepath.pborrayo.todoapp.R;
import com.codepath.pborrayo.todoapp.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pborrayo on 9/29/16.
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycle_view) RecyclerView recyclerView;
    @BindView(R.id.action_button) FloatingActionButton button;

    public List<Item> items;
    public RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ActiveAndroid.initialize(this);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        items = new ArrayList<>(Item.getAll());
        recyclerViewAdapter = new RecyclerViewAdapter(items);

        recyclerView.setAdapter(recyclerViewAdapter);

    }

    @OnClick(R.id.action_button)
    public void addItem() {
        CustomAlertDialog alertDialog = new CustomAlertDialog();
        alertDialog.createAlertDialog(this, recyclerViewAdapter, null).show();
    }

}
