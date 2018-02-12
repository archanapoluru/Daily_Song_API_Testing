Feature: Testing  POST method of Song API

Scenario: Test POST method to create a video

Given Header is provided

When Artist as "Lady Gaga",song as "Poker face", publishdate as "2017-09-01" and uri as "/api/video/"
Then Expected Status code "201" should be returned

And Response body should have artist as "Lady Gaga", song as "Poker face"
