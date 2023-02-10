package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test(priority = 10)
    @Description("TC 1: Visits the login page")
    public void visitsTheLoginPage() {
        navPage.getLanguageButton().click();
        navPage.getEnglishLanguageLink().click();
        navPage.getLoginLink().click();
        navPage.verifyCurrentLinkContains("/login");
    }
    @Test(priority = 20)
    @Description("TC 2: Checks Input types")
    public void checksInputTypes(){
        navPage.getLoginLink().click();
        Assert.assertTrue(loginPage.getInputs("email").getAttribute("type").contains("email"),
                "Elements type attribute does not contain email");
        Assert.assertTrue(loginPage.getInputs("password").getAttribute("type").contains("password"),
                "Elements type attribute does not contain email");
    }
    @Test(priority = 30)
    @Description("TC 3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        navPage.getLoginLink().click();
        loginPage.getInputs("email").sendKeys("non-existing-user@gmail.com");
        loginPage.getInputs("password").sendKeys("password123");
        loginPage.getLoginButton().click();
        loginPage.verifyStatusMessageVisible();
        Assert.assertEquals(loginPage.getStatusMessage().getText(), "User does not exists",
                "Message does not contain 'User does not exists'");
        navPage.verifyCurrentLinkContains("/login");
    }
    @Test(priority = 40)
    @Description("TC 4: Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong(){
        navPage.getLoginLink().click();
        loginPage.getInputs("email").sendKeys("admin@admin.com");
        loginPage.getInputs("password").sendKeys("password123");
        loginPage.getLoginButton().click();
        loginPage.verifyStatusMessageVisible();
        Assert.assertEquals(loginPage.getStatusMessage().getText(), "Wrong password",
                "Message does not contain 'Wrong password'");
        navPage.verifyCurrentLinkContains("/login");
    }
    @Test(priority = 50)
    @Description("TC 5: Login")
    public void login(){
        navPage.getLoginLink().click();
        loginPage.getInputs("email").sendKeys("admin@admin.com");
        loginPage.getInputs("password").sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.verifyCurrentLinkContains("/home");
    }
    @Test(priority = 60)
    @Description("TC 6: Logout")
    public void logout(){
        loginPage.verifyLogoutButtonVisible();
        loginPage.getLogoutButton().click();
    }

}
