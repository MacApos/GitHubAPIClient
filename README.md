<!-- ABOUT THE PROJECT -->

## About The Project

This is a simple project for listing GitHub users repositories based on their usernames.

### Technologies

* Java 21
* Spring Boot 3.5
* Apache Maven 3.9

## Installation

Complete these steps in order to use the API.

1. Clone the repository
   ```sh
   git clone https://github.com/MacApos/GitHubAPIClient.git
   ```
2. Go to project main directory
   ```sh
   cd GitHubAPIClient
   ```
3. Run Spring Boot application
   ```sh
   ./mvnw spring-boot:run
   ```
4. Change git remote url to avoid accidental pushes to base project
   ```sh
   git remote set-url origin github_username/repository_name
   git remote -v # confirm the changes
   ```

<p align="right">(<a href="#about-the-project">back to top</a>)</p>