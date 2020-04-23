package com.netflix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreatePage extends Base {

    @FindBy(css = "div[class='stepHeader-container'] div h1")
    private WebElement finishTxt;

    @FindBy(css = "div[class='submitBtnContainer'] button")
    private WebElement continueBtn;

    public CreatePage(WebDriver driver) {
        super(driver);
    }

    public String getCreateTxt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return finishTxt.getText();
    }

    public void getContinue() {
        continueBtn.click();
    }
}
