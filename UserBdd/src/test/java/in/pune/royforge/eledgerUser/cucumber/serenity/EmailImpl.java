package in.pune.royforge.eledgerUser.cucumber.serenity;

import org.junit.Assert;

import in.pune.royforge.eledgerUser.model.EmailData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class EmailImpl {
	Response response;

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.getStatusCode(), statusCode);
	}

	@Step
	public void postResetPasswordMail(String name, String email) {
		RestAssured.baseURI = "http://localhost:8081/reset-password";
		response = SerenityRest.rest().given().contentType(ContentType.JSON).when()
				.body(postEmailData(name, email, "Prem Singh")).post("http://localhost:8081/reset-password");
	}

	@Step
	public void postNewCustomerMail(String name, String email) {
		RestAssured.baseURI = "http://localhost:8081/new-customer";
		response = SerenityRest.rest().given().contentType(ContentType.JSON).when()
				.body(postEmailData(name, email, "Prem Singh")).post("http://localhost:8081/new-customer");
	}

	@Step
	public void postSignupMail(String name, String email) {
		RestAssured.baseURI = "http://localhost:8081/signup";
		response = SerenityRest.rest().given().contentType(ContentType.JSON).when()
				.body(postEmailData(name, email, "Prem Singh")).post("http://localhost:8081/signup");
	}

	// Method to push customer data to database
	private EmailData postEmailData(String name, String email, String customerName) {
		EmailData emailData = new EmailData();
		emailData.setName(name);
		emailData.setEmail(email);
		emailData.setCustomerName(customerName);
		return emailData;
	}
}