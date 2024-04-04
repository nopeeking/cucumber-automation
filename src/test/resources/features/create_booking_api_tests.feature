Feature: Scenarios for create booking API

  Scenario Outline: Create more bookings and test HTTP response codes
    Given we have a booking request
      | firstname   | lastname   | additionalneeds   | depositpaid   | checkin   | checkout   | totalprice   |
      | <firstname> | <lastname> | <additionalneeds> | <depositpaid> | <checkin> | <checkout> | <totalprice> |

    When  we send the request to create booking api
    Then  HTTP response status code should be 200
    Examples:
      | firstname | lastname | additionalneeds | depositpaid | checkin    | checkout   | totalprice |
      | Penny     | Timothy  | mineral water   | true        | 2024-01-01 | 2024-02-01 | 555        |
      | Tommy     | Penny    | Breakfast       | false       | 2024-01-01 | 2024-02-01 | 600        |

  Scenario Outline: Create more bookings and test HTTP response codes with bad data
    Given we have a booking request
      | firstname   | lastname   | additionalneeds   | depositpaid   | checkin   | checkout   | totalprice   |
      | <firstname> | <lastname> | <additionalneeds> | <depositpaid> | <checkin> | <checkout> | <totalprice> |

    When  we send the request to create booking api
    Then  HTTP response should contain an error
    Examples:
      | firstname | lastname | additionalneeds | depositpaid | checkin    | checkout   | totalprice |
      | Penny     |          | mineral water   | true        | 2024-01-01 | 2024-02-01 | 555        |
      | Tommy     | Penny    | Breakfast       | false       |            | 2024-02-01 |            |
