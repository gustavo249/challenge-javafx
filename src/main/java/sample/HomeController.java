package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Repository;
import service.GitHubServiceGenerator;
import service.GithubClientImpl;
import service_api.GithubClient;

import java.util.List;

public class HomeController {

    private GithubClient githubClient;

    @FXML
    private Label repoName;

    public HomeController() {
        githubClient = new GithubClientImpl(new GitHubServiceGenerator());
    }

    @FXML
    private void initialize() {
        System.out.println("Initializing home controller");

        List<Repository> popularRepositories = githubClient.getPopularRepositories();

    }


    public void setRepoName(Label repoName) {
        this.repoName = repoName;
    }
}
