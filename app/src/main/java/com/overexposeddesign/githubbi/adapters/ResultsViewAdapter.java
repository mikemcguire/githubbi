package com.overexposeddesign.githubbi.adapters;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.overexposeddesign.githubbi.R;
import com.overexposeddesign.githubbi.databinding.RepositoryListItemBinding;
import com.overexposeddesign.githubbi.model.Repository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ResultsViewAdapter extends RecyclerView.Adapter<RepositoryViewHolder> {

    private ArrayList<Repository> items;

    public ResultsViewAdapter(ArrayList<Repository> data){
        super();
        items = data;

    }

    @Override
    public RepositoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RepositoryListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.repository_list_item, parent, true);
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
