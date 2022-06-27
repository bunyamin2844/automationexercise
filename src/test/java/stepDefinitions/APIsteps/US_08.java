package stepDefinitions.APIsteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.Login;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class US_08 {

    ObjectMapper objectMapper= new ObjectMapper();
    Login login;

       String url ="https://automationexercise.com/api/verifyLogin";

       @Test
    public void test008() throws IOException {

           Response response= given()
                   .contentType(ContentType.JSON)
                   .post(url);

           //response.prettyPrint();

           JsonPath jsonPath= response.jsonPath();
           System.out.println("Response code " + jsonPath.getInt("responseCode"));
           System.out.println("Message = " + jsonPath.getString("message"));
         //  Assert.assertEquals(jsonPath.getString("message"),equals(400));

           System.out.println("*********************************");
           
           Login login = objectMapper.readValue(response.asString(),Login.class);

           System.out.println("login.getResponseCode() = " + login.getResponseCode());
           System.out.println("login.getMessage() = " + login.getMessage());

          Integer resp =400;
           Assert.assertEquals(resp,login.getResponseCode());



       }

}
