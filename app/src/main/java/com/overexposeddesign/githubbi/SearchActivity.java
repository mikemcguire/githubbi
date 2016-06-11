package com.overexposeddesign.githubbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SearchActivity extends AppCompatActivity {
    //view
    private TextView searchInput;
    private ListView repositoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //set view variables
        searchInput = (TextView) findViewById(R.id.searchInput);
        repositoryList = (ListView) findViewById(R.id.repositoryListView);

        initEvents();
    }

    public void initEvents(){
        //Search Input event
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
