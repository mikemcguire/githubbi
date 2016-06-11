package com.overexposeddesign.githubbi.adapters;

import android.util.Log;

import com.overexposeddesign.githubbi.apis.GitHubService;
import com.overexposeddesign.githubbi.model.Repository;
import com.overexposeddesign.githubbi.model.SearchResults;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubRepositoryAdapter {

    public GithubRepositoryAdapter(String text){
        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        final Call<SearchResults> call =
                gitHubService.getRepositories(text, "stars", "desc");

        call.enqueue(new Callback<SearchResults>() {
            @Override
            public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                Log.d("SEARCH STATUS:", response.body().toString());
                SearchResults searchResults = response.body();
                Repository[] results = searchResults.getItems();
                int count = Integer.parseInt(searchResults.getTotal_count());

                for (Repository result : results) {
                    // process each result
                    Log.d("RepoName", result.getName());
                }
            }
            @Override
            public void onFailure(Call<SearchResults> call, Throwable t) {
                Log.d("SEARCH STATUS", t.getMessage());
            }
        });
    }
}