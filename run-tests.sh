#!/bin/bash

echo "Running tests with Maven..."
mvn clean test

echo "Generating Allure report..."
allure generate allure-results --clean -o allure-report
