Feature: Product Comparison
  Test the functionality to add and remove products from the compare product page

  Background:
    Given The user must be on the Home page "https://magento.softwaretestingboard.com/"

    Scenario: Verify if a user not logged in can add products to compare list
      Given The user identified "Radiant Tee" as their product of interest
      When the user hover over the "Radiant Tee" and clicks on the add to compare button
      Then a confirmation message, "You added product Radiant Tee to the comparison list." should be displayed
      And the "Radiant Tee" should be added in the compare products screen

  Scenario: Verify if a user not logged in can add products to compare list
    Given The user identified "Breathe-Easy Tank" as their product of interest
    When the user clicks on the "Breathe-Easy Tank" image
    And the user clicks Add to compare
    Then a confirmation message, "You added product Breathe-Easy Tank to the comparison list." should be displayed
    And the "Breathe-Easy Tank" should be added in the compare products screen

  Scenario: Verify if a user not logged in can remove a product from the compare list
    Given The user identified "Argus All-Weather Tank" as their product of interest
    When the user clicks on the "Argus All-Weather Tank" name
    And the user clicks Add to compare
    Then a confirmation message, "You added product Argus All-Weather Tank to the comparison list." should be displayed
    And the user clicks on the comparison list link from the confirmation message
    And the user clicks on the remove icon
    And the user select "OK" from the confirmation alert
    Then the "Argus All-Weather Tank" should be removed from the compare list