package com.githubapiclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepository {
    private final String name;

    @JsonProperty(value = "branches_url", access = JsonProperty.Access.WRITE_ONLY)
    private String branchesUrl;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private boolean fork;

    private String ownerLogin;

    private  List<Branch> branches;

    public GithubRepository(String name, String ownerLogin, List<Branch> branches) {
        this.name = name;
        this.ownerLogin = ownerLogin;
        this.branches = branches;
    }

    @JsonProperty("owner")
    private void unpackOwner(Map<String, Object> owner) {
        ownerLogin = (String) owner.get("login");
    }
}
