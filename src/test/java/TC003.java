import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003 {
	
	
	@Test
	public void googleMapTest() {

		RestAssured.baseURI="http://maps.googleapis.com";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response =httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.867052.151.1957362&radius=1500type=supermarket&key=AlzaSybjGCE3VpLU4igTqSTDmhmJ2HoELb4jy1s");
		
		String responseBody=response.getBody().asString();
		System.out.println("responseBody is :"+responseBody);
	
		//capture details from headers
		//launch postman and give this request in the search box then you get the headers
		
		//validating headers
		String contentType = response.header("content-type"); 	
		System.out.println("contentType is :"+contentType);
		Assert.assertEquals(contentType,"application/xml; charset=UTF-8");
		
		//contentencoding
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("contentEncoding is :"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
		
		
		
	}	
}
