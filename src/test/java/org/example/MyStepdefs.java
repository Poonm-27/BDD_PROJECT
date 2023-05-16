package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    HomePage homePage=new HomePage();
    RegisterPage registerPage=new RegisterPage();
    RegisterResultPage registerResultPage=new RegisterResultPage();
    LoginPage loginPage = new LoginPage();
    Build_Your_Own_ComputerPage build_your_own_computerPage = new Build_Your_Own_ComputerPage();
    EmailAFriendPage emailAFriendPage = new EmailAFriendPage();

    @Given("I am on Registration page")
    public void i_am_on_registration_page() {

        //verify user is on Homepage/registration page
        homePage.verifyUserIsOnHomePage();

        //click on Register button
        homePage.clickOnRegisterButton();
    }
    @When("I enter required registration details")
    public void i_enter_required_registration_details() {
        //Enter registration details
        registerPage.enterRegistrationDetails();
    }
    @Then("I should able to register successfully")
    public void i_should_able_to_register_successfully() {
        //verify user registered successfully
        registerResultPage.verifyUserRegisteredSuccessfully();
    }

    //Registered User should be able to refer a product to a friend successfully

    @Given("I am a registered user")
    public void i_am_a_registered_user()
    {
        //verify user is on Homepage/registration page
        homePage.verifyUserIsOnHomePage();

        //click on Register button
        homePage.clickOnRegisterButton();

        //Enter registration details
        registerPage.enterRegistrationDetailsforTest_Scenario_Refer_A_Product();

        //verify user registered successfully
        registerResultPage.verifyUserRegisteredSuccessfully();

    }
    @Given("I am logged in to the website")
    public void i_am_logged_in_to_the_website()
    {
        //click on login on homepage
        registerResultPage.clickOnLogin();

        //enter login credentials on login page and click on LOGIN button
        loginPage.enterLoginCredentialsAndSubmit();

    }
    @When("I click on add to cart button of a product on homepage")
    public void i_click_on_add_to_cart_button_of_a_product_on_homepage() {
        //click on add to cart button of Build your own computer on homepage
        homePage.clickOnAddToCart_BuildYourOwnComputer();
    }
    @When("I click on email a friend button on product page")
    public void i_click_on_email_a_friend_button_on_product_page()
    {
        //click on email a friend on "Build your own computer" page
        build_your_own_computerPage.clickEmailAFriendButton();
    }
    @When("I enter required details to send email on email a friend page")
    public void i_enter_required_details_to_send_email_on_email_a_friend_page()
    {
        //enter all details for sending email
        emailAFriendPage.enterDetailsToSendEmail();
    }
    @When("I click on send button")
    public void i_click_on_send_button()
    {
        //click on send button
        emailAFriendPage.click_on_send_button();
    }
    @Then("I should be able to refer a product to a friend successfully")
    public void i_should_be_able_to_refer_a_product_to_a_friend_successfully()
    {
        //success message
        emailAFriendPage.verifyProductAndSuccessMessage();
    }
}
