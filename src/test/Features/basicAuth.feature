Feature: Basic auth login

  Scenario: Login into the web page using OAuth credentials
    Given I launch Google Chrome
    When I go to the basic auth web page
    And I enter the correct credentials
    Then I see the success message
    And close the browser
