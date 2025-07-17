package com.githubapiclient.controller;

import com.githubapiclient.service.GithubRepoFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RepositoryController {

    private final GithubRepoFetchService githubRepoFetchService;

    @RequestMapping("/")
    public Map<String, List<String>> repository() {
        return githubRepoFetchService.fetchReposByUsername("MacApos");
    }
}