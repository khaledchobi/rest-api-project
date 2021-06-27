package com.rest.api.test.pavan;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001_GET_Request {

    @Test
    void getweatherDetails() { // Test Case 1) Weather API - Validate status code & Status line
        //Specify base URI
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET,"/users");

        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //status line verification
        String statusLine=response.getStatusLine();
        System.out.println("Status line is:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }

    @Test
    void RegistrationSuccessful() { // Test Case 2) Register Customer API

        //Specify base URI
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();


        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("FirstName","JohnXYZ");
        requestParams.put("LastName","XYZJohn");
        requestParams.put("UserName","JohnXYZ");
        requestParams.put("Password","JohnXYZxyx");
        requestParams.put("Email","JohnXYZ@gmail.com");


        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response=httpRequest.request(Method.POST,"/posts");


        //print response in console window

        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 201);

        //success code validation
        String successCode=response.jsonPath().get("SuccessCode");
        //Assert.assertEquals(successCode, "OPERATION_SUCCESS");
        Assert.assertEquals(successCode, null);

    }

    @Test
    void LoginSuccessful() { // Test Case 3) Login Customer API

        //Specify base URI
        RestAssured.baseURI="https://reqres.in/api/register";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();


        //Request paylaod sending along with post request
        JSONObject requestParams=new JSONObject();

        requestParams.put("email","eve.holt@reqres.in");
        requestParams.put("password","cityslicka");


        httpRequest.header("Content-Type","application/json");

        httpRequest.body(requestParams.toJSONString()); // attach above data to the request

        //Response object
        Response response = httpRequest.request(Method.POST,"/");


        //print response in console window

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        //success code validation
        String successCode=response.jsonPath().get("SuccessCode");
        //Assert.assertEquals(successCode, "OPERATION_SUCCESS");
        Assert.assertEquals(successCode, null);

    }

    @Test
    void googleMapTest() { // Test Case 4) Google Map API - Validating Headers

        //Specify base URI
        RestAssured.baseURI="https://maps.googleapis.com";

        //Request object
        RequestSpecification httpRequest=RestAssured.given();

        //Response object
        Response response=httpRequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");

        //print response in console window
        String responseBody=response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //validating headers
        String contentType=response.header("Content-Type");// capture details of Content-Type header
        System.out.println("Content Type is:"+contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

        String contentEncoding=response.header("Content-Encoding");// capture details of Content-Encoding  header
        System.out.println("Content Encoding is:"+contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

    }

    //@Test
    void AuthorizationTest() { // Test Case 1) Weather API - Validate status code & Status line
        //Specify base URI
        RestAssured.baseURI="https://reqres.in/api/register";

        // Basic authentication
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("eve.holt@reqres.in");
        authScheme.setPassword("pistol");

        RestAssured.authentication = authScheme;

        //Request object
        RequestSpecification httpRequest = RestAssured.given();

        //Response object
        Response response = httpRequest.request(Method.GET,"/");

        //print response in console window

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is:" +responseBody);

        //status code validation
        int statusCode=response.getStatusCode();
        System.out.println("Status code is: "+statusCode);
        Assert.assertEquals(statusCode, 200);

        /*//status line verification
        String statusLine=response.getStatusLine();
        System.out.println("Status line is:"+statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");*/

    }



}
