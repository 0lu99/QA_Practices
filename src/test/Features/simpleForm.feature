Feature: Simple form input

  Scenario: Single Input Field
    Given I launch Google Chrome
    When I go to the form page
    And I type in a message
    Then I should see my message outputted when I click show message
    And close the browser

  Scenario: Two Input Fields
    Given I launch Google Chrome
    When I go to the form page
    And I type in a message in a A and B
    Then I should see the total when I click Get Total
    And close the browser
