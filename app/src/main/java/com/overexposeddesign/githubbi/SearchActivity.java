package com.overexposeddesign.githubbi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.overexposeddesign.githubbi.adapters.GithubAPIAdapter;
import com.overexposeddesign.githubbi.model.SearchResults;

import java.util.Timer;
import java.util.TimerTask;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
    //view
    private TextView mSearchInput;
    private GithubAPIAdapter mGithubAPIAdapter;
    private ListView mRepositoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //set view variables
        mSearchInput = (TextView) findViewById(R.id.searchInput);
        mRepositoryList = (ListView) findViewById(R.id.repositoryListView);
        mGithubAPIAdapter = new GithubAPIAdapter();

        initEvents();
    }


    /**
     * Initialize events for this Activity
     */
    public void initEvents(){
        //Search Input event
        mSearchInput.addTextChangedListener(new TextWatcher() {
            private Timer timer=new Timer();
            private final long DELAY = 1000; // milliseconds

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            /**
             * Wait for user to complete typing and then load our data.
             */
            @Override
            public void afterTextChanged(Editable s) {
                timer.cancel();
                timer = new Timer();
                timer.schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                String keyword = mSearchInput.getText().toString();
                                search(keyword);
                            }
                        },
                        DELAY
                );
            }
        });
    }


    public void search(String keyword){
        Observable<SearchResults> results = mGithubAPIAdapter.getRepositories(keyword);
        results.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SearchResults>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onNext(SearchResults results) {
                        Log.d("test", results.getTotal_count());
                    }
                });
    }
}
