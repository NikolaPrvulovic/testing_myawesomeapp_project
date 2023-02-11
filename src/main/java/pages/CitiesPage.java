package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getAdminButtonOptionFromList(String optionLink) {
        return driver.findElement(
                By.xpath("//a[@href='/admin/" + optionLink + "']"));   // cities, users
    }

    public WebElement getNewItemAndInDialogButton(String option) {
        return driver.findElement(
                By.xpath("//button[contains(@class, 'btn" + option + "')]"));
    }

    public WebElement getInputs(String idValue) {
        return driver.findElement(
                By.xpath("//input[@id='" + idValue + "']"));
    }

    public void verifyTableRowsOne() {
        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath("//tbody/tr"), 1));
    }

    public WebElement verifyTableRowNameField(int row) {
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]/td[2]"));
    }

    public WebElement getTableRowAndButton(int row, String button) {         // edit, delete
        return driver.findElement(
                By.xpath("//tbody/tr[" + row + "]//button[@id='" + button + "']"));
    }
}
