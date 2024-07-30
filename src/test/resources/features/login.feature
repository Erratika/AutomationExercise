Feature: Sign In

  In order to access my account and purchase items
  As a registered user of the website
  I want to be able to sign in to my account
  So that I can start purchasing items

  @Happy
  Scenario: Sign in with valid credentials
    Given I am on the sign in page
    When I enter sign in details with:
      | email    | monimak505@mfunza.com |
      | password | test          |
    And I click the sign in button
    Then I should be redirected to the home page
    And I should see a welcome message with my username