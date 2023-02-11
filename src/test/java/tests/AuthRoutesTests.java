package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {

    @Test(priority = 10)
    @Description("Forbids visits to home url if not authenticated")
    public void forbidsVisitsToHomeUrlIfNotAuthenticated() {
        navPage.getOnPage("home");
        navPage.verifyCurrentLinkContains("/login");
    }

    @Test(priority = 20)
    @Description("Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        navPage.getOnPage("profile");
        navPage.verifyCurrentLinkContains("/login");
    }

    @Test(priority = 30)
    @Description("Forbids visits to admin cities url if not authenticated")
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        navPage.getOnPage("admin/cities");
        navPage.verifyCurrentLinkContains("/login");
    }

    @Test(priority = 40)
    @Description("Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        navPage.getOnPage("admin/users");
        navPage.verifyCurrentLinkContains("/login");
    }
}
