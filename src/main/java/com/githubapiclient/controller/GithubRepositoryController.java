package com.githubapiclient.controller;

import com.githubapiclient.entity.ErrorResponseBody;
import com.githubapiclient.service.GithubRepositoryFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class GithubRepositoryController {

    private final GithubRepositoryFetchService githubRepositoryFetchService;

    @RequestMapping("/{username}")
    public Map<String, List<String>> repository(@PathVariable String username) {
        return githubRepositoryFetchService.fetchReposByUsername(username);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.class)
    public ErrorResponseBody handleException(HttpClientErrorException ex) {
        return new ErrorResponseBody(ex.getStatusCode().value(), "no such repo");
    }

}