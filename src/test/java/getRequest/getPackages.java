package getRequest;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class getPackages {
	public static Response response;

	@Test
	public void testLogging() {

		int code;
		RestAssured.baseURI = "http://10.67.198.30:8080/bep-mf-api/packages";
		RequestSpecification httpRequest = RestAssured.given().header("Authorization",
				"Basic b3A0OjY1NzJiZGFmZjc5OTA4NGI5NzMzMjBmNDNmMDliMzYz");
		Response response = httpRequest.get();
		code = response.getStatusCode();
//		if (code == 200) {
//			String contentType = response.header("Access-Token");
//			ResponseBody body = response.getBody();
//			String bodyAsString = body.asString();
//			JsonPath jsonPathEvaluator = response.jsonPath();
//			int count = jsonPathEvaluator.get("totalCount");
//			System.out.println("totalCount received from Response " + count);
//			Assert.assertEquals(count, 407, "Correct totalCount");
//			if (contentType != null) {
//				System.out.println("Access-Token" + ":--" + contentType);
//			} else {
//				System.out.println("Token does not genrate");
//			}
//
//		} else {
//			System.out.println("Status code is" + " " + "Invalid");
//		}
	}

}
