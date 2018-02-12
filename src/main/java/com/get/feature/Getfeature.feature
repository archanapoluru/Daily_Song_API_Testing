Feature: GET Request functionality

Scenario: GET request to return a list of videos

Given Headers are supplied
When GET Request is made to the API with "/api/video"
Then Expected status code is "200"
And Artists expected are "Lady Gaga", and "Ed Sheeran"


