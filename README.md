# Spring Boot Auth JWT

Spring Boot Auth JWT is a Spring Boot application that provides APIs for user authentication using JWT (JSON Web Tokens).

## Features

- User authentication and authorization using JWT.
- Stateless authentication with no session management.
- Exclusion of specific endpoints from JWT token validation.
- CORS and CSRF protection configurations.
- Exception handling for unauthorized access.

## Requirements

- Java 17 or higher
- Maven
- PostgreSQL (for database storage, optional)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/korade-krushna/spring-boot-auth-jwt.git
    ```

2. Navigate to the project directory:

    ```bash
    cd spring-boot-auth-jwt
    ```

3. Build the project using Maven:

    ```bash
    mvn clean install
    ```

4. Run the application:

    ```bash
    java -jar target/spring-boot-auth-jwt.jar
    ```

## Configuration

The application configuration can be found in `src/main/resources/application.properties`.

## Usage

Once the application is running, you can access the following endpoints:

- `POST /api/users/login`: Endpoint for user authentication. Requires a JSON payload with username and password. Returns a JWT token upon successful authentication.
- `POST /api/users/signup`: Endpoint for user registration. Requires a JSON payload with username and password.
- Other endpoints: Secure endpoints that require a valid JWT token for access. The JWT token should be included in the Authorization header of the request as `Bearer <token>`.

## Contributing

Contributions are welcome! Feel free to open issues or pull requests for any improvements or bug fixes.
