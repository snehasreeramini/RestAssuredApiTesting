import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC007 {
	@Test
	public void getAutherizationApproved() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		PreemptiveBasicAuthScheme authScheme=new PreemptiveBasicAuthScheme();
		authScheme.setUserName("Toolsqa");
		authScheme.setPassword("TestPassword");
		
		RestAssured.authentication=authScheme;
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/");
		//print response in console window
		String responseBody=response.getBody().asString();
		System.out.println("ResponseBody is :"+responseBody);
		
		
		//statuscode validation
		int statusCode =response.getStatusCode();
		System.out.println("StatusCode is :"+statusCode);
		Assert.assertEquals(statusCode, 200);
		
		
		
		
	}

}
