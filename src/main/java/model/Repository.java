package model;


import lombok.Data;

@Data
public class Repository {
    private String name;
    private String description;
    private Author owner;
    private Integer stargazers_count;
    private Integer forks_count;
}
