# Sample web application with user sign up and login using Spring Boot and MySQL

A simple CRUD operation for user and auth mechanism application using Spring Boot with the following options:

- Spring JPA and MySQL for data persistence
- JWT auth token
- Authorization: Bearer system for authentication
- REST API for requests

To build and run the sample from a fresh clone of this repo:

## Configure MySQL

1. Create a database in your MySQL instance.
2. Update the application.properties file in the `src/main/resources` folder with the URL, username and password for your MySQL instance. The table schema for the app objects will be created for you in the database.
3. Create user with /user/signup endpoint.
4. Login user with /user/login endpoint.
5. Other endpoints need header Authorization: Bearer {{TOKEN}}

