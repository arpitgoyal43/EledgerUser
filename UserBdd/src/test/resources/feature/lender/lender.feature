Feature: Test Lender Data API

  @post_lenders
  Scenario: POST API to create new Lender
    Given User want to hit Lender POST api
    When User provide the LenderData
    Then Response code should return 200 status code

  @get_list_of_lenders
  Scenario: Get Lenders list
    Given User perform GET for list of lenders
    When User have url for 'lenders'
    Then Response status should be 200

  @get_lender_by_userId
  Scenario: Get Lender by User Id
    Given User perform GET for one lender with user Id
    When User have url for 'userId' and 1
    Then Response status be 200

  @get_lender_by_userId_not_existing
  Scenario: Get Lender by non existing User Id
    Given User perform GET for one lender non existing user Id
    When User have url for 'userId' with any non existing user-Id 2
    Then Response status shows code 200
