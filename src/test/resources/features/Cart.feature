Feature:

  Scenario: 4.1
    Given that I have not previously added any items to my basket,
    When I go to view the contents of my basket,
    Then it should be empty.

  Scenario: 4.2
    Given that I am on the products list page,
    When I click to add a product to the basket,
    Then 1 quantities of that item should be added to the basket.

  Scenario 4.3
    Given that there are items in my basket,
    When I click to remove an item from my basket,
    Then the item I removed should no longer be in my basket.

  Scenario 4.4
    Given that I am on a product view page,
    When I increase the quantity to 2,
    And click add to basket,
    Then 2 quantities of that item should be added to the basket.