package com.githubapiclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.githubapiclient.model.GithubRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class GithubRepositoryControllerTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("classpath:response.json")
    private Resource resourceFile;

    @Test
    void getRepositories() throws IOException {
        // given
        List<GithubRepository> expectedRepositories = objectMapper.readValue(
                resourceFile.getInputStream(), new TypeReference<>() {});

        // when
        ResponseEntity<List<GithubRepository>> responseEntity = restTemplate.exchange(
                "/MacApos", HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
        List<GithubRepository> repositories = responseEntity.getBody();

        // then
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(repositories).isNotNull();
        assertThat(expectedRepositories).allMatch(repository -> !repository.isFork());
        assertThat(expectedRepositories).hasSameElementsAs(repositories);

    }
}
