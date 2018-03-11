package service;

import model.Repository;
import model.RepositoryList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.Response;
import service_api.GitHubService;
import service_api.GithubClient;
import service_api.ServiceGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GithubClientImpl implements GithubClient {
    private static Logger LOGGER = LoggerFactory.getLogger(GithubClientImpl.class);
    private ServiceGenerator serviceGenerator;

    public GithubClientImpl(ServiceGenerator serviceGenerator) {
        this.serviceGenerator = serviceGenerator;
    }

    @Override
    public List<Repository> getPopularRepositories(int page) {
        GitHubService service = serviceGenerator.createService(GitHubService.class);

        Call<RepositoryList> getRequest = service.listRepos("language:Java", "stars", String.valueOf(page));
        List<Repository> repositories = new ArrayList<>();

        try {
            Response<RepositoryList> response = getRequest.execute();

            if (response.body() != null) {
                repositories = response.body().getItems();
            }

        } catch (IOException e) {
            LOGGER.error("Failed retrieving the repositories {}", e.getMessage());
            e.printStackTrace();
        }

        return repositories;
    }

    @Override
    public List<Repository> getPopularRepositories() {
        return getPopularRepositories(1);
    }
}
