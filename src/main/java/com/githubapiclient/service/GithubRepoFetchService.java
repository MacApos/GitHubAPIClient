package com.githubapiclient.service;


import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@Data
public class GithubRepoFetchService {
    private final RestTemplate restTemplate;

    public Map<String, List<String>> fetchReposByUsername(){
        return Map.of("username", List.of(""));
    }

}
