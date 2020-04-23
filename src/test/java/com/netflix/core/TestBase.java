package com.netflix.core;

import com.netflix.configuration.Config;
import com.netflix.driver.SetDriver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class TestBase {

    protected static WebDriver driver;

    @Before
    public void setUpDriver() {
        if(driver == null) {
            driver = SetDriver.initializeDriver();
        }
    }

    @After
    public void tearDown() {
        if (driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
