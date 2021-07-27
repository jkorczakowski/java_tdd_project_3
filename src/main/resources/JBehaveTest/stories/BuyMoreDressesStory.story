Meta:

Narrative:
In order to buy more than one dress
As a user
I have to increase quantity

Scenario: Add quantity
Given A chrome browser
When I add item to cart
When I proceed to checkout
When I click on plus
Then I have two dresses in cart