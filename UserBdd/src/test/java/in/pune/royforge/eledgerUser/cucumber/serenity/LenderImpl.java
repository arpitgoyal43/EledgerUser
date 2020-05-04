package in.pune.royforge.eledgerUser.cucumber.serenity;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import in.pune.royforge.eledgerUser.model.LenderData;

public class LenderImpl {
	Response response;

	@Step
	public void postLenderUrl() {
		RestAssured.baseURI = "http://localhost:8081/lender";
		response = postCreateLender("Sahil K", "sk@gmail.com", "sk1", "Sahil@123", 1234567890L, "SK Info");
		response.then().statusCode(201);
	}

	@Step
	public void getLendersList() {
		SerenityRest.rest().given().when().get("http://localhost:8081/lender/lenders").then().statusCode(200);
	}

	@Step
	public void getLenderByUserId(String path, String userId) {
		SerenityRest.rest().given().with().pathParam("path", path).when()
				.get("http://localhost:8081/lender/{path}/107").then().statusCode(200);
	}

	@Step
	public void getLenderByNonExistingUserId(String path, String userId) {
		SerenityRest.rest().given().with().pathParam("path", path).with().when()
				.get("http://localhost:8081/lender/{path}/1002").then().statusCode(404);
	}

	@Step
	public void statusCodeCheck(int statusCode) {
		Assert.assertEquals(response.then().statusCode(201), statusCode);
	}

	public Response postCreateLender(String Name, String email, String lenderId, String password, Long phone,
			String shopName) {
		LenderData lender = new LenderData();
		lender.setName(Name);
		lender.setLenderId(lenderId);
		lender.setEmail(email);
		lender.setPassword(password);
		lender.setPhone(phone);
		lender.setShopName(shopName);

		return SerenityRest.rest().given().contentType(ContentType.JSON).when().body(lender)
				.post("http://localhost:8081/lender");
	}
}
