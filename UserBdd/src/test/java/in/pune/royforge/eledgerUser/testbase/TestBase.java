package in.pune.royforge.eledgerUser.testbase;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class TestBase {

	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "http://localhost:8081/lender";
		RestAssured.baseURI = "http://localhost:8081/customer";
	}
}
