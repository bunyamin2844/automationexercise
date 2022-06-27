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

public class US_10 {

    ObjectMapper objectMapper= new ObjectMapper();

    String url="https://automationexercise.com/api/getUserDetailByEmail";
    @Test
    public void test10() throws IOException {

        Response response= given()
                .contentType(ContentType.JSON)
                .delete(url);
        //response.prettyPrint();

        JsonPath jsonPath= response.jsonPath();
        System.out.println("Response code= " + jsonPath.getInt("responseCode"));
        System.out.println("Message = " + jsonPath.getString("message"));


        Assert.assertEquals(405,jsonPath.getInt("responseCode"));




    }

}
