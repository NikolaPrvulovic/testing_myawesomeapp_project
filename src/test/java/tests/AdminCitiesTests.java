package tests;

import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest{

    @Test(priority = 10)
    @Description("TC 1: Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
        navPage.getNavigationLink("login").click();
        loginPage.getInputs("email").sendKeys("admin@admin.com");
        loginPage.getInputs("password").sendKeys("12345");
        loginPage.getLoginButton().click();
        navPage.getAdminButton().click();
        citiesPage.getAdminButtonOptionFromList("cities").click();      // cities, users
        navPage.verifyCurrentLinkContains("/admin/cities");
    }
    @Test(priority = 20)
    @Description("TC 2: Checks input types for create/edit new city")
    public void checksInputTypesForCreateEditNewCity(){
        navPage.getAdminButton().click();
        citiesPage.getAdminButtonOptionFromList("cities").click();
        citiesPage.getNewItemAndInDialogButton("NewItem").click();        // NewItem, Save (case sensitive)
        messagePopUpPage.verifyDialogVisible();
        Assert.assertEquals(citiesPage.getInputs("name").getAttribute("type"), "text",
                "Elements type attribute does not contain text");
    }
    @Test(priority = 30)
    @Description("TC 3: Create New City")
    public void createNew(){
        navPage.getAdminButton().click();
        citiesPage.getAdminButtonOptionFromList("cities").click();
        citiesPage.getNewItemAndInDialogButton("NewItem").click();
        messagePopUpPage.verifyDialogVisible();
        citiesPage.getInputs("name").sendKeys("Test's city");
        citiesPage.getNewItemAndInDialogButton("Save").click();        // NewItem, Save (case sensitive)
        Assert.assertTrue(messagePopUpPage
                        .getStatusMessage("//div[@class='container'][not(contains(@style, 'display: none;'))]"
                                ,"/..")
                        .getText().contains("Saved successfully"),
                "Message does not contain Saved successfully");
    }
    @Test(priority = 40)
    @Description("TC 4: Edit city")
    public void editCity(){
        navPage.getAdminButton().click();
        citiesPage.getAdminButtonOptionFromList("cities").click();
        citiesPage.getInputs("search").sendKeys("Test's city");
        citiesPage.verifyTableRowsOne();
        citiesPage.getTableRowAndButton(1, "edit").click();     // edit, delete
        citiesPage.getInputs("name").sendKeys(Keys.CONTROL + "a");
        citiesPage.getInputs("name").sendKeys(Keys.BACK_SPACE);
        citiesPage.getInputs("name").sendKeys("Test's city Edited");
        citiesPage.getNewItemAndInDialogButton("Save").click();        // NewItem, Save (case sensitive)
        Assert.assertTrue(messagePopUpPage
                        .getStatusMessage("//div[@class='container'][not(contains(@style, 'display: none;'))]"
                                , "/..")
                        .getText().contains("Saved successfully"),
                "Message does not contain Saved successfully");
    }
    @Test(priority = 50)
    @Description("TC 5: Search city")
    public void searchCity(){
        navPage.getAdminButton().click();
        citiesPage.getAdminButtonOptionFromList("cities").click();
        citiesPage.getInputs("search").sendKeys("Test's city");
        citiesPage.verifyTableRowsOne();
        Assert.assertTrue(citiesPage.verifyTableRowNameField(1).getText().contains("Test's city")
                , "Name field does not contain Test's city");
    }
    @Test(priority = 60)
    @Description("TC 6: Delete city")
    public void deleteCity(){
        navPage.getAdminButton().click();
        citiesPage.getAdminButtonOptionFromList("cities").click();
        citiesPage.getInputs("search").sendKeys("Test's city");
        citiesPage.verifyTableRowsOne();
        Assert.assertTrue(citiesPage.verifyTableRowNameField(1).getText().contains("Test's city")
                , "Name field does not contain Test's city");
        citiesPage.getTableRowAndButton(1, "delete").click();
        messagePopUpPage.getDeleteRowDialogButton(2).click();       // 1-cancel, 2-delete
        Assert.assertTrue(messagePopUpPage
                        .getStatusMessage("//div[@class='container'][not(contains(@style, 'display: none;'))]"
                                , "/..")
                        .getText().contains("Deleted successfully"),
                "Message does not contain Deleted successfully");
    }
}
