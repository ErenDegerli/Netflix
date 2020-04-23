package com.netflix.core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {

    public static WebDriver driver;
    public WebDriverWait wait;
    public Select select;

    protected PageBase(WebDriver driver) {
        this.driver =driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public WebElement waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitUntilClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
