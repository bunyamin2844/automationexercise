package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {
    public static RequestSpecification spec;

   // @io.cucumber.java.Before(value="@Api")
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("api_url")).build();
    }

//    @io.cucumber.java.Before(value="@Db")
//    public void setUpDb(){
//        DBUtils.createConnection();
//    }

//    @Before(order = 1, value = "@UIRegistration")
//    public void navigateToRegistration(){
//        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaRegistration"));
//    }


//    @After(value="~Api")
//    public void tearDown(Scenario scenario){
//
//        if (scenario.isFailed()) {
//            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png","screenshots");
//            Driver.getDriver().get("https://www.automationexercise.com/logout");
//        }
//
//        Driver.closeDriver();

    }

