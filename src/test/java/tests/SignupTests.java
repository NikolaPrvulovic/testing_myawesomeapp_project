package tests;

import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test(priority = 10)
    @Description("TC 1: Visits the signup page")
    public void visitsTheSignupPage() {
        navPage.getNavigationLink("signup").click();      // login, signup, about, home
        navPage.verifyCurrentLinkContains("/signup");  // can not get logout, admin button with this!
    }

    @Test(priority = 20)
    @Description("TC 2: Checks input types")
    public void checksInputTypes() {
        navPage.getNavigationLink("signup").click();
        Assert.assertTrue(signupPage.getInputs("email").getAttribute("type").contains("email"),
                "Elements type attribute does not contain email");
        Assert.assertTrue(signupPage.getInputs("password").getAttribute("type").contains("password"),
                "Elements type attribute does not contain password");
        Assert.assertTrue(signupPage.getInputs("confirmPassword").getAttribute("type").contains("password"),
                "Elements type attribute does not contain password");
    }

    @Test(priority = 30)
    @Description("Displays errors when user already exists")
    public void displaysErrorsWhenUserAlreadyExists() {
        navPage.getNavigationLink("signup").click();
        navPage.verifyCurrentLinkContains("/signup");
        signupPage.getInputs("name").sendKeys("Another User");
        signupPage.getInputs("email").sendKeys("admin@admin.com");
        signupPage.getInputs("password").sendKeys("12345");
        signupPage.getInputs("confirmPassword").sendKeys("12345");
        signupPage.getSignUpButton().click();
        messagePopUpPage.waitProgressBarInvisible();
        messagePopUpPage.verifyStatusMessageVisible();
        Assert.assertEquals(messagePopUpPage.getStatusMessage("", "/ul/li")
                        .getText(), "E-mail already exists",
                "Message does not contain E-mail already exists");
        navPage.verifyCurrentLinkContains("/signup");
    }

    @Test(priority = 40)
    @Description("Signup")
    public void signup() {
        navPage.getNavigationLink("signup").click();
        navPage.verifyCurrentLinkContains("/signup");
        signupPage.getInputs("name").sendKeys("Nikola Prvulovic");
        signupPage.getInputs("email").sendKeys("nikolaprvulovic@itbootcamp.rs");
        signupPage.getInputs("password").sendKeys("12345");
        signupPage.getInputs("confirmPassword").sendKeys("12345");
        signupPage.getSignUpButton().click();

        navPage.getNavigationLink("home").click();
        Assert.assertEquals(messagePopUpPage.verifyDialogVisible().getText(), "IMPORTANT: Verify your account",
                "Message does not contain IMPORTANT: Verify your account");
        messagePopUpPage.getVerifyAccountCloseButton().click();
        navPage.getLogoutButton().click();
    }

}
