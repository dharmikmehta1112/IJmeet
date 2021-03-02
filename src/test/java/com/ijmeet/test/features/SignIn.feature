Feature: Verify Sign In page

  Background: Below some common steps
    Given User launch chrome browser
    When User opens URL "https://ijmeet.com/"
    Then Verify visibility of Sign In button
    Then Click on Sign In button
    Then Navigate to Sign In Page

  Scenario: Verify Sign In page fields
    Then Mouse hover on Email Address text box
    Then user enters email address "dharmikmehta@gmail.com"
    Then Mouse hover on Password text box
    Then user enters password "dharmik@21"
