package stepDefinitions.APIsteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.Login;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class US_08 {

    ObjectMapper objectMapper= new ObjectMapper();
    Login login;

       String url ="https://automationexercise.com/api/verifyLogin";
       String url2="https://automationexercise.com/api/getUserDetailByEmail";
       @Test
    public void test008() throws IOException {

           Response response= given()
                   .contentType(ContentType.JSON)
                  // .post(url);
                    .post(url2);
           //response.prettyPrint();

           JsonPath jsonPath= response.jsonPath();
           System.out.println("jsonPat) = " + jsonPath.getInt("responseCode"));
           System.out.println("jsonP\") = " + jsonPath.getString("message"));

           //*********************************
           
           Login login = objectMapper.readValue(response.asString(),Login.class);

           System.out.println("login.getResponseCode() = " + login.getResponseCode());
           System.out.println("login.getMessage() = " + login.getMessage());


       }

}
