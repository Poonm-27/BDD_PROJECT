package org.example;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.Date;
import java.util.List;

public class Utils extends BasePage{

    //All reusable methods to perform specific action.
    public static void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public static long timestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }

    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }


    public static void waitForElementToBeClickable(By by) {
        //apply explicit wait of 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToBeInvisible(By by) {
        //apply explicit wait of 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitForElementToBeVisible(By by) {
        //apply explicit wait of 30 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void selectByDisplayedText(By by, String text) {
        Select birthDay = new Select(driver.findElement(by));
        birthDay.selectByVisibleText(text);
    }

    public static void selectByValue(By by, String text) {
        Select birthMonth = new Select(driver.findElement(by));
        birthMonth.selectByValue(text);
    }

    public static void selectByIndexValue(By by, int num) {
        Select birthYear = new Select(driver.findElement(by));
        birthYear.selectByIndex(num);
    }

    public static void alertPopUps_Assert_And_Accept(String text) {
        //switch to alert
        Alert alert = driver.switchTo().alert();
        //verify alert message
        Assert.assertEquals(alert.getText(), text);
        //click on ok
        alert.accept();
    }

    public static void alertPopUps_Assert_And_Dismiss(String text) {
        //switch to alert
        Alert alert = driver.switchTo().alert();
        //verify alert message
        Assert.assertEquals(alert.getText(), text);
        //click on ok
        alert.dismiss();
    }

    public static void alertPopUps_Assert_And_SendKeys(String text, String text2) {
        //switch to alert
        Alert alert = driver.switchTo().alert();
        //verify alert message
        Assert.assertEquals(alert.getText(), text);
        //Enter specific text needed
        alert.sendKeys(text2);
    }

    public static void alertPopUps_getText() {
        driver.switchTo().alert().getText();
    }

    public static void sleep(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public static void list_of_items(By by) {

        List<WebElement> list = driver.findElements(by);
        for (WebElement e : list) {
            System.out.println(e.getText());
        }
    }

    public static List<WebElement> getTextFromElements(By by){
        List< WebElement> fullList = driver.findElements(by);
        for (WebElement nameOfEachElement:fullList){
            System.out.println(nameOfEachElement.getText());
        }return (fullList);
    }


    public static boolean assertBoolean(By by, String text) {
        List<WebElement> productList = driver.findElements(by);
        for (WebElement productTitle : productList) {
            productTitle.getText();
            if (productTitle.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public static String currentTimeStamp() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
        return sdf.format(date);
    }

    public static void captureScreenshot(String fileName) {
        //convert web driver object to TakeScreenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);

        //Call getScreenshotsAs method to create image file
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File destFile = new File("src\\test\\Screenshots\\" + fileName + "" + currentTimeStamp() + ".png");

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
