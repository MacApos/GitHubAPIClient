package com.githubapiclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Branch {
    private final String name;

    private String sha;

    public Branch(String name, String sha) {
        this.name = name;
        this.sha = sha;
    }

    @JsonProperty("commit")
    private void unpackOwner(Map<String, Object> commit) {
        sha = (String) commit.get("sha");
    }

    @JsonProperty("last-commit-sha")
    public String getSha() {
        return sha;
    }
}
