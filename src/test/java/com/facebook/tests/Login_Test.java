package com.facebook.tests;

import com.grondle.data.FacebookData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// These tests open 3 websites one at a time, validates that page title is accurate and closes the browser.  It then
// revisits the 1st page (facebook.com), validates page title, locates the email login and password fields and populates
// fields with email and password.  Finally, it validate asserts that values entered into the field actually
// exists in the login and password fields.  This test also utilizes separation of test data (residing in
// FacebookData.java class from the actual tests.  The testng.xml file is the test runner which also allows separation
// of tests to control what tests need to be run or excluded.

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



        //below @Test uses outside data provider to run test against and verifies page titles for 3
        // websites listed in FacebookData.class java
        @Test(groups = {"p1", "pageLoads", "moreGroups"}, dataProvider = "manywebpages", dataProviderClass = FacebookData.class)
                public void loadPage(String url, String title){
                driver.get(url);
                Assert.assertEquals(driver.getTitle(), title);
        }


        //below @Test uses Login_Test.xml as the main wrapper.  This only loads facebook.com to very the title before it
        //enters the email login and password
        @Test(groups = {"p2", "FBpageLoads"})
            public void loadFBPage(){
            driver.get("http://www.facebook.com");
            Assert.assertEquals(driver.getTitle(), "Welcome to Facebook - Log In, Sign Up or Learn More");
        }



        //this only validates filling out email/password fields in facebook.com
        //below @Test uses Login_Test.xml as the main wrapper to start these tests

        @Test(groups = {"p3", "field"}, dependsOnMethods = "loadFBPage")
            public void filloutEmailFld(){
                String email = "yo.mamma@gmail.com";
                WebElement GetEmailFld = driver.findElement(By.cssSelector("#email"));
                GetEmailFld.sendKeys(email);
                Assert.assertEquals(GetEmailFld.getAttribute("value"), email);
         }


        //@Test(dependsOnMethods = "filloutEmailFld")
        //below @Test uses Login_Test.xml as the main wrapper to start these tests
        @Test(groups = {"p3", "field"}, dependsOnMethods = "filloutEmailFld")
        public void filloutPassFld() {
			    String password = "1233456";
			    WebElement PasswordFld = driver.findElement(By.cssSelector("#pass"));
			    PasswordFld.sendKeys(password);
			    Assert.assertEquals(PasswordFld.getAttribute("value"), password);
	}

}
