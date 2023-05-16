package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils
{
    //By creating instance of LoadProp,all test data can be accessed from TestDataProperties file
    LoadProp loadProp = new LoadProp();

    public void openBrowser(){
        if(loadProp.getProperty("browserName").equalsIgnoreCase("Chrome"))
        {
            //open the browser
            driver = new ChromeDriver();
        }
        else if (loadProp.getProperty("browserName").equalsIgnoreCase("firefox"))
        {
            //open the browser
            driver = new FirefoxDriver();
        }
        else if (loadProp.getProperty("browserName").equalsIgnoreCase("edge"))
        {
            //open the browser
            driver = new EdgeDriver();
        }
        else
        {
            System.out.println("Browser name is wrong or not implemented : "+loadProp.getProperty("browserName"));
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
