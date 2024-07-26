Feature: Sign Up

  In order to be able to buy items
  As a non-registered user of the website
  I want to be able to register as a user
  So that I can start purchasing items

  @Happy
  Scenario: Sign up with valid details
    Given I am on the sign up page
    When I enter sign up details with username "standard_user" and email "monimak505@mfunza.com"
    And I click the sign up button
    Then I should be redirected to enter account information page
    When I enter account information with title, name "fname", email "monimak505@mfunza.com", password "test", date of birth, first name "fname", last name "lname", address "123 ex st", country, state "fakestate", zipcode "aa1 bb2" mobile number "1234567890"
    And I click the create account button
    Then I should see the account created page with a welcome message