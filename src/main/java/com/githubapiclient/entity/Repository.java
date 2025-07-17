package com.githubapiclient.entity;

import java.util.List;

public record Repository(String name, String owner, List<Branch> branches) {
}
