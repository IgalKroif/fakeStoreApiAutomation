#!/bin/bash
set -e  # Exit script if any command fails

# Ensure script is executable
chmod +x run-tests.sh
./run-tests.sh         # Run tests

# Check if tests failed
if [ $? -ne 0 ]; then
    echo "❌ Tests failed! Exiting with error."
    exit 1
fi

echo "✅ Tests passed successfully."

# Set the correct Allure path
ALLURE_PATH="/var/jenkins_home/tools/ru.yandex.qatools.allure.jenkins.tools.AllureCommandlineInstallation/Allure/bin/allure"

# Check if Allure is installed
if [ ! -f "$ALLURE_PATH" ]; then
    echo "❌ ERROR: Allure not found at $ALLURE_PATH!"
    exit 1
fi

echo "📊 Generating Allure report..."
"$ALLURE_PATH" generate /var/jenkins_home/workspace/fakeStoreApi/TARGET/ALLURE-RESULTS -c -o /var/jenkins_home/workspace/fakeStoreApi/allure-report

echo "✅ Allure report generated successfully."
exit 0
