package com.netflix.steps;

import com.netflix.core.TestBase;
import com.netflix.pages.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestRunner extends TestBase {

    private SignUpPage signUpPage;
    private PlanPage planPage;
    private CreatePage createPage;
    private RegFormPage regFormPage;
    private SignInPage signInPage;
    private ResetPasswordPage resetPasswordPage;

    @Before
    public void setUpPages() {
        signUpPage = new SignUpPage(driver);
        planPage = new PlanPage(driver);
        createPage = new CreatePage(driver);
        regFormPage = new RegFormPage(driver);
        signInPage = new SignInPage(driver);
        resetPasswordPage = new ResetPasswordPage(driver);
    }

    @Test
    public void signUpPhase() {
        signUpPage.getSignUpPage();
        signUpPage.getPlans();
        final String price = planPage.getPrice();
        Assert.assertEquals("Türkçe", planPage.getActualLanguage());
        planPage.changeLanguageToEnglish();
        Assert.assertEquals(price, planPage.getPrice());
        planPage.getLastPage();
        Assert.assertEquals("Create your account.", createPage.getCreateTxt());
        createPage.getContinue();
        Assert.assertFalse(regFormPage.getCheckBox().isSelected());
    }

    @Test
    public void signInPhase() {
        signInPage.getSignInPage();
        Assert.assertTrue(signInPage.getRememberMeCheckBox().isSelected());
        signInPage.getSignIn();
        Assert.assertEquals("Incorrect password. Please try again or you can reset your password.", signInPage.getMessage());
        Assert.assertTrue(signInPage.getResetPasswordLink().isDisplayed());
    }

    @Test
    public void resetPasswordPhase() {
        resetPasswordPage.getResetPasswordPage();
        //resetPasswordPage.getTextMessageOption();
       // resetPasswordPage.getTurkeyOption();
        resetPasswordPage.getSubmission();
        //Assert.assertEquals("Lütfen geçerli bir telefon numarası girin.", resetPasswordPage.getErrorMsg());
        Assert.assertEquals("E-posta Gönderildi",resetPasswordPage.getConfirmationMsg());
    }
}