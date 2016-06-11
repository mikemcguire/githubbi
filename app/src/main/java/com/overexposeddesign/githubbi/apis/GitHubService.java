package com.overexposeddesign.githubbi.apis;

import com.overexposeddesign.githubbi.model.SearchResults;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GitHubService {
    @GET("/search/repositories")
    Call<SearchResults> getRepositories(@Query("q") String query, @Query("sort") String sort, @Query("order") String order);




    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
