
Feature: Login Verification
  Background:
    Given user open url "https://opensource-demo.orangehrmlive.com/"

  Scenario: Login with invalid credentials.
    When user enter username "FakeAdmin^&" in username field
    And  user enters password "1@!!abc" in the password field
    And user clicks "Login" button
    Then error message "Invalid credentials" is displayed

  Scenario: Login with valid credentials.
    When user enter username "Admin" in username field
    And  user enters password "admin123" in the password field
    And user clicks "Login" button
    Then user is redirected to Dashboard

