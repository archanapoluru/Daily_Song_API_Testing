Feature: GET Request based on ID

Scenario: Perform GET Request to return a single video

Given Header is supplied
When GET Request is made to the API with id as "/api/video/5a80f5551dd285011f6b562f"
Then Expected status code is 200
And Artist expected is "Lady Gaga", and song is "Poker face"