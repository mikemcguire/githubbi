package com.overexposeddesign.githubbi.apis;

import com.overexposeddesign.githubbi.model.SearchResults;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;
import rx.Observable;


public interface GithubService {
    @GET("/search/repositories")
    Observable<SearchResults> getRepositories(@Query("q") String query, @Query("sort") String sort, @Query("order") String order);

    @GET
    Observable<SearchResults> getRepositoriesPaginate(
            @Url String url
    );

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
