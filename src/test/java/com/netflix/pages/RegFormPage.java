package com.netflix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegFormPage extends Base {

    @FindBy(id = "cb_emailPreference")
    private WebElement checkBox;

    @FindBy(linkText = "Sign In")
    private WebElement signInBtn;

    public RegFormPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

}
