package com.githubapiclient.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GithubRepositoryClient {

    private final RestClient restClient;

    public GithubRepositoryClient(RestClient.Builder builder) {
        this.restClient = builder
                .defaultHeader(HttpHeaders.ACCEPT, "application/vnd.github+json")
                .defaultHeader("X-GitHub-Api-Version", "2022-11-28")
                .build();
    }

    public <T> T fetchByUri(ParameterizedTypeReference<T> parameterizedTypeReference, String uri) {
        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(parameterizedTypeReference);
    }
}