#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the item from ecommerce website
  I want to use this template for my feature file

Background: 
	Given I landed on Ecommerce website
	
   @tag1
  Scenario Outline: Positive test of submitting order
    Given Logged in with username <name> and password <password>
    When  I add product <productname> to the cart
    And Checkout <productname> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples: 
      | name  				| password 		 | productname |
      | palak@abc.com | Password@123 | zara coat 3 |
    
