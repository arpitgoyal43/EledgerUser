Feature: Test All Customer Data Apis

  @customer_post
  Scenario: POST API to create new customer
    Given User want to create a new Customer
    When User provide the CustomerData Object
    Then User verify the Response code 201

  @customer_get_all_customers
  Scenario: All Customers GET API to get all customers including deleted
    Given User want to get all customers including deleted
    When User provide the 'allcustomers' url
    Then Response should return status code 200

  @customer_get_customers
  Scenario: Customers GET API to get 	list of customers
    Given User want to get all customers
    When User provide the 'customers' url for Customers GET API
    Then Response should return responseCode 'OK'

  @customer_get_by_Id
  Scenario: Customer GET API to get customer by Id
    Given User want to get Customer by using Id
    When User provide the id '108' for Customer GET API
    Then Response should return name of customer 'Arpit Goyal'

  @customer_get_by_id_that_not_exist
  Scenario: Customer GET API to get customer by Id that not exist
    Given User want to get customer by using id that not exist 
    When User provide the not existed id '111' for Customer GET API  
    Then Response should return status 404
    
	@customer_delete_by_Id
  Scenario: Customer DELETE API to delete customer by Id
    Given User want to delete customer by id  
    When User provide the id '151' for Customer DELETE API
    Then Response should return data message 'true'

  @customer_delete_by_id_that_not_exist
  Scenario: Customer DELETE API to delete customer by Id that not exist
    Given User want to delete customer by id that not exist
    When User provide the not existed id '105' for Customer DELETE API
    Then Response should return 404 status code with message 'User Not Found'