package com.netflix.pages;

import com.netflix.configuration.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class SignInPage extends Base {

    @FindBy(id = "id_userLoginId")
    private WebElement emailInput;

    @FindBy(id = "id_password")
    private WebElement passwordInput;

    @FindBy(css = "button[class='btn login-button btn-submit btn-small']")
    private WebElement signInBtn;

    @FindBy(css = "div[class='ui-binary-input login-remember-me'] input")
    private WebElement checkBox;

    @FindBy(css = "div[class='ui-message-contents']")
    private WebElement failedMessage;

    @FindBy(css = "div[class='ui-message-contents'] a")
    private WebElement resetPasswordLink;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void getSignInPage() {
        try {
            driver.get(Config.getValue("signInUrl"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebElement getRememberMeCheckBox() {
        return checkBox;
    }

    public void getSignIn() {
        try {
            emailInput.sendKeys(Config.getValue("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            passwordInput.sendKeys(Config.getValue("password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        signInBtn.click();
    }

    public String getMessage() {
        return waitUntilVisible(failedMessage).getText();
    }

    public WebElement getResetPasswordLink() {
        return resetPasswordLink;
    }

}
