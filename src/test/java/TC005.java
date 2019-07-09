import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005 {
	@Test
	public void getWeather() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"DELHI");
		
		String responseBody = response.getBody().asString();
		System.out.println("reponseBody is "+responseBody);
		
		Assert.assertEquals(responseBody.contains("DELHI"), true);
		
		
	}

}
