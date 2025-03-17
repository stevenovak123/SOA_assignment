# Activity-Service

Activity-Service as a part GW-2 of our SOA subject

## Project Setup

This project is built in Spring Boot java

### Pre-requisites for the project

- Java

- Maven

### Verify Java & Maven are installed

- `java -version`

- `mvn -version`

### Build the project (downloads dependencies)

- `mvn clean install`

### Clone the GitLab repository

- `git clone https://campus.cs.le.ac.uk/gitlab/soa/activity-service.git `

### Move into the project directory

- `cd activityservice`

### Configure Git (only needed once)

- `git config user.name "Your Name"`

- `git config user.email "your-university-email@example.com"`

### Set the default branch to 'main'

- `git branch -M main`

### Pull the latest updates

- `git pull origin main`

### Set up your personal branches

- `git checkout -b <your_name_branch>`

- `git push origin <your_name_branch>`

### Database

- To get the database up and running update the `spring.datasource.url=jdbc:mysql://localhost:3306/soa` in the `application.properties` file
- `/soa` is the schema name currently set. Accordingly update the port number to the MySQL service running on your system.

### Run the project by Running it as a Spring boot application

### NOTES

- Swagger is installed and can be accessed by `localhost:8080/swagger.html `

- Port number can be changed by accessing the `application.properties file`

## Project Structure

### entity

- Contains all the models of the project.

### repository

- Contains code that will access the database and carry out database operations.

### service

- Contains business logic code.

### controller

- contains the api routes and information about the api.

Controller -> Service -> Repository (Interface)
