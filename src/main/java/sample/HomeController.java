package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Repository;
import service.GitHubServiceGenerator;
import service.GithubClientImpl;
import service_api.GithubClient;

import java.util.List;

public class HomeController {

    private String starUrl = "/goldStar.png";
    private String forkUrl = "/logo.png";

    private GithubClient githubClient;

    @FXML
    private VBox vBox;

    public HomeController() {
        githubClient = new GithubClientImpl(new GitHubServiceGenerator());
    }

    @FXML
    private void initialize() {
        System.out.println("Initializing home controller");

        List<Repository> popularRepositories = githubClient.getPopularRepositories(1);

        for (Repository repository : popularRepositories) {

            BorderPane container = new BorderPane();
            container.setPrefHeight(76.0);
            container.setPrefWidth(523.0);
            
            Label repoName = new Label(repository.getName());
            repoName.setLayoutX(40.0);
            repoName.setLayoutY(6.0);

            Label description = new Label(repository.getDescription());
            description.setLayoutX(70.0);
            description.setLayoutY(38.0);



            ImageView starImage = new ImageView(starUrl);
            starImage.setFitHeight(25.0);
            starImage.setFitWidth(25.0);
            starImage.setLayoutX(2.0);
            starImage.setLayoutY(7.0);
            starImage.setPickOnBounds(true);
            starImage.setPreserveRatio(true);

            Label starLabel = new Label(repository.getStargazers_count().toString());

            ImageView forkImage = new ImageView(forkUrl);
            forkImage.setFitHeight(25.0);
            forkImage.setFitWidth(25.0);
            forkImage.setLayoutX(2.0);
            forkImage.setLayoutY(7.0);
            forkImage.setPickOnBounds(true);
            forkImage.setPreserveRatio(true);

            Label forkLabel = new Label(repository.getForks_count().toString());

            HBox numbersContainer = new HBox();

            numbersContainer.setLayoutX(140.0);
            numbersContainer.setLayoutY(18.0);
            numbersContainer.setPrefWidth(41.0);
            numbersContainer.setPrefHeight(235.0);

            numbersContainer.getChildren().addAll(starImage, starLabel, forkImage, forkLabel);

            VBox left = new VBox();
            left.getChildren().addAll(repoName, description, numbersContainer);

            container.setLeft(left);

            VBox right = new VBox();
            right.setLayoutX(175.0);
            right.setLayoutY(30.0);

            ImageView avatar = new ImageView(repository.getOwner().getAvatar_url());
            avatar.setFitHeight(53.0);
            avatar.setFitWidth(60.0);
            avatar.setPickOnBounds(true);
            avatar.setPreserveRatio(true);

            Label ownerLogin = new Label(repository.getOwner().getLogin());

            right.getChildren().addAll(avatar, ownerLogin);

            container.setRight(right);

            vBox.getChildren().add(container);
        }

    }
}
