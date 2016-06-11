package com.overexposeddesign.githubbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ListView;
import android.widget.TextView;

import com.overexposeddesign.githubbi.adapters.GithubRepositoryAdapter;
import com.overexposeddesign.githubbi.model.SearchResults;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


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
            private Timer timer=new Timer();
            private final long DELAY = 2000; // milliseconds

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                timer.cancel();
                timer = new Timer();
                timer.schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                // TODO: do what you need here (refresh list)
                               new GithubRepositoryAdapter( String.valueOf( mSearchInput.getText() ) );
                            }
                        },
                        DELAY
                );
            }
        });
    }


}
