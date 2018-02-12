Feature: GET Request based on ID

Scenario: Perform GET Request to return a single video

Given Header is supplied
When GET Request is made to the API with id as "/api/video/(id)"
Then Expected status code is 200
And Artist expected is "Lady Gaga", and song is "Ed Sheeran"