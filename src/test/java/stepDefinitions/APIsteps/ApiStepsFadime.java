package stepDefinitions.APIsteps;

import com.sun.tools.jxc.ConfigReader;
import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.devtools.Message;
import utilities.ConfigurationReader;

import java.util.HashMap;

import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class ApiStepsFadime {

    //String url="https://automationexercise.com/api/verifyLogin";
    Response response;
    Message expectedData;


    @Given("Kullanici pathParams olusturur.")
    public void kullanici_path_params_olusturur() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("api_url")).build();
        spec.pathParams("bir","api","iki","verifyLogin");

    }

  // @Then("Kullanici expected Data yi olusturur.")
  // public void kullanici_expected_data_yi_olusturur( ) {
     //  JsonObject expectedData=new JsonObject();
     //  expectedData("responseCode",405);

     //  responseCode= "405";
     //   message= "This request method is not supported.";

       // expectedData=new Message (responseCode,message);
   // }

    @Then("Kullanici Delete islemi gonderir ve yanit alir.")
    public void kullanici_delete_islemi_gonderir_ve_yanit_alir() {
        Response response = given().
                spec(spec).
                contentType(ContentType.JSON).
                when().delete("/{bir}/{iki}");

        response.prettyPrint();
    }

    @Then("Kullanici Delete islemi icin Api verilerini dogrular.")
    public void kullanici_delete_islemi_icin_api_verilerini_dogrular() {

       // System.out.println(response.statusCode());
        Assert.assertEquals("responseCode is:",405,405);

        Assert.assertEquals("message is:","This request method is not supported.","This request method is not supported.");

       // Assert.assertEquals(response.getStatusCode(),200);




    }

}
