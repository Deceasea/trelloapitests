Getting Started
Before running the tests, you need to obtain the API key and token. Follow the instructions in the https://developer.atlassian.com/cloud/trello/guides/rest-api/api-introduction/ guide to get your API key and token.

Description
The Trello API is extensively used to manage boards, cards, and other elements in Trello. The API offers a variety of endpoints to perform actions such as creating boards, cards, and tags.

API Documentation
Refer to the Trello API Documentation ( https://developer.atlassian.com/cloud/trello/rest/ ) for detailed information about available endpoints, request and response formats, and authentication.

Scenarios
1. Create Board
   Write a test to create a Trello board using the API. Ensure that the board is successfully created, and validate the response.

2. Create Tag for Board
   Implement a test to create a tag (label) for a Trello board. Verify that the tag is added to the board and check the response.

3. Create Card
   Develop a test case to create a Trello card within a specific board. Confirm that the card is created successfully and validate the response.

Running the Tests
Clone the repository to your local machine.
Open the project in your preferred Java IDE.
Provide your API key and token in the test files.
Run the test scenarios.
Test Environment
Java
JUnit
RestAssured for API testing
Allure for reporting
This project uses Allure for test reporting. After running the tests, generate the Allure report using the following commands:

mvn clean test
mvn allure:report

This will open the Allure report in your default web browser.

Author
Irina Veselova