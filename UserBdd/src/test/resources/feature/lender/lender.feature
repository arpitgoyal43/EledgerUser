Feature: Test Lender Data API

  @post_lenders
  Scenario: POST API to create new Lender
    Given I want to hit Lender POST api
    When I provide the Lender
    Then Response code should return 201 status code

  @get_list_of_lenders
  Scenario: Get Lenders list
    Given I perform GET for list of lenders
    When I have url for 'lenders'
    Then Response status should be '200'

  @get_lender_by_userId
  Scenario: Get Lender by User Id
    Given I perform GET for one lender with user Id
    When I have url for 'userId' and '1002'
    Then Response status be '200'

  @get_lender_by_userId_not_existing
  Scenario: Get Lender by non existing User Id
    Given I perform GET for one lender non existing user Id
    When I have url for 'userId' with any non existing user-Id
    Then Response status shows code '404'

