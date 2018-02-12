Feature: TO test DELETE Request for the API

Scenario: Perform Delete Request to delete a playlist
Given Header is accepted for DELETE
When Delete request is made with the Playlist ID "/api/playlist/(id)"
Then Expected response code for this is 204
And Expected response body has "N/A"