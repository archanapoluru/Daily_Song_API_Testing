Feature: Test POST method of Song API

Scenario: Test POST method to create a playlist

Given Accept the content in JSON format

When POST request is performed with desc as "Top 40 playlist.", title as "Top 40" and uri as "/api/playlist"
Then Expected Status code "201" should return

And Response body should have descrition as "Top 40 playlist.", title as "Top 40"
