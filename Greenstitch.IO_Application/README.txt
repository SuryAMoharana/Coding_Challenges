Prerequisites
To run the backend project locally, ensure that you have the following prerequisites installed on your machine:

Java Development Kit (JDK)
Apache Maven
MySQL database
Installation

Follow these steps to set up and run the backend project:

Clone the repository to your local machine.

git clone <repository-url>

Navigate to the project directory.

cd <project-directory>

Build the project using Maven.

mvn clean install

Run the project.

mvn spring-boot:run

The backend project will be up and running on http://localhost:8080.

API Endpoints
The backend project provides the following API endpoints for user authentication:

POST /api/auth/signin: Used for user authentication and generating a JSON Web Token (JWT). Requires valid credentials (username and password) in the request body.

POST /api/auth/signup: Used for user registration and creating a new user account. Requires user details (name, email, password) in the request body.

Ensure that you use an appropriate tool (e.g., Postman) to send requests to these endpoints.

Example body for sign up through postman 
{
    "name":"Surya Moharana",
    "email":"surya@gmail.com",
    "dob":"1994-08-22",
    "phone":"8984298555",
    "password":"Surya@1994",
    "roles":["admin"]
}

Example body for sign in through postman 
{
    "username":"Surya Moharana",
    "password":"Surya@1994"
}


Configuration
The backend project uses the following configuration:

Server Port: The project is configured to run on port 8080. If required, you can change the port in the application.properties file.

Database Configuration: Update the MySQL database connection details (URL, username, password) in the application.properties file.

Dependencies
The backend project utilizes the following dependencies:

Spring Boot: The core framework for developing Spring applications.
Spring Security: Provides authentication and authorization functionalities.
JSON Web Token (JWT): Used for secure authentication and generating tokens.
Spring Data JPA: Simplifies database operations and integrates with the data access layer.
MySQL Connector: Enables communication between the application and the MySQL database.
