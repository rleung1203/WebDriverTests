package com.facebook.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Test {

        public WebDriver driver;

        @BeforeClass(alwaysRun = true)
            public void setup(){
                    driver = new FirefoxDriver();
                    //driver = new SafariDriver();
            }


        @AfterClass(alwaysRun = true)
        //@AfterClass
            public void teardown(){
                    driver.quit();
            }


        //@Test
        //below @Test uses Login_Test.xml as the main wrapper to start these tests
        @Test(groups = {"p1", "pageLoads"})
            public void loadPage(){
                driver.get("http://www.facebook.com");
                Assert.assertEquals(driver.getTitle(), "Welcome to Facebook - Log In, Sign Up or Learn More");
        }


        //@Test(dependsOnMethods = "loadPage")
        //below @Test uses Login_Test.xml as the main wrapper to start these tests
        @Test(groups = {"p2", "field"}, dependsOnMethods = "loadPage")
            public void filloutEmailFld(){
                String email = "yo.mamma@gmail.com";
                WebElement GetEmailFld = driver.findElement(By.cssSelector("#email"));
                GetEmailFld.sendKeys(email);
                Assert.assertEquals(GetEmailFld.getAttribute("value"), email);
         }

        //@Test(dependsOnMethods = "filloutEmailFld")
        //below @Test uses Login_Test.xml as the main wrapper to start these tests
        @Test(groups = {"p2", "field"}, dependsOnMethods = "filloutEmailFld")

        public void filloutPassFld() {
			    String password = "1233456";
			    WebElement PasswordFld = driver.findElement(By.cssSelector("#pass"));
			    PasswordFld.sendKeys(password);
			    Assert.assertEquals(PasswordFld.getAttribute("value"), password);
	}

}
