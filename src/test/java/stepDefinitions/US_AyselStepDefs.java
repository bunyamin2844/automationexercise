package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US_AyselPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_AyselStepDefs {
    Faker faker = new Faker();

    US_AyselPage newUser = new US_AyselPage();
    US_AyselPage user = new US_AyselPage();
    Actions actions;
    Select select;


    @Then("Verify that {string} is visible")
    public void verify_that_is_visible(String string) {
        ReusableMethods.waitFor(2);

        // Assert.assertTrue(newUser.newUserSignupWebelement.isDisplayed());
    }


    @Then("Enter name and email address")
    public void enter_name_and_email_address() {

        newUser.newUsersignUpname.sendKeys(faker.name().firstName());
        ReusableMethods.waitFor(1);
        newUser.newUsersignUpemail.sendKeys(faker.internet().emailAddress());

    }

    @Then("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_title_name_email_password_date_of_birth() {
        newUser.genderRadioBotton.click();
        newUser.newAccountPasswordBox.sendKeys("123");

        WebElement dayDropdown = Driver.getDriver().findElement(By.id("days"));
        select = new Select(dayDropdown);
        select.selectByVisibleText("3");
        WebElement monthDropdown = Driver.getDriver().findElement(By.id("months"));
        select = new Select(monthDropdown);
        select.selectByValue("4");
        WebElement yearDropdown = Driver.getDriver().findElement(By.id("years"));
        select = new Select(yearDropdown);
        select.selectByIndex(9);
        ReusableMethods.waitFor(3);

    }

    @Then("Select checkbox {string}")
    public void select_checkbox(String checkBox) {
        newUser.chechBox1.click();
        ReusableMethods.waitFor(1);
        newUser.chechBox2.click();

    }

    @Then("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_first_name_last_name_company_address_address2_country_state_city_zipcode_mobile_number() {
        newUser.firstnameBox.sendKeys("cicek");
        newUser.lastnameBox.sendKeys("Abbas");
        newUser.companyBox.sendKeys("techpro");
        newUser.address1.sendKeys("Abd Street");
        newUser.address2.sendKeys("NY Road");

        WebElement countryDropdown = Driver.getDriver().findElement(By.id("country"));
        select = new Select(countryDropdown);
        select.selectByIndex(3);
        newUser.stateBox.sendKeys("Tazmania");
        newUser.cityBox.sendKeys("Perth");
        newUser.zipcodeBox.sendKeys("1213");
        newUser.mobile_numberBox.sendKeys("567-89-05");

    }



    @Then("Verify that {string} is visible and click {string} button")
    public void verify_that_is_visible_and_click_button(String text, String Cbotton) {
//   Assert.assertTrue(newUser.accountCreatedText.isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click", newUser.continueButton);
//

        // newUser.continueButton.click();


        ///Assert.assertTrue(newUser.loggedInText.isDisplayed());
        ///newUser.deleteaccountButton.click();
        ///Assert.assertTrue(newUser.deleteaccountText.isDisplayed());

    }

    @Then("Enter correct email address and password")
    public void enterCorrectEmailAddressAndPassword() {
        user.loginEmailBox.sendKeys("cicek", Keys.ENTER);
        user.loginPasswordBox.sendKeys("Abbas", Keys.ENTER);
        user.SigninLoginButton.click();
    }


    @Then("Click {string} button.")
    public void clickSignupButton() {
        newUser.newUserSignupButton.click();
    }
}

