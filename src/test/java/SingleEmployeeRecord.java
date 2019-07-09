import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.Employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;

public class SingleEmployeeRecord extends TestBase{

	public static void main(String[] args) {

		@BeforeClass
           void getSingleEmployeeData() 
        {
			RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
			httpRequest = RestAssured.given();
			response=httpRequest.request(Method.GET,"/employee/"+"empID");
			
			Thread.sleep(3000);
}
		@Test
		void checkResponseBody()
		{
			String responseBody=response.getBody().asString();
			//logger.info("responseBody is ====== "+responseBody);
			Assert.assertTrue(responseBody!=null);
		}
		void checkStatusCode()
		{
			int statusCode= response.getStatusCode();
			Assert.assertEquals(statusCode,200);
		}
		void checkResponseTime()
		{
			long responseTime=response.getTime();
			Assert.assertTrue(responseTime<2000);
		}
		void checkStatusLine()
		{
			String statusLine=response.getStatusLine();
			Assert.assertEquals(statusLine,"Http/1.1 200 OK");
		}
		void checkContentType()
		{
			String contentType=response.header("content-type");
			Assert.assertEquals(contentType, "text/html,charset=UTF-8");
		}
		void checkServerType()
		{
			String   serverType=response.header("server-type");
			Assert.assertEquals(serverType, "nginx/1.14.1");
		}
		void checkContentLength()
		{
			String contentLength=response.header("content-Length");
			Assert.assertTrue(Integer.parseInt(contentLength)<1500);
		}
		@AfterClass
		void TearDown()
		{
			logger.info("-----------finished get single employee details-----------");
		}
    
}
