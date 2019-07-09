import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004 {
	@Test
	public void WeatherApi() {
		
		RestAssured.baseURI="http://maps.googleapis.com";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response = httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.867052.151.1957362&radius=1500type=supermarket&key=AlzaSybjGCE3VpLU4igTqSTDmhmJ2HoELb4jy1s");
		
     String responseBody= response.getBody().asString();
	System.out.println("responseBody is :"+responseBody);
	
	Headers allheaders=response.headers();
	
	for(Header header:allheaders) {
		System.out.println(header.getName()+"     "+header.getValue());
	}
		
		
				
	}

}
