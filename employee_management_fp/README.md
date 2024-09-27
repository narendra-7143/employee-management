
# Project Title
# Employee Management System
A Spring Boot application for managing employee data with CRUD (Create, Read, Update, Delete) operations on an SQL relational database.

## Description
This project is a RESTful web service that provides an API for managing employee records. It is built using Spring Boot and interacts with an SQL relational database to perform the CRUD operations.

## Features
- Add new employees
- Retrieve employee details
- Update existing employee data
- Delete employee records
- Search/filter employees based on various fields

## Prerequisites
Before running this application, ensure you have the following installed:
- Java 11 or higher
- Maven
- MySQL


## Setup Instructions
1. Clone the repository:
    ```bash
    git clone https://github.com/your-repo/employee-management-system.git
    ```

2. Navigate to the project directory:
    ```bash
    cd employee-management-system
    ```

3. Configure the `application.properties` file in the `src/main/resources/` folder to set up your database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/em_db
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    ```

4. Run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```

5. The API will be available at:
    ```
    http://localhost:8080/api/v1/employees
    ```


## API Endpoints

- **GET /api/v1/employees**: Get all employees
- **GET /api/v1/employees/{id}**: Get employee by ID
- **POST /api/v1/employees**: Add a new employee
- **PUT /api/v1/employees/{id}**: Update employee by ID
- **DELETE /api/v1/employees/{id}**: Delete employee by ID
- **PATCH /api/v1/employees/id/{id}/status/{status}**: Update employee status 
