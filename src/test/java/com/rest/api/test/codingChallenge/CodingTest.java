package com.rest.api.test.codingChallenge;

import com.rest.api.test.files.ReUsableMethods;
import com.rest.api.test.files.payload;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CodingTest {

    @Test
    public void GetUserDetails(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

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
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200, "Correct Status Code should be displayed.");

    }

    @Test
    public void ValidateStatusLine(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        String statusLine = response.getStatusLine();

        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct Status Code should be displayed.");

    }

    @Test
    public void ValidateContentType(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        String contentType = response.getContentType();

        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Correct Status Code should be displayed.");

    }

    @Test
    public void ValidateCookies(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        Map<String, String> cookies = response.getCookies();

        Assert.assertEquals(cookies, "{__cfduid=da78699be14d4af0e467f05b1888b29701609093245}", "Correct Status Code should be displayed.");

    }

    //@Test
    public void ValidateCookieDomain(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        String cookie = response.getCookie("Domain");

        Assert.assertEquals(cookie, null, "Correct Status Code should be displayed.");

    }

    @Test
    public void ValidateServer(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        String server = response.getHeader("Server");

        Assert.assertEquals(server, "cloudflare", "Correct Status Code should be displayed.");

    }

    @Test
    public void ValidateHeader(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");


        String header = response.getHeaders().getValue("Server");

        Assert.assertEquals(header, "cloudflare", "Correct Status Code should be displayed.");





    }

    @Test
    public void GetHeaders(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        //Response response = httpRequest.request(Method.GET, "/users");

        Response response = httpRequest.get("/users");

        // Reader header of a give name. In this line we will get Header named Content-Type
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        // Reader header of a give name. In this line we will get Header named Server
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        // Reader header of a give name. In this line we will get Header named Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
        // Reader header of a give name. In this line we will get Header named Connection
        String connection = response.header("Connection");
        System.out.println("Content-Type value: " + connection);


    }

    @Test
    public void IteratingOverHeaders() {
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Create a request
        RequestSpecification httpRequest = RestAssured.given();
        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");
        // Get all the headers. Return value is of type Headers. Headers class implements Iterable interface, hence we can apply an advance for loop to go through all Headers
        // as shown in the code below
        Headers allHeaders = response.headers();
        // Iterate over all the Headers
        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }
    }



    @Test
    public void ValidateHeaders(){
        // Specify the base URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create a request
        RequestSpecification httpRequest = RestAssured.given();

        // Create a response
        Response response = httpRequest.request(Method.GET, "/users");

        String server = response.getHeaders().getValue("Server");
        Assert.assertEquals(server, "cloudflare", "Correct Status Code should be displayed.");


        // Reader header of a give name. In this line we will get and Validate Header named Content-Type
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType, "application/json; charset=utf-8", "Correct Status Code should be displayed.");
        // Reader header of a give name. In this line we will get and Validate Header named Server
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType, "cloudflare", "Correct Status Code should be displayed.");
        // Reader header of a give name. In this line we will get and Validate Header named Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
        Assert.assertEquals(acceptLanguage, "gzip", "Correct Status Code should be displayed.");
        // Reader header of a give name. In this line we will get and Validate Header named Connection
        String connection = response.header("Connection");
        System.out.println("Content-Type value: " + connection);
        Assert.assertEquals(connection, "keep-alive", "Correct Status Code should be displayed.");


    }

    @Test
    public void GetMessageBody() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users");
        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        // By using the ResponseBody.asString() method, we can convert the body
        // into the string representation.
        System.out.println("Response Body is: " + body.asString());
    }

    @Test
    public void ValidateMessageBody()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users");
        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();
        //System.out.println(bodyAsString);
        Assert.assertEquals(bodyAsString.contains("username") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
    }


    @Test
    public void ValidateStringMessageBody() {
        // Check String presence by ignoring alphabet casing
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users");
        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();
        // convert the body into Upper case and then do a comparison to ignore casing.
        Assert.assertEquals(bodyAsString.toUpperCase().contains("USERNAME") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");
        // convert the body into lower case and then do a comparison to ignore casing.
        Assert.assertEquals(bodyAsString.toLowerCase().contains("leanne graham") /*Expected value*/, true /*Actual Value*/, "Response body contains Hyderabad");


    }

    @Test
    public void VerifyCityInJsonResponse() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users/10");

        // Retrieve the body of the Response
        ResponseBody body = response.getBody();
        // To check for sub string presence get the Response body as a String.
        // Do a String.contains
        String bodyAsString = body.asString();
        System.out.println(bodyAsString);

        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Then simply query the JsonPath object to get a String value of the node
        // specified by JsonPath: City (Note: You should not put $. in the Java code)
        String name = jsonPathEvaluator.get("name");
        // Let us print the city variable to see what we got
        System.out.println("Name received from Response " + name);
        // Validate the response
        Assert.assertEquals(name, "Clementina DuBuque", "Correct name received in the Response");
    }


    @Test
    public void DisplayAllNodesInUsersAPI() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/users/10");

        // Get response from query and print
        String abcd = given().log().all().queryParam("name").header("Content-Type","application/json; charset=utf-8")
                .when().get("/users/1")
                .then().assertThat().statusCode(200).body("name", equalTo("Leanne Graham"))
                .header("server", "cloudflare").extract().response().asString();
        System.out.println(abcd);


        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
        // Let us print the Name variable to see what we got
        System.out.println("Name received from Response: " + jsonPathEvaluator.get("name"));
        String name = jsonPathEvaluator.get("name");
        // Validate the response
        Assert.assertEquals(name, "Clementina DuBuque", "Correct name received in the Response");

        // Print the Username node
        System.out.println("Username received from Response: " + jsonPathEvaluator.get("username"));
        String username = jsonPathEvaluator.get("username");
        // Validate the response
        Assert.assertEquals(username, "Moriah.Stanton", "Correct username received in the Response");

        // Print the Email node
        System.out.println("Email received from Response: " + jsonPathEvaluator.get("email"));
        String email = jsonPathEvaluator.get("email");
        // Validate the response
        Assert.assertEquals(email, "Rey.Padberg@karina.biz", "Correct email received in the Response");

        // Print Address description
        System.out.println("Address description received from Response: " + jsonPathEvaluator.get("address"));
        String address = jsonPathEvaluator.get("address").toString();
        // Validate the response
        Assert.assertEquals(address, "{street=Kattie Turnpike, suite=Suite 198, city=Lebsackbury, zipcode=31428-2261, geo={lat=-38.2386, lng=57.2232}}", "Correct address received in the Response");

        // Print Phone node
        System.out.println("Phone received from Response: " + jsonPathEvaluator.get("phone"));
        String phone = jsonPathEvaluator.get("phone");
        // Validate the response
        Assert.assertEquals(phone, "024-648-3804", "Correct phone received in the Response");

        // Print Website node
        System.out.println("Website received from Response: " + jsonPathEvaluator.get("website"));
        String website = jsonPathEvaluator.get("website");
        // Validate the response
        Assert.assertEquals(website, "ambrose.net", "Correct website received in the Response");

        // Print Company node
        System.out.println("Company received from Response: " + jsonPathEvaluator.get("company"));
        String company = jsonPathEvaluator.get("company").toString().trim();
        // Validate the response
        Assert.assertEquals(company, "{name=Hoeger LLC, catchPhrase=Centralized empowering task-force, bs=target end-to-end models}", "Correct company received in the Response");


    }


    @Test
    public void PostUserDetails(){
        // Specify the base URL

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().log().all().queryParam("key").header("Content-Type","application/json; charset=utf-8")
                .body(payload.AddUserName()).when().post("/posts")
                .then().assertThat().statusCode(201).body("name", equalTo("Clementina DuBuque"))
                .header("server", "cloudflare").extract().response().asString();

        JsonPath jsAddress = new JsonPath(response);
        String address = jsAddress.get("address").toString();
        System.out.println("Zip code contains: " + address.contains("31428-2261"));
        // Validate the response
        Assert.assertEquals(address, "{street=Kattie Turnpike, suite=Suite 198, city=Lebsackbury, zipcode=31428-2261, geo={lat=-38.2386, lng=57.2232}}", "Correct address received in the Response");
        Assert.assertTrue(address.contains("zipcode=31428-2261"), "Correct address received in the Response");


        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String username = js.getString("username");

        System.out.println(username);

        //Update Place
        String newEmail = "khaledhasanb@gmail.com";

        given().log().all().queryParam("key").header("Content-Type","application/json; charset=utf-8")
                .body("{\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"Leanne Graham\",\n" +
                        "            \"username\": \""+username+"\",\n" +
                        "            \"email\": \""+newEmail+"\",\n" +
                        "            \"address\": {\n" +
                        "                  \"street\": \"Kulas Light\",\n" +
                        "                  \"suite\": \"Apt. 556\",\n" +
                        "                  \"city\": \"Gwenborough\",\n" +
                        "                  \"zipcode\": \"92998-3874\",\n" +
                        "                  \"geo\": {\n" +
                        "                        \"lat\": \"-37.3159\",\n" +
                        "                        \"lng\": \"81.1496\"\n" +
                        "                  }\n" +
                        "            },\n" +
                        "            \"phone\": \"1-770-736-8031 x56442\",\n" +
                        "            \"website\": \"hildegard.org\",\n" +
                        "            \"company\": {\n" +
                        "                  \"name\": \"Romaguera-Crona\",\n" +
                        "                  \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                        "                  \"bs\": \"harness real-time e-markets\"\n" +
                        "            }\n" +
                        "      }").
                when().put("/posts/1")
                .then().assertThat().log().all().statusCode(200).body("username", equalTo("Khaled.Hasan"));


        //Get User

        String getUserResponse = given().log().all().queryParam("key")

                .when().get("/users/8")
                .then().assertThat().log().all().statusCode(200).extract().response().getBody().asString();
        JsonPath js1 = ReUsableMethods.rawToJson(getUserResponse);
        String actualAddress =js1.getString("username");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, "Maxime_Nienow");


        System.out.println("Response: " + getUserResponse);


    }


    @Test
    public void PostUser(){
        // Specify the base URL

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        String response = given().log().all().header("Content-Type","application/json; charset=utf-8")
                .body("{\n" +
                        "      \"id\": 10,\n" +
                        "      \"name\": \"Clementina DuBuque\",\n" +
                        "      \"username\": \"Khaled.Hasan\",\n" +
                        "      \"email\": \"Rey.Padberg@karina.biz\",\n" +
                        "      \"address\": {\n" +
                        "            \"street\": \"Kattie Turnpike\",\n" +
                        "            \"suite\": \"Suite 198\",\n" +
                        "            \"city\": \"Lebsackbury\",\n" +
                        "            \"zipcode\": \"31428-2261\",\n" +
                        "            \"geo\": {\n" +
                        "                  \"lat\": \"-38.2386\",\n" +
                        "                  \"lng\": \"57.2232\"\n" +
                        "            }\n" +
                        "      },\n" +
                        "      \"phone\": \"024-648-3804\",\n" +
                        "      \"website\": \"ambrose.net\",\n" +
                        "      \"company\": {\n" +
                        "            \"name\": \"Hoeger LLC\",\n" +
                        "            \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                        "            \"bs\": \"target end-to-end models\"\n" +
                        "      }\n" +
                        "}").when().post("/posts")
                .then().assertThat().statusCode(201).body("name", equalTo("Clementina DuBuque"))
                .header("server", "cloudflare").extract().response().asString();



        //System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String username = js.getString("username");
        Assert.assertEquals(username, "Khaled.Hasan", "Correct address received in the Response");

        System.out.println(username);


    }


}
