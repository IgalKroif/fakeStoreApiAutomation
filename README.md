# FakeStoreAPI Automation Project

This repository contains automated tests for the FakeStoreAPI using the RestAssured framework. It includes positive and negative tests, as well as integration with Allure reporting and Jenkins.

## Overview

The FakeStoreAPI Automation Project aims to automate testing of the FakeStoreAPI endpoints to ensure their functionality and reliability.

## Features

- **Positive Tests:** Validate the correct behavior of API endpoints under normal conditions.
- **Negative Tests:** Validate error handling and edge cases of API endpoints.
- **RestAssured Framework:** Utilizes RestAssured for making HTTP requests and validating responses.
- **JUnit 5:** Uses JUnit 5 for organizing and executing test cases.
- **Allure Reporting:** Generates detailed HTML reports using Allure for test execution results.
- **Jenkins Integration:** Executes tests automatically on Jenkins CI/CD pipelines and generates reports.

## API Base URL

The API is hosted at [https://fakestoreapi.com](https://fakestoreapi.com).

## Endpoints Tested

- **/carts:**
  - GET: Retrieves information about carts.
  - POST: Creates a new cart.
  - PUT: Updates an existing cart.
  - PATCH: Partially updates an existing cart.
  - DELETE: Deletes an existing cart.

- **/products:**
  - GET: Retrieves information about products.
  - POST: Creates a new product.
  - PUT: Updates an existing product.
  - PATCH: Partially updates an existing product.
  - DELETE: Deletes an existing product.



## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/your-username/fakeStoreAPI-automation.git
2. Set up your development environment with JDK, Maven, and any necessary IDE.
3. Install the required dependencies using Maven:
    cd fakeStoreAPI-automation
    mvn clean install
   
Running Tests
To run the tests locally, use the following Maven command:
    mvn test


Jenkins Integration
This project is integrated with Jenkins for continuous integration and deployment. Jenkins jobs are configured to run the tests automatically on each commit or at scheduled intervals. Jenkins generates test reports and publishes them for easy access.

Allure Reporting
Allure reports provide detailed information about test execution, including test results, durations, and error messages. To view the reports locally, run the following command after test execution:
    allure serve target/allure-results
