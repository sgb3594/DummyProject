 @ui @healthcheck
Feature: E-commerce Project Web Site Health Check

  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    Given User opened browser
    And User navigated to the home application url
    When User Search for product "Laptop"
    Then Search Result page is displayed
 
 
 
 @t
  Scenario: User is clicked on the Product and check the Product Details
    Given User opened browser
    And User navigated to the home application url
    And User search for product"Laptop"
    When User clicked on any Product
    Then Product description is displayed in new tab