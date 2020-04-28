package in.pune.royforge.eledgerUser.cucumber.steps;

import in.pune.royforge.eledgerUser.cucumber.serenity.LenderImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LenderSteps {

	@Steps
	LenderImpl lender;

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
}
