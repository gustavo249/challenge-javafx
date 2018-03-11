package service_api;

import model.RepositoryList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubService {
    @GET("/search/repositories")
    Call<RepositoryList> listRepos(@Query("q") String language, @Query("sort") String sortBy, @Query("page") String page);

}

