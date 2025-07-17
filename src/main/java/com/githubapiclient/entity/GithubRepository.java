package com.githubapiclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {
    private final String name;

    @JsonProperty("branches_url")
    private final String branchesUrl;

    private final boolean fork;

    private String ownerLogin;

    @JsonProperty("owner")
    private void unpackOwner(Map<String, Object> owner) {
        ownerLogin = (String) owner.get("login");
    }

}
