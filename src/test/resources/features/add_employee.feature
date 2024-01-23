Feature: Add Employee Verification

  Background:
    Given user open url "https://opensource-demo.orangehrmlive.com/"
    When user enter username "Admin" in username field
    And  user enters password "admin123" in the password field
    And user clicks "Login" button
    Then user is redirected to Dashboard
    When user clicks on PIM option
    Then user is redirected to PIM page
    When user clicks on Add Employee option
    Then user is redirected to Add Employee page


  Scenario: Enter white space and verify warning message getting displayed

    And user enters white space in Firstname and LastName field
    Then "Required" warning message is displayed

  Scenario: Enter more than al,lowed characters and verify warning message getting displayed

    And user enters more than allowed characters in Firstname,MiddleName and LastName field
    Then "Should not exceed 30 characters" warning message is displayed


  Scenario: New Employee is added by entering valid values in the mandatory fields.

    And user enters "Appu","Anand","Padmanabhan" in the respective firstname,middlename and lastname field
    And clicks "Save" button
    Then "Successfully added" Successful message is displayed

