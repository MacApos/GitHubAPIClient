package com.githubapiclient.service;

import com.githubapiclient.entity.Branch;
import com.githubapiclient.entity.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GithubRepositoryFetchService {
    private final RestClient restClient;
    private final String BASE_URL = "https://api.github.com";

    private <T> T responseFactory(ParameterizedTypeReference<T> parameterizedTypeReference, String uri) {
        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(parameterizedTypeReference);
    }

    private List<GithubRepository> fetchRepositoriesByUsername(String username) {
        ParameterizedTypeReference<List<GithubRepository>> repositoryListTypeReference =
                new ParameterizedTypeReference<>() {
                };
//        List<GithubRepository> githubRepositories = restClientFactory(repositoryListTypeReference,BASE_URL + "/users/{username}/repos", username);
        List<GithubRepository> githubRepositories = responseFactory(repositoryListTypeReference,
                "http://localhost:8081/" + username);
        return githubRepositories == null ? List.of() :
                githubRepositories.stream().filter(repo -> !repo.isFork()).toList();
    }

    private List<Branch> fetchBranchesByUrl(String url) {
        ParameterizedTypeReference<List<Branch>> branchListTypeReference = new ParameterizedTypeReference<>() {
        };
        return responseFactory(branchListTypeReference, url.replace("{/branch}", ""));
    }

    public List<GithubRepository> facade(String username) {
        List<GithubRepository> githubRepositories = fetchRepositoriesByUsername(username);
        githubRepositories.forEach(repository -> repository.setBranches(
                        fetchBranchesByUrl(repository.getBranchesUrl())
                )
        );
        return githubRepositories;
    }

}
