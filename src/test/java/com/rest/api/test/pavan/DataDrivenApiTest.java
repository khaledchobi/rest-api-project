package com.rest.api.test.pavan;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class DataDrivenApiTest {

    @Test
    void postNewEmployees() { // Test Case: New Employees added

        //Specify base URI
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();


        //Here we created data which we can send along with the post request
        JSONObject requestParams = new JSONObject();

        requestParams.put("employee_name","Smith");
        requestParams.put("employee_salary","5000");
        requestParams.put("employee_age","29");


        // Add a header starting the body is a JSON
        httpRequest.header("Content-Type","application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        // Post request
        Response response = httpRequest.request(Method.POST,"/create");

        // Capture response body to perform validations
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        Assert.assertEquals(responseBody.contains("Smith"),true);
        Assert.assertEquals(responseBody.contains("5000"),true);
        Assert.assertEquals(responseBody.contains("29"),true);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

    }

    @Test(dataProvider = "empdataprovider")
    void postMultipleEmployees(String ename, String esal, String eage) { // Test Case: New Employees added multiple

        //Specify base URI
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();


        //Here we created data which we can send along with the post request
        JSONObject requestParams = new JSONObject();

        requestParams.put("employee_name",ename);
        requestParams.put("employee_salary",esal);
        requestParams.put("employee_age",eage);


        // Add a header starting the body is a JSON
        httpRequest.header("Content-Type","application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        // Post request
        Response response = httpRequest.request(Method.POST,"/create");

        // Capture response body to perform validations
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        Assert.assertEquals(responseBody.contains(ename),true);
        Assert.assertEquals(responseBody.contains(esal),true);
        Assert.assertEquals(responseBody.contains(eage),true);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

    }

    @DataProvider(name="empdataprovider")
    Object[][] getEmpData() {
        String empdata[][] = {{"Khaled","20000","35"}, {"Hasan","25000","37"}, {"Bappy","26000","40"}};
        return(empdata);
    }


    @Test(dataProvider = "empdataexlprovider")
    void postExcelDataEmployees(String ename, String esal, String eage) { // Test Case: New Employees added multiple

        //Specify base URI
        RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";

        //Request object
        RequestSpecification httpRequest = RestAssured.given();


        //Here we created data which we can send along with the post request
        JSONObject requestParams = new JSONObject();

        requestParams.put("employee_name",ename);
        requestParams.put("employee_salary",esal);
        requestParams.put("employee_age",eage);


        // Add a header starting the body is a JSON
        httpRequest.header("Content-Type","application/json");

        // Add the Json to the body of the request
        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        // Post request
        Response response = httpRequest.request(Method.POST,"/create");

        // Capture response body to perform validations
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        Assert.assertEquals(responseBody.contains(ename),true);
        Assert.assertEquals(responseBody.contains(esal),true);
        Assert.assertEquals(responseBody.contains(eage),true);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

    }

    @DataProvider(name="empdataexlprovider")
    Object[][] getEmpExlData() throws IOException {

        // Read data from Excel
        String path = System.getProperty("user.dir") + "/src/test/java/com/rest/api/test/pavan/empdata.xlsx";

        int rownum = XLUtils.getRowCount(path, "Sheet1");
        int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

        String empdata[][] = new String[rownum][colcount];

        for (int i =1; i <= rownum; i++){
            for (int j = 0; j < colcount; j++){
                empdata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }

        //String empdata[][] = {{"Khaled","20000","35"}, {"Hasan","25000","37"}, {"Bappy","26000","40"}};
        return(empdata);
    }

}
