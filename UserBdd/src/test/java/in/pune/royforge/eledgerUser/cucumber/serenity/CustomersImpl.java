package in.pune.royforge.eledgerUser.cucumber.serenity;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.UUID;

import in.pune.royforge.eledgerUser.model.CustomerData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CustomersImpl {
	Response response;

	@Step
	public void postCustomerData() {
		RestAssured.baseURI = "http://localhost:8081/customer";
		response = postCreateCustomer("Boss", 1212121213l, "m5");
		response.then().statusCode(201);
	}

	@Step
	public void getListOfCustomers(String url) {
		SerenityRest.rest().given().with().pathParam("url", url).when().get("http://localhost:8081/customer/{url}")
				.then().statusCode(200).body("responseCode", equalTo("OK"));
	}

	@Step
	public void getListOfAllCustomers(String url) {
		SerenityRest.rest().given().with().pathParam("url", url).when().get("http://localhost:8081/customer/{url}")
				.then().statusCode(200);
	}

	@Step
	public void getCustomerById(String id) {
		SerenityRest.rest().given().with().pathParam("id", id).when()
				.get("http://localhost:8081/customer/customer/{id}").then().statusCode(200)
				.body("data.name", equalTo("Arpit Goyal"));
	}

	@Step
	public void getCustomerByIdThatNotExisted(String id) {
		SerenityRest.rest().given().with().pathParam("id", id).when()
				.get("http://localhost:8081/customer/customer/{id}").then().statusCode(404);
	}

	@Step
	public void deleteCustomerById(String id) {
		SerenityRest.rest().given().with().pathParam("id", id).when()
				.delete("http://localhost:8081/customer/customer/{id}").then().statusCode(200)
				.body("data", equalTo(true));
	}

	@Step
	public void deleteCustomerByIdThatNotExisted(String id) {
		SerenityRest.rest().given().with().pathParam("id", id).when()
				.delete("http://localhost:8081/customer/customer/{id}").then().statusCode(404)
				.body("message", equalTo("User Not Found"));
	}

	// Method to push customer data to database
	private Response postCreateCustomer(String name, Long phone, String lenderId) {
		CustomerData customerData = new CustomerData();
		UUID uuId = UUID.randomUUID();
		customerData.setName(name);
		customerData.setPhone(phone);
		customerData.setBorrowId(uuId.toString());
		customerData.setLenderId(lenderId);
		customerData.setIsDeleted(false);
		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(customerData)
				.post("http://localhost:8081/customer");
	}
}