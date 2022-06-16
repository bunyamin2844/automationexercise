package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_AyselPage {


    public US_AyselPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(name = "name")
    public WebElement newUsersignUpname;

    @FindBy(xpath = "(//input[@type='email'])[2]")
    public WebElement newUsersignUpemail;

    @FindBy(xpath = "(//*[@type='submit'])[2]")
    public WebElement newUserSignupButton;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    public WebElement SigninLoginButton;

    @FindBy(xpath = "//*[.='New User Signup!']")
    public WebElement newUserSignupWebelement;


    @FindBy(xpath = "(//*[@id='id_gender2'])[1]")
    public WebElement genderRadioBotton;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement newAccountNameBox;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement LoginButton;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement newAccountPasswordBox;

    @FindBy(xpath = "//label[text()='Sign up for our newsletter!']")
    public WebElement chechBox1;

    @FindBy(xpath= "//label[text()='Receive special offers from our partners!']")
    public WebElement chechBox2;

    @FindBy(id = "first_name")
    public WebElement firstnameBox;

    @FindBy(id = "address1")
    public WebElement address1;

    @FindBy(id = "last_name")
    public WebElement lastnameBox;

    @FindBy(id= "address2")
    public WebElement address2;

    @FindBy(id = "company")
    public WebElement companyBox;

    @FindBy(id = "state")
    public WebElement stateBox;

    @FindBy(id = "city")
    public WebElement cityBox;

    @FindBy(id = "zipcode")
    public WebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    public WebElement mobile_numberBox;

    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccountButton;

    @FindBy(tagName = "//b")
    public WebElement accountCreatedText;

    @FindBy(xpath = "//*[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//i[@class='fa fa-user']")
    public WebElement loggedInText;

    @FindBy(linkText = "color:brown;")
    public WebElement deleteaccountButton;

    @FindBy(tagName = "//h1[text()='Delete Account']")
    public WebElement deleteaccountText;

    @FindBy(xpath = "(//*[@name='email'])[1]")
    public WebElement loginEmailBox;

    @FindBy(xpath= "//*[@name='password']")
    public WebElement loginPasswordBox;




}


