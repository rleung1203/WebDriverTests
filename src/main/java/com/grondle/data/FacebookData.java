package com.grondle.data;

import org.testng.annotations.DataProvider;

public class FacebookData {

    // setting up data provider that allows you to set up multiple sets of data to pass into a single test
    // and use that data to run that test. Use annotation @DataProvider

    // we moved the data below into a different external classfile called FacebookData.java to
    // separate our test data from our tests

        // ARGS [URL][TITLE OF PAGE]
	    @DataProvider(name = "manywebpages")
	        public static Object[][] pages() {
		        return new Object[][] {
				    {"http://www.facebook.com", "Welcome to Facebook - Log In, Sign Up or Learn More"},
				    {"http://www.google.com", "Google"},
				    {"http://www.yahoo.com", "Yahoo"}
				    //{"http://www.facebook.com", "Welcome to Facebook - Log In, Sign Up or Learn More"}
		        };
	    }

}
