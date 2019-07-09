import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006 {
	@Test
	public void getJsonDetails() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response= httpRequest.request(Method.GET,"Delhi");
		
		JsonPath jsonPath=response.jsonPath();
		
		System.out.println(jsonPath.get("City"));
		System.out.println(jsonPath.get("Temperature"));
		System.out.println(jsonPath.get("Humidity"));
		System.out.println(jsonPath.get("WeatherDescription"));
		System.out.println(jsonPath.get("WindSpeed"));
		System.out.println(jsonPath.get("WindDirectionDegree"));
		
		Assert.assertEquals(jsonPath.get("Temperature"),"39 degree celsius");

	}

}
