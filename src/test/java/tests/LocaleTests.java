package tests;

import jdk.jfr.Description;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {

    @Test(priority = 10)
    @Description("TC 1: Set locale to ES")
    public void setLocaleToES() {
        navPage.getLanguageButton().click();
        navPage.getLanguageLink("ES").click();
        navPage.verifyHeaderContains("Página de aterrizaje");
    }

    @Test(priority = 10)
    @Description("TC 1: Set locale to EN")
    public void setLocaleToEN() {
        navPage.getLanguageButton().click();
        navPage.getLanguageLink("EN").click();
        navPage.verifyHeaderContains("Landing");
    }

    @Test(priority = 10)
    @Description("TC 1: Set locale to CN")
    public void setLocaleToCN() {
        navPage.getLanguageButton().click();
        navPage.getLanguageLink("CN").click();
        navPage.verifyHeaderContains("首页");
    }

    @Test(priority = 10)
    @Description("TC 1: Set locale to FR")
    public void setLocaleToFR() {
        navPage.getLanguageButton().click();
        navPage.getLanguageLink("FR").click();
        navPage.verifyHeaderContains("Page d'atterrissage");
    }
}
