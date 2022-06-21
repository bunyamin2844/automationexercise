package stepDefinitions.APIsteps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class API1stepdefs {

    Response response;
    Response response2;
    JsonPath jsonPath;

    @Test


    @Given("set the API URL")
    public void setTheAPIURL() {
        given().
                contentType(ContentType.JSON).when().
                get("https://automationexercise.com/api/productsList");
        response.prettyPrint();

    }
        @Then("validate status code")
        public void validateStatusCode() {

            Assert.assertEquals("Status code",200, response.getStatusCode());
        }

//
//        response2.then().assertThat().statusCode(200).contentType(ContentType.JSON).
//                body("products.id", hasSize(43));



    }





