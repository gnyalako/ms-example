# ms-example

MS Example Service API

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project locally.

## Technology Stack

- Java JDK 1.8
- Spring Boot 2.1.2
- Spring JPA Repositories
- Spring Boot Web 
- Spring Boot Test
- Spring Boot Actuator
- Hibernate
- Tomcat
- H2

## Prerequisites

What things you need to install the software.

- Java JDK 1.8
- [Apache Maven 3.3](https://maven.apache.org/index.html)

## Setup Project

Checkout code from Git

```git clone https://github.com/gnyalako/ms-example.git```

## Build

Build project using maven

```mvn clean package```
## Run your application

Execute following command from command line

```java -jar target\ms-example-1.0.jar```
## Documentation

[Swagger API Documentation](http://localhost:8080/swagger-ui.html) can be viewed after launching the application.

```http://localhost:8080/swagger-ui.html```

## Test

Test the application using [Swagger API Documentation](http://localhost:8080/swagger-ui.html) URL

## Coding Standards
- Code coverage must be greater than 90%
- No high risk issues reported in sonarqube
