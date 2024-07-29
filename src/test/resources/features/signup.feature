Feature: Sign Up

  In order to be able to buy items
  As a non-registered user of the website
  I want to be able to register as a user
  So that I can start purchasing items

  @Happy
  Scenario: Sign up with valid details
    Given I am on the sign up page
    When I enter sign up details with:
      | username      | standard_user          |
      | email         | monimak505@mfunza.com  |

    And I click the sign up button
    Then I should be redirected to enter account information page
    When I enter account information with:
      | title        | Mr.                  |
      | name         | fname                |
      | email        | monimak505@mfunza.com|
      | password     | test                 |
      | date_of_birth| 01/01/1990           |
      | newsletter     | true               |
      | offers         | true               |
      | first_name   | fname                |
      | last_name    | lname                |
      | address      | 123 ex st            |
      | country      | USA                  |
      | state        | fakestate            |
      | city         | fakecity             |
      | zipcode      | aa1 bb2              |
      | mobile_number| 1234567890           |

    And I click the create account button
    Then I should see the account created page with a welcome message