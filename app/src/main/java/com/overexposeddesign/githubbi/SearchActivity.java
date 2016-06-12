package com.overexposeddesign.githubbi;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import com.overexposeddesign.githubbi.adapters.GithubAPIAdapter;
import com.overexposeddesign.githubbi.adapters.ResultsViewAdapter;
import com.overexposeddesign.githubbi.databinding.ActivitySearchBinding;
import com.overexposeddesign.githubbi.model.Repository;
import com.overexposeddesign.githubbi.model.SearchResults;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {
    private TextView mSearchInput;
    private GithubAPIAdapter mGithubAPIAdapter;
    private ActivitySearchBinding mBinding;
    private RecyclerView mResultsView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //setup data binding for this view
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        //set view variables
        mSearchInput = (TextView) findViewById(R.id.searchInput);
        mResultsView = (RecyclerView) findViewById(R.id.results);

        mGithubAPIAdapter = new GithubAPIAdapter();

        ResultsViewAdapter mResultsViewAdapter = new ResultsViewAdapter(new ArrayList<Repository>());
        mResultsView.setLayoutManager( new LinearLayoutManager(this));
        mResultsView.setAdapter(mResultsViewAdapter);
        initEvents();
    }


    /**
     * Initialize events for this Activity
     */
    public void initEvents(){

        //Handle text input for searchfield
        mSearchInput.addTextChangedListener(new TextWatcher() {
            private Timer timer=new Timer();
            private final long DELAY = 1000; // milliseconds

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                //wait till they are truly done
                timer.cancel();
                timer = new Timer();
                timer.schedule(
                        new TimerTask() {
                            @Override
                            public void run() {
                                //if done get text and search for it
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

        final SearchActivity self = this;

        //get an observable that contains or search results
        Observable<SearchResults> results = mGithubAPIAdapter.getRepositories(keyword);

        //wait for it
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

                    mBinding.setSearchResults(results);

                    ResultsViewAdapter mResultsViewAdapter = new ResultsViewAdapter(results.getItems());

                    mResultsView.setAdapter(mResultsViewAdapter);
                }
            });
    }
}
