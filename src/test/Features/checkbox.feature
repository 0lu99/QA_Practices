Feature: Checkbox

  Scenario: Checking a checkbox will display a success message
    Given I launch Google Chrome
    When I go to the checkbox web page
    And I check the single checkbox
    Then I see the checkbox success message
    And close the browser

  Scenario: Unchecking a checkbox will remove the success message
    Given I launch Google Chrome
    When I go to the checkbox web page
    And I check the single checkbox
    When I uncheck the single checkbox
    Then the checkbox success message will no longer be present
    And close the browser