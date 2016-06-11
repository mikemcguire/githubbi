package com.overexposeddesign.githubbi.apis;


import com.overexposeddesign.githubbi.model.GIthubRepository;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class GitHubClient {

    public static GitHubService getGithubService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
        GitHubService service = retrofit.create(GitHubService.class);

        return service;
    }

    public interface GitHubService {
        @GET("/search/repositories")
        void getRepositories(@Query("sort") String sort, @Query("q") String query, @Query("order") String order, Callback<List<GIthubRepository>> callback);
    }
}
