Feature: Basket
  As a user I should be able to add and remove items from my basket.

  Scenario: That basket is empty.
    Given that there are no items in my cart,
    When I go to view the contents of my cart,
    Then it should be empty.

  Scenario: Add a product to the basket from products list page.
    Given that I am on the products list page,
    When I click to add a product to the cart,
    Then 1 quantities of that item should be added to the cart.

  Scenario: That I can remove items from my basket.
    Given that there are items in my cart,
    When I click to remove an item from my cart,
    Then the item I removed should no longer be in my cart.

  Scenario: Add multiple quantities of items from product details page.
    Given that I am on a product view page,
    When I increase the quantity to 2,
    And click add to cart,
    Then 2 quantities of that item should be added to the cart.