package com.netflix.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PlanPage extends Base {

    @FindBy(css = "input#planGrid_planChoice_1.planGrid__selectorInput.planGrid__planInput")
    private WebElement standardPlan;

    @FindBy(css = "div[class='submitBtnContainer firstLoad'] button")
    private WebElement continueBtn;

    @FindBy(css = "td[class='planGrid__cell planGrid__cell--isSelected planGrid__stringCell']")
    private WebElement selectedPlanPrice;

    @FindBy(css = "div[class='nfSelectPlacement globe'] select")
    private WebElement languageDropDown;

    public PlanPage(WebDriver driver) {
        super(driver);
    }

    public String getActualLanguage() {
        select = new Select(languageDropDown);
        return select.getFirstSelectedOption().getText();
    }

    public void changeLanguageToEnglish() {
        select = new Select(languageDropDown);
        select.selectByValue("/signup/planform?locale=en-TR");
    }

    public String getPrice() {
        return waitUntilVisible(selectedPlanPrice).getText();
    }

    public void getLastPage() {
        waitUntilClickable(continueBtn).click();
    }
}
