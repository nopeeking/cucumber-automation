@feature-tag @regression
Feature: Test cucumber test definitions

  @test-tag @bug @flaky @smoke
  Scenario Outline: Test sample cucumber scenario - Print Hello World
    Given I have a sample code to run
    When  I print <greeting>
    Then  I verify <greeting> is printed
    And   I will check if status code is <statusCode>
    Examples:
      | greeting      | statusCode |
      | "Hello World" | 200        |

  Scenario Outline: Test sample cucumber scenario - Print Hello World
    Given I have a sample code to run
    When  I print <secret>
    Then  I verify <secret> is printed
    And   I will check if status code is <status>
    Examples:
      | secret      | status |
      | "Hello World" | 200        |