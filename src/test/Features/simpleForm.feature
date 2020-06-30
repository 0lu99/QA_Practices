Feature: Simple form input

  Scenario: Typing a message into a form and expecting the message output

    Given I launch Google Chrome
    When I go to the form page
    And I type in a message and click show message
    Then I should see my messaged outputted
    And close the browser