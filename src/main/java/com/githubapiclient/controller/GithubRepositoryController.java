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
@RequestMapping("/repositories")
@RequiredArgsConstructor
public class GithubRepositoryController {

    private final GithubRepositoryFetchService githubRepositoryFetchService;

    @RequestMapping("/{username}")
    public List<GithubRepository> getRepositories(@PathVariable String username) {
        return githubRepositoryFetchService.fetchUserRepositoriesWithBranches(username);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    public ErrorResponseBody handleNotFoundException() {
        return new ErrorResponseBody(404, "Profile for this username does not exist.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @RequestMapping()
    public ErrorResponseBody handleEmpty() {
        return new ErrorResponseBody(400, "Empty profile username");
    }
}