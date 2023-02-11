package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getInputs(String elementID) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//input[@id='" + elementID + "']"))));
        return driver.findElement(
                By.xpath("//input[@id='" + elementID + "']"));
    }

    public void waitInputEmpty(String elementID) {
        wait.until(ExpectedConditions.attributeToBe(getInputs(elementID), "value", ""));
    }

    public WebElement getSaveButton() {
        return driver.findElement(
                By.xpath("//button[@type='submit']"));
    }

    public void waitSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//button[@type='submit']"))));
    }

    public WebElement getCityAppender() {
        return driver.findElement(
                By.xpath("//div[@class='v-select__slot']/div[contains(@class,'v-input__append-inner')][2]"));
    }


}
