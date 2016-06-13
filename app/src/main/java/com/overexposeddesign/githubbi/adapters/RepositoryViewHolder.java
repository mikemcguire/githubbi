package com.overexposeddesign.githubbi.adapters;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.overexposeddesign.githubbi.R;
import com.overexposeddesign.githubbi.databinding.RepositoryListItemBinding;
import com.overexposeddesign.githubbi.model.Owner;
import com.overexposeddesign.githubbi.model.Repository;
import com.squareup.picasso.Picasso;

public class RepositoryViewHolder extends RecyclerView.ViewHolder {

    private RepositoryListItemBinding binding;
    public RepositoryViewHolder(RepositoryListItemBinding _binding) {
        super(_binding.getRoot());
        binding = _binding;

    }

    public void bindConnection(Repository repository){
        Owner owner = repository.getOwner();
        binding.setRepository(repository);
        binding.setOwner(owner);

    }

}
