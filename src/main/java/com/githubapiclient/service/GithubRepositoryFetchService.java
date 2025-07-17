package com.githubapiclient.service;

import com.githubapiclient.entity.GithubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GithubRepositoryFetchService {
    private final RestTemplate restTemplate;
    private final String URL = "https://api.github.com/users/{username}/repos";

    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/vnd.github+json");
        httpHeaders.set("X-GitHub-Api-Version", "2022-11-28");
        return httpHeaders;
    }

    public Map<String, List<String>> fetchReposByUsername(String username) {
        HttpEntity<Void> requestEntity = new HttpEntity<>(getHeaders());

        ParameterizedTypeReference<List<GithubRepository>> repositoryListTypeReference = new ParameterizedTypeReference<>() {
        };
        ResponseEntity<List<GithubRepository>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, requestEntity,
                repositoryListTypeReference, username);
        List<GithubRepository> list = responseEntity.getBody().stream().filter(repo -> !repo.isFork()).toList();

        return Map.of("username", List.of("test"));
    }

}
