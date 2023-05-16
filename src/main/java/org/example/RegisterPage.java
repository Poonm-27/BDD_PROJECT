package org.example;


import org.openqa.selenium.By;

public class RegisterPage extends Utils {
    LoadProp loadProp = new LoadProp();
    private By _firstname = By.xpath("//input[@id='FirstName']");
    private By _lastname =By.xpath("//input[@id='LastName']");
    private By _day = By.xpath("//select[contains(@name,'DateOfBirthDay')]");
    private By _month =By.name("DateOfBirthMonth");
    private By _year = By.name("DateOfBirthYear");
    private By _emailId = By.xpath("//input[@id='Email']");
    private By _password = By.xpath("//input[@id='Password']");
    private By _confirmPassword = By.xpath("//input[@id='ConfirmPassword']");

    private By _submitButton = By.xpath("//button[@id='register-button']");

    public void enterRegistrationDetails(){
        //type firstname
        typeText(_firstname,loadProp.getProperty("firstName"));

        //type lastname
        typeText(_lastname,loadProp.getProperty("lastName"));

        //Select the day of birth
        selectByDisplayedText(_day, loadProp.getProperty("dobDate"));

        //Select the month of birth
        selectByValue(_month, loadProp.getProperty("dobMonth"));

       // int a =Integer.parseInt(loadProp.getProperty("dobYear"));
        //Select the year of birth
        selectByIndexValue(_year, Integer.parseInt(loadProp.getProperty("dobYear")));

        //type email address
        typeText(_emailId, loadProp.getProperty("email")+timestamp()+loadProp.getProperty("emailDomain"));

        //type password
        typeText(_password,loadProp.getProperty("password"));

        //type confirm password
        typeText(_confirmPassword, loadProp.getProperty("confirmPassword"));

        //click on submit button
        clickOnElement(_submitButton);

    }

    public void enterRegistrationDetailsforTest_Scenario_Refer_A_Product(){
        //type firstname
        typeText(_firstname, loadProp.getProperty("firstname1"));

        //type lastname
        typeText(_lastname, loadProp.getProperty("lastname1"));

        //type email address
        typeText(_emailId, loadProp.getProperty("emailId_2"));

        waitForElementToBeClickable(_password);

        //type password
        typeText(_password, loadProp.getProperty("password2"));

        //type confirm password
        typeText(_confirmPassword, loadProp.getProperty("confirmPassword2"));

        //click on submit button
        clickOnElement(_submitButton);

    }
}
