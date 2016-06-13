package com.overexposeddesign.githubbi.adapters;

import android.content.Intent;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.overexposeddesign.githubbi.ActivityWeb;
import com.overexposeddesign.githubbi.R;
import com.overexposeddesign.githubbi.databinding.RepositoryListItemBinding;
import com.overexposeddesign.githubbi.model.Repository;


import java.util.ArrayList;


public class ResultsViewAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {

    private ArrayList<Repository> items;

    public ResultsViewAdapter(ArrayList<Repository> data){
        super();
        items = data;


    }


    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ResultsViewAdapter self = this;
        RepositoryListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.repository_list_item, parent, true);

        binding.getRoot().findViewById(R.id.repository_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "happened");
                Intent intent = new Intent(view.getContext() ,ActivityWeb.class);
                intent.putExtra("url", view.getTag().toString());
                view.getContext().startActivity(intent);
            }
        });

        return new RepositoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RepositoryViewHolder holder, int position) {
        holder.bindConnection(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
