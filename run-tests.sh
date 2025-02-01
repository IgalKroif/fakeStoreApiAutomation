#!/bin/bash

# Run tests with Maven
echo "Running tests with Maven..."
mvn clean test

# Check if Maven test ran successfully
if [ $? -eq 0 ]; then
  # Generate Allure report
  echo "Generating Allure report..."
  allure serve target/allure-results
else
  echo "Maven tests failed. Skipping Allure report generation."
  exit 1
fi
