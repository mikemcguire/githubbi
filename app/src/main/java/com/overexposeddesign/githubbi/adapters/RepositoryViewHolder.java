package com.overexposeddesign.githubbi.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.overexposeddesign.githubbi.databinding.RepositoryListItemBinding;
import com.overexposeddesign.githubbi.model.Repository;

public class RepositoryViewHolder extends RecyclerView.ViewHolder {

    private RepositoryListItemBinding binding;
    public RepositoryViewHolder(RepositoryListItemBinding _binding) {
        super(_binding.getRoot());
        binding = _binding;
    }

    public void bindConnection(Repository repository){
        binding.setRepository(repository);
    }
}
