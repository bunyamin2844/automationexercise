package stepDefinitions.APIsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigurationReader;

import java.util.HashMap;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class api08steps {

    /*
API URL:https://automationexercise.com/api/verifyLogin	      Response Kodun 400 olduğunu ve Response mesajı doğrulayın
Request Method:POST
Request Parameter:password
Response Code:400
Response Message:Bad request, email or password parameter is missing in POST request.

     */
    Response response;

    @Given("Given Set the path params for the verifyLogin")
    public void given_set_the_path_params_for_the_verify_login() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("api_url")).build();
        spec.pathParam("first","verifyLogin");

    }
    @And("Send Post request for create {string} attachment")
    public void sendPostRequestForCreateAttachment(String attachmentName) {
        response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        HashMap<String,String> requestBody = new HashMap<>();
        requestBody.put("responseCode",attachmentName);
        System.out.println(requestBody);


        response =given().
                spec(spec).
                contentType("text/html; charset=utf-8").
                body(requestBody).
                when().
                post("/{first}");

        response.prettyPrint();
    }

    @Then("Verify Status code {int}")
    public void verifyStatusCode(int statusCode) {
        System.out.println("StatusCode= "+ response.getStatusCode());
        assertEquals(statusCode,response.getStatusCode());
    }
    @Then("Verify Response Code {int}")
    public void verify_response_code(int responseCode) {
        //assertEquals(responseCode,response.get);


    }
    @Then("Verify Response Message {string}")
    public void verify_response_message(String string) {

    }



}
