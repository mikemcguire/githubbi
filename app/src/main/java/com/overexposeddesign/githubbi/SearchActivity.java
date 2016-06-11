package com.overexposeddesign.githubbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;
import android.widget.TextView;

import com.overexposeddesign.githubbi.apis.GitHubClient;


public class SearchActivity extends AppCompatActivity {
    //view
    private TextView mSearchInput;
    private ListView mRepositoryList;
    private GitHubClient mGithubClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //set view variables
        mSearchInput = (TextView) findViewById(R.id.searchInput);
        mRepositoryList = (ListView) findViewById(R.id.repositoryListView);

        mGithubClient = new GitHubClient();

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

                getData();
            }
        });
    }

    private void getData (){

        mGithubClient.listRepositories("linux");
    }
}
