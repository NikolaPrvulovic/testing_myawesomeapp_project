package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTests extends BaseTest {

    @Test(priority = 10)
    @Description("TC 1: Visits the profile page")
    public void visitsTheProfilePage() {
        navPage.getNavigationLink("login").click();
        loginPage.getInputs("email").sendKeys("admin@admin.com");
        loginPage.getInputs("password").sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getNavigationLink("profile").click();
        navPage.verifyCurrentLinkContains("/profile");
        Assert.assertTrue(profilePage.getInputs("email").getAttribute("value")
                .contains("admin@admin.com"), "Attribute value does not contain admin@admin.com");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 20)
    @Description("TC 2: Checks input types")
    public void checksInputTypes() {
        navPage.getNavigationLink("login").click();
        loginPage.getInputs("email").sendKeys("admin@admin.com");
        loginPage.getInputs("password").sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getNavigationLink("profile").click();
        Assert.assertEquals(profilePage.getInputs("email").getAttribute("type"), "email"
                , "Attribute type does not contain email");
//        Assert.assertTrue(profilePage.getInputs("email").getAttribute("disabled").contains("disabled") // returns NULL
//                , "Attribute disabled does not contain disabled");
        Assert.assertEquals(profilePage.getInputs("name").getAttribute("type"), "text"
                , "Attribute type does not contain email");
        Assert.assertEquals(profilePage.getInputs("city").getAttribute("type"), "text"
                , "Attribute type does not contain email");
        Assert.assertEquals(profilePage.getInputs("country").getAttribute("type"), "text"
                , "Attribute type does not contain email");
        Assert.assertEquals(profilePage.getInputs("urlTwitter").getAttribute("type"), "url"
                , "Attribute type does not contain email");
        Assert.assertEquals(profilePage.getInputs("urlGitHub").getAttribute("type"), "url"
                , "Attribute type does not contain email");
        Assert.assertEquals(profilePage.getInputs("phone").getAttribute("type"), "tel"
                , "Attribute type does not contain email");
        navPage.getLogoutButton().click();
    }

    @Test(priority = 30)
    @Description("TC 3: Edits profile")
    public void editsProfile() throws InterruptedException {
        navPage.getNavigationLink("login").click();
        loginPage.getInputs("email").sendKeys("admin@admin.com");
        loginPage.getInputs("password").sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getNavigationLink("profile").click();

        messagePopUpPage.waitProgressBarInvisible();

        profilePage.getInputs("name").sendKeys(Keys.CONTROL + "a");
        profilePage.getInputs("name").sendKeys(Keys.BACK_SPACE);
        profilePage.waitInputEmpty("name");
        profilePage.getInputs("name").sendKeys("Tester");

        profilePage.getInputs("city").sendKeys(Keys.CONTROL + "a");
        profilePage.getInputs("city").sendKeys(Keys.BACK_SPACE);
        profilePage.waitInputEmpty("city");
        profilePage.getInputs("city").sendKeys("Bucaramanga");
        profilePage.getCityAppender().click();

        profilePage.getInputs("phone").sendKeys(Keys.CONTROL + "a");
        profilePage.getInputs("phone").sendKeys(Keys.BACK_SPACE);
        profilePage.waitInputEmpty("phone");
        profilePage.getInputs("phone").sendKeys("+3816283223");

        profilePage.getInputs("country").sendKeys(Keys.CONTROL + "a");
        profilePage.getInputs("country").sendKeys(Keys.BACK_SPACE);
        profilePage.waitInputEmpty("country");
        profilePage.getInputs("country").sendKeys("Spain");

        profilePage.getInputs("urlTwitter").sendKeys(Keys.CONTROL + "a");
        profilePage.getInputs("urlTwitter").sendKeys(Keys.BACK_SPACE);
        profilePage.waitInputEmpty("urlTwitter");
        profilePage.getInputs("urlTwitter").sendKeys("https://twitter.com/profile/milan1232");

        profilePage.getInputs("urlGitHub").sendKeys(Keys.CONTROL + "a");
        profilePage.getInputs("urlGitHub").sendKeys(Keys.BACK_SPACE);
        profilePage.waitInputEmpty("urlGitHub");
        profilePage.getInputs("urlGitHub").sendKeys("https://github.com/NikolaPrvulovic");

        profilePage.getSaveButton().click();
        messagePopUpPage.waitProgressBarInvisible();
        profilePage.waitSaveButton();
        Assert.assertTrue(messagePopUpPage
                        .getStatusMessage("//div[@class='container'][not(contains(@style, 'display: none;'))]",
                                "/..").getText().contains("Profile saved successfuly"),
                "Message does not contain Deleted successfully Profile saved successfuly");

        Assert.assertTrue(profilePage.getInputs("name").getAttribute("value").contains("Tester"),
                "Name input does not contain Tester");
        Assert.assertTrue(profilePage.getInputs("city").getAttribute("value").contains("Bucaramanga"),
                "City input does not contain Bucaramanga");
        Assert.assertTrue(profilePage.getInputs("phone").getAttribute("value").contains("+3816283223"),
                "Phone input does not contain +3816283223");
        Assert.assertTrue(profilePage.getInputs("country").getAttribute("value").contains("Spain"),
                "Country input does not contain Spain");
        Assert.assertTrue(profilePage.getInputs("urlTwitter").getAttribute("value")
                        .contains("https://twitter.com/profile/milan1232"),
                "Twitter Url input does not contain https://twitter.com/profile/milan1232");
        Assert.assertTrue(profilePage.getInputs("urlGitHub").getAttribute("value")
                        .contains("https://github.com/nikolaprvulovic"),
                "GitHub Url input does not contain https://github.com/NikolaPrvulovic");
        navPage.getLogoutButton().click();
    }
}
