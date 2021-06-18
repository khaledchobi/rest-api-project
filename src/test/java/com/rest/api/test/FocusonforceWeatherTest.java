package com.rest.api.test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class FocusonforceWeatherTest {


    @Test
    public void GetUserDetails(){
        // Specify the base URL
        RestAssured.baseURI = "https://focusonforce.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        String responseBody = response.getBody().asString();

        System.out.println("Response: " + responseBody);

    }

    @Test
    public void ValidateStatusCode(){
        // Specify the base URL
        RestAssured.baseURI = "https://openweathermap.org";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/api");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Correct Status Code should be displayed.");

    }

    @Test
    public void ValidateStatusCode_01(){
        // Specify the base URL
        RestAssured.baseURI = "https://openweathermap.org";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/api");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Correct Status Code should be displayed.");

        /*if (response.getStatusCode() == 200) {

            Map<String, Object> results = (Map<String, Object>) JSON.deserializeUntyped(response.getBody());
            Map<String, Object> mainResults = (Map<String, Object>)(results.get('main'));
            temp = String.valueOf(mainResults.get('temp'));
            pressure = String.valueOf(mainResults.get('pressure'));
            humidity = String.valueOf(mainResults.get('humidity'));
            temp_min = String.valueOf(mainResults.get('temp_min'));
            temp_max = String.valueOf(mainResults.get('temp_max'));

        }*/

    }

}
