package stepDefinitions.APIsteps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static java.lang.Math.log;
import static org.hamcrest.Matchers.*;

public class API02PostSteps {
    Response response;
//https://automationexercise.com/api/productsList

     @Test
    public void getAPI01(){
        Response response = RestAssured.get("https://automationexercise.com/api/productsList");
//        System.out.println(response.asString());
//        System.out.println(response.getBody().asString());
//        System.out.println("Status Code:"+response.getStatusCode());
//        System.out.println("Status Line: "+response.getStatusLine());
//        System.out.println("Content type :"+response.getHeader("Content-Type"));
//
//        int statuscode = response.getStatusCode();
//        Assert.assertEquals(statuscode,200);
         response.prettyPrint();





    }
    @Test
    public void getAPI03(){
        //https://automationexercise.com/api/brandsList
//        given().get("https://automationexercise.com/api/brandsList")
//                .then()
//                .statusCode(200);
//              .body("brands.brand",hasItem("Polo"))
//                .body("brands.brand",hasItem("H&M"));
       JsonPath js=response.jsonPath();
        Response response = RestAssured.get("https://automationexercise.com/api/brandsList");
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println("Status Code:"+response.getStatusCode());
        System.out.println("Status Line: "+response.getStatusLine());
        System.out.println("Content type :"+response.getHeader("Content-Type"));

        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode,200);


    }
    @Test
    public void PutAPI02(){
        //https://automationexercise.com/api/productsList
        Response response =given().body(toString())
                .when().put("https://automationexercise.com/api/brandsList");
                //.when().post("https://automationexercise.com/api/productsList");
        response.prettyPrint();


        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());
        Assert.assertEquals("responseCode is: ",405,405);

        Assert.assertEquals("Message:","This request method is not supported.","This request method is not supported.");



    }
    @Test
    public void Post03() {
        Response response = given().body(toString())
                .when().post("https://automationexercise.com/api/searchProduct");
        //.when().post("https://automationexercise.com/api/productsList");
        response.prettyPrint();


        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());

        Assert.assertEquals("responseCode is ", 400, 400);
        System.out.println("response = " + response);
        Assert.assertEquals("Message", "Bad request, search_product parameter is missing in POST request.", "Bad request, search_product parameter is missing in POST request.");
        
    }
}
