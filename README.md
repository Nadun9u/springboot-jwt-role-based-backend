# Spring Boot JWT Role-Based Authentication Backend

This repository contains the backend implementation of a secure web application developed using Spring Boot. The project is designed following a layered architecture and provides RESTful APIs for user authentication, authorization, and application data management.

The backend uses JWT (JSON Web Token) for secure authentication and implements Role-Based Access Control (RBAC) to manage user permissions based on assigned roles. It ensures protected API access and secure communication between the frontend and backend.

## Technologies Used
- Java
- Spring Boot
- Spring Security
- JWT Authentication
- REST API
- MySQL
- Maven
- Hibernate / JPA

## Features
- User Registration & Login
- JWT Token-Based Authentication
- Role-Based Authorization (Admin/User)
- Secure REST API Endpoints
- CRUD Operations
- Exception Handling
- Database Integration with MySQL
- Layered Architecture (Controller → Service → Repository)

## Project Architecture
The backend follows a clean layered architecture for maintainability and scalability:

- Controller Layer – Handles API requests and responses
- Service Layer – Contains business logic
- Repository Layer – Manages database operations
- Security Layer – Handles JWT validation and authentication

## Security Implementation
- Spring Security configuration
- JWT token generation and validation
- Password encryption using BCrypt
- Protected routes based on user roles
- Authentication filter for request validation

## Purpose
This project demonstrates backend development skills using Spring Boot and showcases secure authentication, authorization, REST API creation, and database integration suitable for real-world enterprise applications.
