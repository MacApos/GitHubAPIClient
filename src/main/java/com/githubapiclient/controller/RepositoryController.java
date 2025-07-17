package com.githubapiclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RepositoryController {

    @RequestMapping("/")
    public Map<String, List<String>> repository() {
        return Map.of("repositories", List.of("repo1","repo2"));
    }
}