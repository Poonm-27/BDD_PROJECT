package org.example;

import org.openqa.selenium.By;

public class LoginPage extends Utils{
    private By _enterEmailId = By.xpath("//input[@id='Email']");
    private By _enterPassword = By.xpath("//input[@id='Password']");
    private By _clickLoginButton = By.xpath("(//div[@class='buttons']/button)[2]");
    LoadProp loadProp =new LoadProp();

    public void enterLoginCredentialsAndSubmit(){
        //enter email id
        typeText(_enterEmailId, loadProp.getProperty("emailId_2"));

        //enter password
        typeText(_enterPassword, loadProp.getProperty("password2"));

        //click on LOGIN button
        clickOnElement(_clickLoginButton);
    }

}
