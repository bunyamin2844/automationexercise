package stepDefinitions.APIsteps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.Map;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class API1stepdefs {

    Response response;


        @Test
    @Given("Set the path params for the productsList")
    public void setThePathParamsForTheProductsList() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("api_url")).build();

        spec.pathParam("1","productsList");



    }
    @And("Send GET request and receive the response body")
    public void sendGETRequestAndReceiveTheResponseBody() {

         response = given().spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .get("/{1}");

              // response.prettyPrint();

    }



    @Then("Verify the status code is {int}")
    public void verifyTheStatusCodeIs(int statusCode) {
        JsonPath json = response.jsonPath();
        assertTrue(json.getInt("responseCode")==200);
        response.jsonPath().prettyPrint();


    }

    @Then("Verify the number of all product is {int}")
    public void verifyTheNumberOfAllProductIs(int numberOfProduct) {

//        response.
//                then().
//                assertThat().
//                statusCode(200).contentType("text/html; charset=utf-8");

        JsonPath jsonPath=response.jsonPath();

        String lastId=jsonPath.getString("products.id[-1]");
        System.out.println("lastId="+ lastId);
        Assert.assertEquals(numberOfProduct,Integer.parseInt(lastId));



    }

    @And("get all products whose prices are less than {int}")
    public void getAllProductsWhosePricesAreLessThan(int lowprice) {


    }



    }





