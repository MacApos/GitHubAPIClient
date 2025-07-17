package com.githubapiclient.controller;

@RestController
@RequiredArgsConstructor
public class RepositoryController {

    @RequestMapping("/repository")
    public String repository() {
        return "";
    }
}