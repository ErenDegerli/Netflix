package com.netflix.pages;

import com.netflix.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class ResetPasswordPage extends Base {

    @FindBy(css = "div[class='reset-choice-container'] :last-child input")
    private WebElement textMsgBtn;

    @FindBy(css = "div[class='ui-select-wrapper country-select']")
    private WebElement countryDropDown;

    @FindBy(css = "li[data-uia='option-216']")
    private WebElement turkeyOption;

    @FindBy(id = "forgot_password_input")
    private WebElement numberInput;

    @FindBy(css = "button[class='btn forgot-password-action-button btn-blue btn-large']")
    private WebElement submitBtn;

    @FindBy(css = "label[class='lbl-forgot_password_input']")
    private WebElement errorMsg;

    @FindBy(id = "forgot_password_input")
    private WebElement emailInput;

    @FindBy(css = "div[class='login-content'] div h2")
    private WebElement confirmationMsg;

    public ResetPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void getResetPasswordPage() {
        try {
            driver.get(Config.getValue("resetUrl"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public void getTextMessageOption() {
        waitUntilClickable(textMsgBtn).click();
    }

      public void getTurkeyOption() {
        countryDropDown.click();
        waitUntilVisible(turkeyOption).click();
    }*/

    public void getSubmission() {
        try {
            emailInput.sendKeys(Config.getValue("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        submitBtn.click();
    }

    public String getConfirmationMsg() {
        return waitUntilVisible(confirmationMsg).getText();
    }

    /*public String getErrorMsg() {
        return errorMsg.getText();
    }*/


}
