package utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DatadrivenTest {
	@Test(dataProvider="empdataprovider")
	void addNewEmployess(String ename,String esalary,String eage) {

		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		//request object
		RequestSpecification httpRequest=RestAssured.given();
		//we created data which we can send along with post request
		JSONObject requiredParams=new JSONObject();
		
		requiredParams.put("name", ename);
		requiredParams.put("salary", esalary);
		requiredParams.put("age", eage);
		
		//add a header stating the request body is a json
		httpRequest.header("ContentType","applicatoin/json");
      
		httpRequest.body(requiredParams.toJSONString());//as data is in hasp map sending the request by converting it to json format
		
		//POST request
		Response response = httpRequest.request(Method.POST,"/create");
		
		//capture response body to perform validation
		
		String responseBody= response.getBody().asString();
		System.out.println("responseBody is :"+responseBody);
		Assert.assertEquals(responseBody.contains(ename),true);
		Assert.assertEquals(responseBody.contains(esalary),true);
		Assert.assertEquals(responseBody.contains(eage),true);
		
		//statusCode
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
	}
    /* @DataProvider(name="empdataprovider") 
	String [][]getEmpData()
	{
		String empdata[][]= {{"abc123","89030","80"},{"pqr432","69800","67"},{"xyz321","76580","68"}};
		return(empdata);
	}*/
     @DataProvider(name="empdataprovider")
     String[][]getEmpData1()
     
		{
         try {  
    	 String [][]empData=null;
			 FileInputStream file=new FileInputStream("../testData/file1.xlsx");
			 XSSFWorkbook wb=new XSSFWorkbook(file);
			 XSSFSheet sheet=wb.getSheetAt(0);
			 int rowCount=sheet.getLastRowNum();
			 int columnCount=sheet.getRow(0).getLastCellNum();
			 empData=new String[rowCount][columnCount];
			 
			 for(int i=1;i<rowCount;i++) {
				XSSFRow r1= sheet.getRow(i);
				  for(int j=0;j<=columnCount;j++) {
					  String cell =r1.getCell(j).getStringCellValue();
					  [i-1][j]=cell;
					  
				}
			 }
			 
         }	 
		 
	 catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
     
     return empData;
}
