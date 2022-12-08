@SmokeTest
Feature: Login function Test

@TC_123
Scenario: As a Luma application user, must do successful login with valid creadential
Given Open any browser
And go to application URL
When click sign button
And Put email
And put password
And click second signin button
Then Validate login was successful