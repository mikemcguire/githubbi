package com.overexposeddesign.githubbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.overexposeddesign.githubbi.apis.GitHubService;
import com.overexposeddesign.githubbi.model.Repository;
import com.overexposeddesign.githubbi.model.SearchResults;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchActivity extends AppCompatActivity {
    //view
    private TextView mSearchInput;
    private ListView mRepositoryList;
    private SearchResults searchResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //set view variables
        mSearchInput = (TextView) findViewById(R.id.searchInput);
        mRepositoryList = (ListView) findViewById(R.id.repositoryListView);


        initEvents();

    }

    public void initEvents(){
        //Search Input event
        mSearchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {


                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                final Call<SearchResults> call =
                        gitHubService.getRepositories("linux", "stars", "desc");

                call.enqueue(new Callback<SearchResults>() {
                    @Override
                    public void onResponse(Call<SearchResults> call, Response<SearchResults> response) {
                        Log.d("SEARCH STATUS:", response.body().toString());
                        searchResults = response.body();
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
        });
    }


}
