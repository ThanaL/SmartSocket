package com.example.thanalabadi.new_one.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thanalabadi.new_one.R;
import com.example.thanalabadi.new_one.RecyclerAdapter;
import com.example.thanalabadi.new_one.config;

public class Recycler_fregment extends Fragment {

    public final static String ITEMS_COUNT_KEY = "Recycler_fregment$ItemsCount";

    public static Recycler_fregment createInstance(int itemsCount) {
        Recycler_fregment recyclerfregment = new Recycler_fregment();
        Bundle bundle = new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY, itemsCount);
        recyclerfregment.setArguments(bundle);
        return recyclerfregment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
                R.layout.fragment_part_three, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(config.names);
        recyclerView.setAdapter(recyclerAdapter);
                       recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /**private List<piece> createItemList() {
        List<piece> itemList = new ArrayList<>();
        Bundle bundle = getArguments();
        if(bundle!=null) {
            int itemsCount = bundle.getInt(ITEMS_COUNT_KEY);
            for (int i = 0; i < itemsCount; i++) {
                itemList.add("name " );
            }
        }
        return itemList;
    }*/
}
