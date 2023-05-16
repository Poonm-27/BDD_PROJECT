package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegisterResultPage extends Utils{
    static String expectedRegistrationCompleteMsg = "Your registration completed";

    private By _registrationSuccessfulMessage = By.xpath("//div[@class='result']");
    private By _clickOnLogin = By.xpath("//a[@href=\"/login?returnUrl=%2F\"]");

    public void verifyUserRegisteredSuccessfully() {

        //print the message "Your registration is completed"
        String actualRegistrationCompletionMesssage = getTextFromElement(_registrationSuccessfulMessage);
        System.out.println("Actual message : " + actualRegistrationCompletionMesssage);

        //compare expected msg with actual msg
        Assert.assertEquals(actualRegistrationCompletionMesssage, expectedRegistrationCompleteMsg, "Your registration is not completed");

    }

    public  void  clickOnLogin(){
        //click on login
        clickOnElement(_clickOnLogin);
    }
}
