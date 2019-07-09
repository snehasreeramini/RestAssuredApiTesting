import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class TC002 {
	
	
	@Test
	public void postRegistration() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RequestSpecification httpRequest=RestAssured.given();
		//ResponseObject
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("firstname","XYZJohn");
		requestParams.put("lastname","JohnXYZ");
		requestParams.put("username","JohnXYZ");
		requestParams.put("Password","John");
		requestParams.put("Email","JohnXYZ@gmail.com");

		httpRequest.header("content-Type","application/json");
		httpRequest.body(requestParams.toJSONString());
		
		//response object
		Response response=httpRequest.request(Method.POST,"register");
		
		//print response
		String responseBody=response.getBody().asString();
		System.out.println("reponseBody is :"+responseBody);
		
		//statusCode Verification
		int statusCode=response.getStatusCode();
		System.out.println("statusCode is "+statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//SuccessCode verification
		String SuccessCode=response.jsonPath().get("SuccessCode");
		Assert.assertEquals(SuccessCode, "OPERATION_SUCCESS");
		
		
		
		
	}

}
