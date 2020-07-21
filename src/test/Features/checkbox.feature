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

    Scenario: Multiple Checkbox demo
      Given I launch Google Chrome
      When I go to the checkbox web page
      And I click the 'Check All' button
      Then all the checkboxes should be checked
      And the button name will be changed to 'Uncheck All'
      When I uncheck one of the checkboxes
      Then the 'Check All' button should appear again
      When I click the 'Uncheck All' button
      Then all the checkboxes should be unchecked
      And close the browser