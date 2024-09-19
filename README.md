# Employee-Management-System (Spring-Boot)
## Project Overview
The Employee Management System is a RESTful API developed using Spring Boot for managing employees and departments. It supports CRUD operations for both employees and departments and implements a Many-to-One relationship between Employee and Department. Additionally, the API provides an endpoint to retrieve all employees belonging to a specific department.

## Features
* Employee Management: CRUD operations on employee records, including assigning them to departments.
* Department Management: CRUD operations on departments.
* Many-to-One Relationship: An employee belongs to one department, while a department can have multiple employees.
* Custom Exception Handling: Clear error messages for invalid requests.
* Get Employees by Department: Retrieve all employees under a specific department.
* Relational Database: Managed using JPA and Hibernate.

## Project Structure
* Controllers: Manage HTTP requests and responses.
* Services: Handle business logic.
* Repositories: Interact with the database using Spring Data JPA.
* Entities: Represent the data models for Employee and Department, including their relationships.
* Exception Handling: Custom exceptions for handling invalid input.

## Technologies Used
* Spring Boot: Backend framework.
* Java: Programming language.
* Spring Data JPA: ORM and database interaction.
* Hibernate: For managing data persistence.
* MySQL: Relational database system.
* Maven: For project build and dependency management.

## REST API Endpoints
### Employee Endpoints
* GET /employees: Fetch all employees.
* GET /employees/{id}: Fetch a specific employee by ID.
* POST /employees: Add a new employee and assign them to a department.
* PUT /employees/{id}: Update an employee’s details.
* DELETE /employees/{id}: Delete an employee by ID.
* GET /employees/department/{departmentId}: Fetch all employees by department ID.
### Department Endpoints
* GET /departments: Fetch all departments.
* GET /departments/{id}: Fetch a specific department by ID.
* POST /departments: Add a new department.
* PUT /departments/{id}: Update a department’s details.
* DELETE /departments/{id}: Delete a department by ID.

## Database Schema
### Employee Table
* ID: Primary Key
* Name: Employee's name
* Email: Employee's email address
* Department: Many-to-One relationship with the Department table
### Department Table
* ID: Primary Key
* Name: Department's name
* Employees: One-to-Many relationship with the Employee table
### Relationship
* Many-to-One: Each employee is assigned to one department.
* One-to-Many: A department can have multiple employees.
