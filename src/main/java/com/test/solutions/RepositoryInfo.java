package com.test.solutions;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class RepositoryInfo implements Serializable {

    private int id;
    private String name;
    private String description;
    private int stargazers_count;

    public RepositoryInfo() {
    }

    public RepositoryInfo(int id, String name, String description, int stargazers_count) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.stargazers_count = stargazers_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }
}
