package service_api;

import model.Repository;

import java.util.List;

public interface GithubClient {
    List<Repository> getPopularRepositories(int page);
}
