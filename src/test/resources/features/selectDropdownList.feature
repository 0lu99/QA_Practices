Feature: Select dropdown list

  Scenario: Clicking on an item within a drop down list
    Given I launch Google Chrome
    When I go to the select dropdown list page
    And I click on a random day
    Then I see a message saying that random day has been selected
    And close the browser