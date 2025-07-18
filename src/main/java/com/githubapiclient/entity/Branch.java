package com.githubapiclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Branch {
    private final String name;

    private String commitSha;

    @JsonProperty("commit")
    private void unpackOwner(Map<String, Object> commit) {
        commitSha = (String) commit.get("sha");
    }
}
