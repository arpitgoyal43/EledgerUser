package in.pune.royforge.eledgerUser.cucumber.steps;

import in.pune.royforge.eledgerUser.cucumber.serenity.LenderImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LenderSteps {

	@Steps
	LenderImpl lender;

//Post Request to create/update lenders
	@Given("I want to hit Lender POST api")
	public void i_want_to_hit_Lender_POST_api() {

	}

	@When("I provide the Lender")
	public void i_provide_the_Lender() {
		lender.postLenderUrl();

	}

	@Then("Response code should return {int} status code")
	public void response_code_should_return_status_code(Integer int1) {

	}

//Get Request to get list of all lenders
	@Given("I perform GET for list of lenders")
	public void i_perform_GET_for_list_of_lenders() {
	}

	@When("I have url for {string}")
	public void i_have_url_for(String string) {
		lender.getLendersList();
	}

	@Then("Response status should be {string}")
	public void response_status_should_be(String string) {
	}

//Get request to get specific lender with user Id
	@Given("I perform GET for one lender with user Id")
	public void i_perform_GET_for_one_lender_with_user_Id() {

	}

	@When("I have url for {string} and {string}")
	public void i_have_url_for_and(String string, String id) {
		lender.getLenderByUserId(string, id);
	}

	@Then("Response status be {string}")
	public void response_status_be(String string) {

	}

//Get request for non existing user-id lender
	@Given("I perform GET for one lender non existing user Id")
	public void i_perform_GET_for_one_lender_non_existing_user_Id() {

	}

	@When("I have url for {string} with {}")
	public void i_have_url_for_with_any_non_existing_user_Id(String string, String id) {
		lender.getLenderByNonExistingUserId(string, id);
	}

	@Then("Response status shows code {string}")
	public void response_status_shows_code(String string) {

	}

}
