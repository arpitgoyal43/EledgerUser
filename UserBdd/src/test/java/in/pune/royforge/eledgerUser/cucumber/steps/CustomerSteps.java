package in.pune.royforge.eledgerUser.cucumber.steps;

import in.pune.royforge.eledgerUser.cucumber.serenity.CustomersImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CustomerSteps {

	@Steps
	CustomersImpl customerImpl;

//POST API to create new customer
	@Given("I want to hit Customer POST API")
	public void iWantToHitCustomerPostApi() {
	}

	@When("I provide the CustomerData Object")
	public void IProvideTheCustomerDataObject() {
		customerImpl.postCustomerData();
	}

	@Then("I verify the Response code {int} in step")
	public void IVerifyTheResponseCodeInStep(int int1) {
	}

//All Customers GET API to get all customers including deleted
	@Given("I want to hit All Customers GET API")
	public void iWantToHitAllCustomersGetApi() {
	}

	@When("I provide the {string} url")
	public void IProvideTheUrl(String string) {
		customerImpl.getListOfAllCustomers(string);
	}

	@Then("Response should return status code {int}")
	public void responseShouldReturnStatusCode(int int1) {
	}

//Customers GET API to get list of customers
	@Given("I want to hit Customers GET API")
	public void iWantToHitCustomersGetApi() {
	}

	@When("I provide the {string} url for Customers GET API")
	public void IProvideTheUrlForCustomersGetApi(String string) {
		customerImpl.getListOfCustomers(string);
	}

	@Then("Response should return responseCode {string}")
	public void responseShouldReturnStatusCode(String string) {
	}

//Customer GET API to get customer by Id
	@Given("I want to hit Customer GET API with id")
	public void iWantToHitCustomersGetApiWithId() {
	}

	@When("I provide the id {string} for Customer GET API")
	public void IProvideTheIdForCustomersGetApi(String string) {
		customerImpl.getCustomerById(string);
	}

	@Then("Response should return name of customer {string}")
	public void responseShouldReturnNameOfCustomer(String string) {
	}

//Customer GET API to get customer by Id that not exist
	@Given("I want to hit Customer GET API with id that not exist")
	public void iWantToHitCustomersGetApiWithIdThatNotExist() {
	}

	@When("I provide the not existed id {string} for Customer GET API")
	public void IProvideTheNotExistedIdForCustomersGetApi(String string) {
		customerImpl.getCustomerByIdThatNotExisted(string);
	}

	@Then("Response should return status {string}")
	public void responseShouldReturnStatus(String string) {
	}

//Customer DELETE API to delete customer by Id
	@Given("I want to hit Customer DELETE API with id")
	public void iWantToHitCustomerDeleteApiWithId() {
	}

	@When("I provide the id {string} for Customer DELETE API")
	public void IProvideTheIdForCustomerDeleteApi(String string) {
		customerImpl.deleteCustomerById(string);
	}

	@Then("Response should return data message {string}")
	public void responseShouldReturnDataMessage(String string) {
	}

//Customer DELETE API to delete customer by Id that not exist
	@Given("I want to hit Customer DELETE API with id that not exist")
	public void iWantToHitCustomerDeleteApiWithIdThatNotExist() {
	}

	@When("I provide the not existed id {string} for Customer DELETE API")
	public void IProvideTheNotExistedIdForCustomerDeleteApi(String string) {
		customerImpl.deleteCustomerByIdThatNotExisted(string);
	}

	@Then("Response should return {string} status code with message {string}")
	public void responseShouldReturnStatusCodeWithMessage(String string1, String string2) {
	}

}
