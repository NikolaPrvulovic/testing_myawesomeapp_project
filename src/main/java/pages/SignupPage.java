package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputs(String idValue) {
        return driver.findElement(
                By.xpath("//input[@id='" + idValue + "']"));
    }

    public WebElement getSignUpButton() {
        return driver.findElement(
                By.xpath("//button[@type='submit']"));
    }
}
