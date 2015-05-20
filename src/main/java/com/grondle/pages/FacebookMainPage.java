package com.grondle.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FacebookMainPage {

    public static final String PAGE_TITLE = "Welcome to Facebook - Log In, Sign Up or Learn More";
    public static final String PAGE_URL = "http://www.facebook.com";

    String field_EmailLogin = "#email";
    String field_PasswordLogin = "#pass";

    // we can't start writing actions yet because we need a driver to first find elements (email, password) before
    // we can interact with those elements.  To do this we need a constructor below which will be passing in WebDriver
    // driver to get started.
    WebDriver driver;

    public FacebookMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setText_EmailLogin(String text){
        WebElement element = driver.findElement(By.cssSelector(field_EmailLogin));
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

    public void setText_PasswordLogin(String text) {
        WebElement element = driver.findElement(By.cssSelector(field_PasswordLogin));
        element.sendKeys(text);
        Assert.assertEquals(element.getAttribute("value"), text);
    }

}
