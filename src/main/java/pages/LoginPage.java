package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputs(String idValue) {
        return driver.findElement(
                By.xpath("//input[@id='" + idValue + "']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(
                By.xpath("//button[@type='submit']"));
    }

    public void verifyLogoutButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//button[contains(@class, 'Logout')]"))));
    }

    public WebElement getLogoutButton() {
        return driver.findElement(
                By.xpath("//button[contains(@class, 'Logout')]"));
    }
}
