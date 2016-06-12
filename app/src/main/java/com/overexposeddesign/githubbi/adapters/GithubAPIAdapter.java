package com.overexposeddesign.githubbi.adapters;

import com.overexposeddesign.githubbi.apis.GithubService;
import com.overexposeddesign.githubbi.model.SearchResults;
import rx.Observable;

//adapter returns observables that can be used asyncronously
public class GithubAPIAdapter {
    private GithubService gitHubService;


    public GithubAPIAdapter(){

        //instantiate a retrofit service we can query
        gitHubService = GithubService.retrofit.create(GithubService.class);
    }

    /**
     * Search Github for repositories by keyword
     */
    public Observable<SearchResults> getRepositories(String text){
        return (Observable<SearchResults>) gitHubService.getRepositories(text, "stars", "desc");
    }
}