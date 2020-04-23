package com.netflix.pages;

import com.netflix.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class SignUpPage extends Base {

    @FindBy(css = "div[class='submitBtnContainer'] button")
    private WebElement seePlans;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void getSignUpPage() {
        try {
            driver.get(Config.getValue("baseUrl"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getPlans() {
        waitUntilClickable(seePlans);
        seePlans.click();
    }
}
