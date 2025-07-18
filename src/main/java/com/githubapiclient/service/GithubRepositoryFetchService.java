package com.githubapiclient.service;

import com.githubapiclient.model.Branch;
import com.githubapiclient.model.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GithubRepositoryFetchService {

    private final GithubRepositoryClient githubRepositoryClient;
    private final String BASE_URL = "https://api.github.com";

    private List<GithubRepository> fetchRepositoriesByUsername(String username) {
        List<GithubRepository> githubRepositories = githubRepositoryClient.fetchByUri(
                new ParameterizedTypeReference<>() {},
                String.format("%s/users/%s/repos", BASE_URL, username)
        );
//        List<GithubRepository> githubRepositories = githubRepositoryClient.fetchByUri(
//                new ParameterizedTypeReference<>() {}, "http://localhost:8081/" + username);
        return githubRepositories == null ? List.of() :
                githubRepositories.stream().filter(repo -> !repo.isFork()).toList();
    }

    private List<Branch> fetchBranchesByUrl(String url) {
        return githubRepositoryClient.fetchByUri(
                new ParameterizedTypeReference<>() {},
                url.replace("{/branch}", "")
        );
    }

    public List<GithubRepository> facade(String username) {
        return fetchRepositoriesByUsername(username).stream()
                .map(repository -> {
                            repository.setBranches(fetchBranchesByUrl(repository.getBranchesUrl()));
                            return repository;
                        }
                ).toList();
    }

}
