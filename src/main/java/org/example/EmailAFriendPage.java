package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class EmailAFriendPage extends Utils {
    static String expectedProductNameBeforeEmail = "Build your own computer";
    static String expectedSuccessMsg = "Your message has been sent succesfully.";
    static String expectedProductNameAfterSendingEmail = "Build your own computer";

   private By _enterFriendEmailId = By.xpath("//input[@class='friend-email']");
    private By _enterYourEmailId = By.xpath("//input[@id='YourEmailAddress']");
    private By _enterPersonalMsg_BuildYourOwnComputer = By.xpath("//div[@class='form-fields']/div[3]/textarea");
    private By _productNameBeforeSendingEmail = By.xpath("//div[@class='page-body']/div[1]/h2/a");
    private By _clickSendEmailButton = By.xpath("//button[@class='button-1 send-email-a-friend-button']");
    private By _actualProductNameReferredAfterEmailSent = By.xpath("//a[@class='product']");
    private By _actualSuccessMessage = By.xpath("//div[@class='result']");

    LoadProp loadProp = new LoadProp();

    public void enterDetailsToSendEmail()
    {
        //type friend's email id
        typeText(_enterFriendEmailId, loadProp.getProperty("friendEmailId"));

        //type your email id
        typeText(_enterYourEmailId, " ");

        //type message
        typeText(_enterPersonalMsg_BuildYourOwnComputer, loadProp.getProperty("enterPersonalMessage"));

        //Name of the product being referred to the friend before send email
        String productNameBeforeSendEmail = getTextFromElement(_productNameBeforeSendingEmail);
        System.out.println("Product name before sending email to friend : " + productNameBeforeSendEmail);
        Assert.assertEquals(productNameBeforeSendEmail, expectedProductNameBeforeEmail,"Incorrect Product is being referred");

    }

    public void click_on_send_button()
    {
        //click send email button
        clickOnElement(_clickSendEmailButton);

    }
    public void verifyProductAndSuccessMessage()
    {
        //Name of the product referred to the friend after email has been sent
        String productNameAfterEmail = getTextFromElement(_actualProductNameReferredAfterEmailSent);
        System.out.println("Product name shown after sending email (Confirmation Message): "+productNameAfterEmail);
        Assert.assertEquals(productNameAfterEmail,expectedProductNameAfterSendingEmail,"Product name referred is incorrect");

        String actualEmailSentSuccessMsg = getTextFromElement(_actualSuccessMessage);
        Assert.assertEquals(actualEmailSentSuccessMsg,expectedSuccessMsg,"Success Message is incorrect");

    }
}
