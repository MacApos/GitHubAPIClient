<!-- ABOUT THE PROJECT -->

## About The Project

This is a simple project based on [GitHub REST API](https://docs.github.com/en/rest?apiVersion=2022-11-28) for listing
GitHub users repositories by their usernames.

## Technologies

* Java 21
* Spring Boot 3.5
* Apache Maven 3.9

## Installation

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
containing all the user's public repository names, which are not forks, in the order they were created. The response
body also includes the owner login and all branch names for each repository as well as its last commit's SHA.

Example with author username:
![Image](https://github.com/user-attachments/assets/50fa4fa7-73b8-4a76-89c0-aa18ba35208a)

When given a nonexistent profile username, the application will respond with a 404 status code and an appropriate
message:
![Image](https://github.com/user-attachments/assets/bf4f74de-7a31-4124-9ff1-cbcbe6aba52f)

## Contact

Email: maciejapostol98@gmail.com

<p align="right"><a href="#about-the-project">back to top</a></p>