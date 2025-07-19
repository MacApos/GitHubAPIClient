package com.githubapiclient.controller;

import com.githubapiclient.model.ErrorResponseBody;
import com.githubapiclient.model.GithubRepository;
import com.githubapiclient.service.GithubRepositoryFetchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GithubRepositoryController {

    private final GithubRepositoryFetchService githubRepositoryFetchService;

    @RequestMapping("/{username}")
    public List<GithubRepository> getRepositories(@PathVariable String username) {
        return githubRepositoryFetchService.facade(username);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ErrorResponseBody handleException(HttpClientErrorException ex) {
        return new ErrorResponseBody(ex.getStatusCode().value(), "Profile for this username does not exist.");
    }

}