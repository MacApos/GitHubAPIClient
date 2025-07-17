package com.githubapiclient.service;


import lombok.Data;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@Data
public class GithubRepoFetchService {
    private final RestTemplate restTemplate;
    private final String URL = "https://api.github.com/users/{username}/repos";

    public Map<String, List<String>> fetchReposByUsername(String username){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept", "application/vnd.github+json");
        httpHeaders.set("X-GitHub-Api-Version", "2022-11-28");

        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> exchange = restTemplate.exchange(URL, HttpMethod.GET, requestEntity, String.class, username);
        String body = exchange.getBody();

        return Map.of("username", List.of("test"));
    }

}
