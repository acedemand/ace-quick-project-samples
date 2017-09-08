package com.acedemand.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Pamir on 5/28/2016.
 */
public class Program {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\dev\\libraries\\selenium\\drivers\\chrome\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.yapikredi.com.tr");
        webDriver.findElement(By.id("searchText")).sendKeys("Pamir Erdem was here");
        webDriver.findElement(By.linkText("BUL")).click();

        System.out.println("webDriver.getTitle() = " + webDriver.getTitle());
        //webDriver.close();
    }

    public static void testWebService(){
        WebDriver webDriver = new ChromeDriver();
        //webDriver.
    }

    class YKBMainPage{
        @FindBy(id = "searchText")
        private WebElement searchText;
    }
}
