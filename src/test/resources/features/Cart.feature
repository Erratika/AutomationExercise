Feature: Basket
  As a user I should be able to add and remove items from my basket.

  @HappyPath
  Scenario: That basket is empty.
    Given when i am on the home page,
    When I go to view the contents of my cart from nav,
    Then it should be empty.

  @HappyPath
  Scenario: Add a product to the basket from products list page.
    Given that I am on the products list page,
    When I click to add a product "Men Tshirt" to the cart,
    And I go to view the contents of my cart,
    Then 1 quantities of product "Men Tshirt" should be added to the cart.

  @HappyPath
  Scenario: That I can remove items from my basket.
    Given that item "Men Tshirt" is in my cart,
    When I go to view the contents of my cart,
    And I click to remove item "Men Tshirt" from my cart,
    Then the item "Men Tshirt" should no longer be in my cart.

  @HappyPath
  Scenario: Add multiple quantities of items from product details page.
    Given that I am on a product view page for product "Men Tshirt",
    And I increase the quantity to 2,
    And click add to cart,
    When I go to view the contents of my cart,
    Then 2 quantities of product "Men Tshirt" should be added to the cart.