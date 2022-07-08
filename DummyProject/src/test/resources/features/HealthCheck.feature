@ui @healthcheck
Feature: E-commerce Project Web Site Health Check

 Background: Navigation to the URL
  Given User navigated to the home application url

  #@SearchLaptop
  #Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    #Given User opened browser
    #And User navigated to the home application url
    #When User Search for product "Laptop"
    #Then Search Result page is displayed
#
    #
  #@t
  #Scenario: User is click on the Product and check the Product Details
    #Given User opened browser
    #And User navigated to the home application url
    #And User Search for product "Laptop"
    #When User click on any product
    #Then Product Description is displayed in new tab
    
    
    @SearchLaptop
  Scenario: User is able to Open the browser, navigate to the URL and Search for Product
    When User Search for product "Laptop"
    Then Search Result page is displayed

    @SerachAndOpen
  Scenario: User is click on the Product and check the Product Details
    And User Search for product "earphone"
    When User click on any product
    Then Product Description is displayed in new tab
   
   @SearchMultiProd 
  Scenario Outline: User is able to search multiple products
    When User Search for product "<product_name>"
    Then Search Result page is displayed
    Examples:
      |product_name|
      | laptop     |
      | earphone   |
      | computer   |
    
    