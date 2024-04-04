Feature: Test scenario for our sample API

  Scenario: Create a new student
    Given a new student has been created with the following request
      | name | id | email               |
      | john | 999| john@mailinaotr.com |
      | tom  | 777 | tom@mailinator.com |

  Scenario Outline: Create a new student
    Given a new student has been created with the following request
      | name    | id  | email   |
      | <name>  | <id>| <email> |
    Examples:
      | name   | id  | email               |
      | john   | test| john@mailinaotr.com |
      | tom    | 222 | tom@mailinator.com  |
      | jane22 | 333 | jan@mailinator.com  |
      | jane21 | 323 | jan-mailinator.com  |