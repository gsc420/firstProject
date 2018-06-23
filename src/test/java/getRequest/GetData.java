package getRequest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;

public class GetData {

	public static Response response;

	@Test
	public void testLogging() {

		given().headers("Authorization", "Basic MDA2OmIxNzJmMzAzOTEyOTAwZWUzYjY5MjMxZDI3NWRlZTdm")
				.get("http://10.67.198.30:8080/bep-mf-api/subscribers/2018/transactions").andReturn().then()
				.statusCode(200).log().all();
	}

	@Test
	public void getResponsecode() {

		Response respo = RestAssured.given()
				.header("Authorization", "Basic MDA2OmIxNzJmMzAzOTEyOTAwZWUzYjY5MjMxZDI3NWRlZTdm")
				.get("http://10.67.198.30:8085/bep-mf-api/subscribers/2018/packages");
		int code = respo.getStatusCode();
		System.out.println("Status code is" + " " + code);
		Assert.assertEquals(code, 200);

	}

	@Test
	public void getToken() {
		RestAssured.baseURI = "http://10.67.198.30:8080/bep-mf-api/subscribers/1894/transactions";
		RequestSpecification httpRequest = RestAssured.given().header("Authorization",
				"Basic MDA2OmIxNzJmMzAzOTEyOTAwZWUzYjY5MjMxZDI3NWRlZTdm");
		Response response = httpRequest.get();
		String contentType = response.header("Access-Token");
		System.out.println("Access-Token value: " + contentType);
		// Retrieve the body of the Response
		ResponseBody body = response.getBody();
		// By using the ResponseBody.asString() method, we can convert the body
		// into the string representation.
		System.out.println("Response Body is: " + body.asString());
	}

	@Test
	public void patchSubcriber() {

		// Patch Request to active and inactive subscriber
		given().headers("Authorization", "Basic MDA2OmIxNzJmMzAzOTEyOTAwZWUzYjY5MjMxZDI3NWRlZTdm")
				.contentType("application/json").body("{\"subscriberInfo\":{\"statusCode\" : \"I\"}}")
				.patch("http://10.67.198.30:8080/bep-mf-api/subscribers/2018").andReturn().then().statusCode(200).log()
				.all();

	}

}
