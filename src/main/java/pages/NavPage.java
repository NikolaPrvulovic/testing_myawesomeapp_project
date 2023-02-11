package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getLanguageButton() {
        return driver.findElement(
                By.xpath("//button[contains(@class, 'btnLocale')]"));
    }

    public WebElement getLanguageLink(String language) {              // EN, ES, FR, CN, UA
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//div[contains(@id,'list-item')]//div[contains(text(),'" + language + "')]"))));
        return driver.findElement(
                By.xpath("//div[contains(@id,'list-item')]//div[contains(text(),'" + language + "')]/.."));
    }

    public WebElement getNavigationLink(String wantedPage) {           // login, signup, about, home
        return driver.findElement(                                    // can not get logout, admin button with this!
                By.xpath("//div[@class='v-toolbar__items']/a[@href='/" + wantedPage + "']"));
    }

    public void verifyCurrentLinkContains(String baseUrlExtension) {
        wait.until(ExpectedConditions.urlContains(baseUrlExtension));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
    }

    public WebElement getAdminButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnAdmin')]"));
    }

    public void getOnPage(String page) {
        driver.navigate().to("https://vue-demo.daniel-avellaneda.com/" + page);
    }

    public void verifyHeaderContains(String headerText) {
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(
                By.xpath("//div[contains(@class,'main')]//h1")), headerText));
    }
}
