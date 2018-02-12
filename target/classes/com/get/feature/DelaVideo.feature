Feature: TO test DELETE Request to the API



Scenario: Perform Delete Request to delete a video

Given Header is supplied for DELETE
When Delete request is made with the "/api/video/(id)"
Then Expected response code is 204
And Expected response body is "N/A"


