package com.overexposeddesign.githubbi.adapters;

import com.overexposeddesign.githubbi.apis.GithubService;
import com.overexposeddesign.githubbi.model.SearchResults;
;
import rx.Observable;

public class GithubAPIAdapter {
    private GithubService gitHubService;

    public GithubAPIAdapter(){
        gitHubService = GithubService.retrofit.create(GithubService.class);

    }

    /**
     * Search Github for repositories by keyword
     * @param text
     */
    public Observable<SearchResults> getRepositories(String text){
        return (Observable<SearchResults>) gitHubService.getRepositories(text, "stars", "desc");
    }
}