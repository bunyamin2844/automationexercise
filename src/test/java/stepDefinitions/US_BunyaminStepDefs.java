package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Test;
import pages.US_AyselPage;
import pages.US_BunyaminPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.Driver;

public class US_BunyaminStepDefs {

    US_BunyaminPage page =new US_BunyaminPage();
    US_AyselPage pageAysel = new US_AyselPage();


    @Then("Click on {string} button")
    public void click_on_button(String button) {

        if(button.equalsIgnoreCase("Products")){
            Driver.waitAndClick(page.productsButton);
        }else if (button.contains("Test")){
            Driver.waitAndClick(page.testCaseButtn);
        } else if (button.equals("View Product")){
            Driver.waitAndClick(page.viewProduct);
        }else if(button.contains("Cart")){
            Driver.waitAndClick(page.viewProduct); // view cart button locate eklenecek
        }else if(button.contains("Signup")){
            Driver.waitAndClick(pageAysel.SigninLoginButton);
        }else if(button.contains("Contact")){
            //Driver.waitAndClick(page.);
        }

    }
    @Then("Verify user is navigated to test cases page successfully")
    public void verify_user_is_navigated_to_test_cases_page_successfully() {
        Assert.assertTrue(page.testCaseText.isDisplayed());

    }
    @And("Click on Products button")
    public void clickOnProductsButton() {
        Driver.waitAndClick(page.productsButton);
    }
    @Then("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verify_user_is_navigated_to_all_products_page_successfully() {
        String title= Driver.getDriver().getTitle();
        System.out.println("title = " + title);
        Assert.assertEquals("title","title");

    }
    @Then("The products list is visible")
    public void the_products_list_is_visible() {
        Assert.assertTrue(page.productList.isDisplayed());

    }
    @Then("Click on {string} of first product")
    public void click_on_of_first_product(String string) {
        Driver.waitAndClick(page.viewProduct);


    }
    @When("User is landed to product detail page")
    public void user_is_landed_to_product_detail_page() {
        String title2= Driver.getDriver().getTitle();
        System.out.println("title2 = " + title2);
        Assert.assertEquals("title2","title2");

    }
    @Then("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void verify_that_detail_detail_is_visible_product_name_category_price_availability_condition_brand() {
        Assert.assertTrue(page.brand.isDisplayed());
        Assert.assertTrue(page.condition.isDisplayed());
        Assert.assertTrue(page.availibility.isDisplayed());
        Assert.assertTrue(page.category.isDisplayed());
        Assert.assertTrue(page.price.isDisplayed());
        Assert.assertTrue(page.name.isDisplayed());

    }
//    @And("Enter product name {string} in search input and click search button")
//    public void enterProductNameInSearchInputAndClickSearchButton(String arg0) {
//       Driver.waitAndSendText(page.searchButton);
//    }


    @Then("Verify {string} is visible")
    public void verifySEARCHEDPRODUCTSIsVisible(String str) {
        Assert.assertTrue(page.displayedProduct01.isDisplayed());
        
    }

    @Then("Verify all the products related to search are visible")
    public void verifyAllTheProductsRelatedToSearchAreVisible() {
        Assert.assertTrue(page.displayedProduct01.isDisplayed());
        Assert.assertTrue(page.displayedProduct02.isDisplayed());
        Assert.assertTrue(page.displayedProduct03.isDisplayed());
    }



}
