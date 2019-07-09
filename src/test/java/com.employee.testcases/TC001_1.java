

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Employee.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import.io.restassured.response.Response;




public class TC001_1 extends TestBase{
	
	@BeforeClass
	void getEmployeeDetails() throws InterruptedException {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httpRequest= RestAssured.given();
		response= httpRequest.request(Method.GET,"/employee/");
		Thread.sleep(30000);
	}
	void checkResponseBody() {
		String responseBody=response.getBody().asString();
		logger.info("ResponseBody is ---------- "+responseBody);
		Assert.assertTrue(responseBody!=null);
	}
	void checkStatusCode() {
		int statusCode = response.getStatusCode();
		logger.info("statuscode is =========== "+statusCode);
		Assert.assertEquals(statusCode, 200);
	}
	void checkResponseTime() {
		long responseTime = response.getTime();
		logger.info("ResponseTime is ============ "+responseTime);
		
		if(responseTime>2000) {
			logger.warn("ResponseTime is more");
		}
		Assert.assertTrue(responseTime<2000);
		}
	void checkStatusLine() {
		String statusLine=response.getStatusLine();
		logger.info("StatusLine is ======== "+statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
	}
	void checkContentType() {
		String contentType = response.header("content-Type");
		logger.info("contentType is =========="+contentType);
		Assert.assertEquals(contentType, "text/html;charset=UTF-8");
	}
	void checkServerType() {
		String serverType=response.header("server-Type");	
		logger.info("serverType is ========"+serverType);
		Assert.assertEquals(serverType, "nginx/1.14.1");
	}
	void checkContentLength() {
	String contentLength=response.header("contentLength");
	logger.info("contentLength is ========"+contentLength);
	if(Integer.parseInt(contentLength)<100)
		logger.warn("contentLength is less than 100");
		
	Assert.assertTrue(Integer.parseInt(contentLength)>100);
	}
		
void checkCookie() {
	String cookie=response.getCookie("PHPSESSID");
	logger.info("cookie is "+cookie);
}
		
		
@AfterClass
void tearDown()
{
	logger.info("--------------Finished TC001 get Employees----------------");
}
}

		
		
		
		
		
	
	
	
	
	


