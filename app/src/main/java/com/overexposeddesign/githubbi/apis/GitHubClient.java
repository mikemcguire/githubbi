package com.overexposeddesign.githubbi.apis;

import com.overexposeddesign.githubbi.model.GithubRepository;
import java.util.List;
import retrofit.GsonConverterFactory;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

public class GitHubClient {
    private GitHubServiceInterface mService;
    private static final String BASE_URL = "https://api.github.com/";

    public GitHubClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mService = retrofit.create(GitHubServiceInterface.class);
    }
    public interface GitHubServiceInterface {
        @GET("/search/repositories")
        Call<List<GithubRepository>> getRepositories(@Query("q") String query, @Query("sort") String sort, @Query("order") String order);
    }
    public void listRepositories(String keywords) {
        mService.getRepositories("linux", "stars", "DESC").enqueue(new Callback<List<GithubRepository>>() {
            @Override public void onResponse(Response<List<GithubRepository>> response, Retrofit retrofit) {
                System.out.println("[DEBUG]" + " RestApi onResponse Number of repositories- " +response.body().size());
            }

            @Override public void onFailure(Throwable t) {
                System.out.println("[DEBUG]" + " RestApi onFailure - " + "");
            }
        });
    }
}
