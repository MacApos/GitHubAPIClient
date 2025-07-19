<!-- ABOUT THE PROJECT -->

## About The Project

This is a simple project for listing GitHub users repositories based on their usernames.

## Technologies

* Java 21
* Spring Boot 3.5
* Apache Maven 3.9

## Installation

Complete these steps in order to use the API.

1. Clone the repository
   ```sh
   git clone https://github.com/MacApos/GitHubAPIClient.git
   ```
2. Go to the project's main directory
   ```sh
   cd GitHubAPIClient
   ```
3. Run Spring Boot application
   ```sh
   ./mvnw spring-boot:run
   ```
4. Make a request
   ```sh
   curl -X GET http://localhost:8080/github_username
   ```

## Usage

After providing the username for an existing profile, the application will respond with a list, in JSON format,
containing all the user's public repository names, in the order they were created. The response body also includes the
owner login and all branch names for each repository as well as its last commit's SHA.

Example with author username:

![Image](https://github.com/user-attachments/assets/dd2f3d75-baa0-485f-8aa4-76ca477ec925)

<p align="right">(<a href="#about-the-project">back to top</a>)</p>