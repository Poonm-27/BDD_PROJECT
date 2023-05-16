package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils
{
    LoadProp loadProp = new LoadProp();
    String browserName = "Chrome";
    public void openBrowser(){
        if(browserName.equalsIgnoreCase("Chrome"))
        {
            //open the browser
            driver = new ChromeDriver();
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            //open the browser
            driver = new FirefoxDriver();
        }
        else if (browserName.equalsIgnoreCase("edge"))
        {
            //open the browser
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("Browser name is wrong or not implemented : "+browserName);
        }

        //open url
        driver.get(loadProp.getProperty("url"));
        //maximize window
        driver.manage().window().maximize();
        //add implicit wait for all web elements
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void closeBrowser()
    {
        //close the browser
        driver.close();
    }
}
