package com.rest.api.test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.awt.*;
import java.util.Map;
public class JSONTest {
    @Test
    public void getUserDetails(){
        //specify the base url
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // create a request
        RequestSpecification httpRequest = RestAssured.given();
        // create a response
        Response response = httpRequest.request(Method.GET, "/users");
        String responseBody = response.getBody().asString();
        System.out.println("Response body => " + responseBody);
    }

    @Test
    public void validateStatusCode(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
        //create a request
        RequestSpecification httpRequest = RestAssured.given();
        //
        Response response = httpRequest.request(Method.GET, "/users");
        int statusCode = response.getStatusCode();
        //getting status line code as string
        String statusLine = response.getStatusLine();
        //getting cookies as map.no need to validate cookies, cause cookies are dynamic
        Map<String, String> cookies = response.getCookies();
        Assert.assertEquals(statusCode, 200, "Correct status code should display");
    }

    @Test
    public void test1_getAllUsers(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";

        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();
        //System.out.println(bodyAsString);

        String res = given().header("Content-Type", "application/json").
                get("users").
                then().
                statusCode(200).
                body("username", hasItems("Bret", "Antonette", "Samantha" )). // we can add more here
                body("email", hasItems("Nathan@yesenia.net", "Sincere@april.biz")) // we can and add more
                .header("server", "cloudflare").extract().response().asString();


        System.out.println(res);

    }

    @Test
    public void test2_getUserById(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String addressPath = ("address \n" + "'zipcode' \n" + "'92998-3874'");

        String response = given().log().all().
                header("Content-Type", "application/json; charset=utf-8").
                param("id", 1).
                when().get("users").
                then().assertThat().
                statusCode(200).
                body("id[0]", equalTo(1)).
                body("username[0]", equalTo("Bret")).
                body("email[0]", equalTo("Sincere@april.biz")).
                //body("\"address\" \n" + "\"suite\" \n" + "\"Apt. 556\"", equalTo("Apt. 556"))
                //body("address \n" + "'zipcode' \n" + "'92998-3874'", equalTo("92998-3874"))

                body(addressPath, equalTo("92998-3874"))

        .header("server", "cloudflare").extract().response().asString();


        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String username = js.getString("username[0]");
        Assert.assertEquals(username, "Bret", "Correct address received in the Response");

        String address = js.getString(addressPath);
        Assert.assertEquals(address, "92998-3874", "Correct address received in the Response");

        System.out.println(username);
        System.out.println(address);

    }

    @Test
    public void test3_getRequest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
        JSONObject jsonObject = new JSONObject();
        // for address
        jsonObject.getOrDefault("id", 10);
        jsonObject.getOrDefault("name", "Habib");
        jsonObject.getOrDefault("username", "habibmridha");
        jsonObject.getOrDefault("email", "xyz@co.com");
        JSONArray array=new JSONArray();
        JSONObject item=new JSONObject();
        item.getOrDefault("street", "ABC Street");
        item.getOrDefault("suite", "Apt. 10C");
        item.getOrDefault("city","NYC");
        item.getOrDefault("zipcode", "10000");
        array.add(item);
        jsonObject.getOrDefault("address",array);



        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                get("users").
                then().
                statusCode(201);
    }

    @Test
    public void test3_postRequest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        JSONObject jsonObject = new JSONObject();
        // for address
        jsonObject.put("id", 11);
        jsonObject.put("name", "Habib");
        jsonObject.put("username", "habibmridha");
        jsonObject.put("email", "xyz@co.com");
        JSONArray array=new JSONArray();
        JSONObject item=new JSONObject();
        item.put("street", "ABC Street");
        item.put("suite", "Apt. 10C");
        item.put("city","NYC");
        item.put("zipcode", "10000");
        array.add(item);
        jsonObject.put("address",array);
        JSONArray geo=new JSONArray();
        JSONObject geoItm=new JSONObject();
        geoItm.put("lat", "-37.100");
        geoItm.put("lng", "80.1234");
        geo.add(geoItm);
        item.put("geo",geo);
        // for company
        JSONArray company=new JSONArray();
        JSONObject companyItm=new JSONObject();
        companyItm.put("name","AZ com LLC");
        companyItm.put("catchPhrase","Multi national company");
        companyItm.put("bs","Multi company");
        company.add(companyItm);
        jsonObject.put("company",company);
        jsonObject.put("phone", "1-111-1234-1234");
        jsonObject.put("website", "mywebsite.com");
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                post("users").
                then().
                statusCode(201);
    }

    @Test
    public void test4_putRequest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        JSONObject jsonObject = new JSONObject();
        // for address
        jsonObject.put("id", 2);
        jsonObject.put("name", "Habib");
        jsonObject.put("username", "habibgggmridha");
        jsonObject.put("email", "xyz@co.com");
        JSONArray array=new JSONArray();
        JSONObject item=new JSONObject();
        item.put("street", "ABCSD Street");
        item.put("suite", "Apt. 10C");
        item.put("city","NYC");
        item.put("zipcode", "10000");
        array.add(item);
        jsonObject.put("address",array);
        JSONArray geo=new JSONArray();
        JSONObject geoItm=new JSONObject();
        geoItm.put("lat", "-34.100");
        geoItm.put("lng", "80.1234");
        geo.add(geoItm);
        item.put("geo",geo);
        // for company
        JSONArray company=new JSONArray();
        JSONObject companyItm=new JSONObject();
        companyItm.put("name","AZ com LLC");
        companyItm.put("catchPhrase","Multi national company");
        companyItm.put("bs","Multi company");
        company.add(companyItm);
        jsonObject.put("company",company);
        jsonObject.put("phone", "1-111-1234-1234");
        jsonObject.put("website", "mywebsite.com");
        given().
                header("Content-Type", "application/json").
                param("id", 2).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(jsonObject.toJSONString()).
                when().
                put("users").
                then().
                statusCode(201);
    }

    @Test
    public void test5_deleteRequest(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        given().
                header("Content-Type", "application/json").
                param("id", 11).
                when().
                delete("users").
                then().
                statusCode(204);
    }
}
