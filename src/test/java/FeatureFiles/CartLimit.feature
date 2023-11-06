

  Feature: Cart Limit

    Scenario: Trying to add more than the limit items to the cart

      Given The user goes to HepsiBurada Website
      When  The user searches for Faber Castel köşeli kurşun kalem in the searc box
      And The user clicks on the first product that appears
      And The User selects 501 items from the product
      And The user confirms the message that 501 items have been added to the cart
      And The user then verifies if there are 501 items in the cart
      And The user changes the quantity of the product in the cart to 501 pieces
      Then The user confirms that products cannot be added to the cart with more than 500 items
