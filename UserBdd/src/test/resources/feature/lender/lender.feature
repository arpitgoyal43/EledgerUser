Feature: Test Lender Data API

  @tag1
  Scenario: POST API to create new Lender
    Given I want to hit Lender POST api     
    When I provide the Lender  
    Then Response code should return 201 status code

