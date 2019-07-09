import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001 {
	@Test
	public void getWeatherDetails() {
		
		//specify base uri
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		//request object
		RequestSpecification httprequest=RestAssured.given();//httprequest is name of object(variable)
		
		//responseObject
		
		Response response=httprequest.request(Method.GET,"Hyderabad");
		
		//print response in console window
		
		String responseBody=response.getBody().asString();
		System.out.println("reponseBody  is :" +responseBody);
		
		//statuscode validation
		int statusCode=response.getStatusCode();
		System.out.println("statusCode is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//statusLine Verification
		String statusLine=response.getStatusLine();
		System.out.println("statusLine is :"+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}

}
