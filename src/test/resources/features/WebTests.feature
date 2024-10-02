@WebTests
  Feature: Web Tests

    @BuyJunkFood
    Scenario: Buy junk food
      Given navigate to junk food website
      And insert password
      When click on enter
      Then verify welcome message is appear
      When click on catalog button
      And click on search button
      Then insert "Dropit Hamburger (QA Automation)" to search
      When result is appears
      And click on the result
      And verify you got to hamburger page
      Then add hamburgers to cart
      And verify cart is with '3' items
      Then click on search button
      And insert "Dropit Chips (QA Automation)" to search
      When result of chips is appears
      And click on the chips result
      And verify you got to chips page
      Then add chips to cart
      And verify cart is with '6' items
      When click on bag icon
      And click on check out button
      Then verify the price is correct
      When filing fields
      And click on pay now
      Then verify the order was received

    @BuyJunkFoodNegativeTest
    Scenario: Buy Junk Food Negative Test
      Given navigate to junk food website
      And insert password
      When click on enter
      When click on catalog button
      And click on search button
      Then insert "Dropit Hamburger (QA Automation)" to search
      And click on the result
      Then add one hamburgers to cart
      And add one chips to cart
      When click on bag icon
      And click on check out button
      Then add non valid email
      And add non valid card number
      When click on pay now
      Then verify error message appears
