package stepDefinitions.APIsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.ConfigurationReader;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class API_14stepdefs {
    Response response;
    //JsonPath jsonPath;
    //List<HashMap<String,Object>>abc;
    @Test
    @Given("Set the path params for the UserDetailByEmail")
    public void set_the_path_params_for_the_user_detail_by_email() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("api_url")).build();

        spec.pathParam("1", "getUserDetailByEmail");
     }

    @Test
    @Given("Send GET request and receive the response")
    public void send_get_request_and_receive_the_response() {
        response = given().spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .get("/{1}");

        response.prettyPrint();
        //String responseSt=String.valueOf(response.getBody().prettyPrint());
        //jsonPath=response.jsonPath();

    }
        @Then("Verify the status code")
        public void verifyTheStatusCode() {
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("text/html; charset=utf-8", response.contentType());

            System.out.println("Status code: " + response.statusCode());
            System.out.println("Content type: " + response.contentType());
          //System.out.println("Test zamani: " + response.time());
          //System.out.println(abc);

    }
}

//    @Test
//    @Given("Set the path params and send get request")
//    public void setThePathParamsAndSendGetRequest() {
//        response = given().when().get("https://automationexercise.com/api/getUserDetailByEmail");
//        response.prettyPrint();
//
//        response.then().assertThat().statusCode(200).contentType("text/html; charset=utf-8");
//    }










