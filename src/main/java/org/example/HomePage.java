package org.example;


import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {

    private By _registerButton = By.xpath("//a[@class='ico-register']");
    private By _clickOnAddToCart_BuildYourOwnComputer = By.xpath("//div[@class='product-grid home-page-product-grid']/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]");


    public void verifyUserIsOnHomePage()
    {
        String actualTitle = driver.getTitle();
        String expectedTitle = "nopCommerce demo store";
        Assert.assertEquals(actualTitle,expectedTitle,"User is not on Registration page");
    }

    public void clickOnRegisterButton()
    {
        clickOnElement(_registerButton);
    }

    public void clickOnAddToCart_BuildYourOwnComputer()
    {
        //click on add to cart button of Build your own computer
        clickOnElement(_clickOnAddToCart_BuildYourOwnComputer);
    }

}
