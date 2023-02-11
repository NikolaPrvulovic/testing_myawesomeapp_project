package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void verifyStatusMessageVisible() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//div[@role='status']"))));
    }

    public WebElement getStatusMessage(String prefixRouteIfNeeded, String sufixRouteIfNeeded) {
        return driver.findElement(
                By.xpath(prefixRouteIfNeeded + "//div[@role='status']" + sufixRouteIfNeeded + ""));
    }

    public WebElement verifyDialogVisible() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//div[contains(@class, 'v-card__title')]"))));
        return driver.findElement(
                By.xpath("//div[contains(@class, 'v-card__title')]"));
    }

    public WebElement getVerifyAccountCloseButton() {
        return driver.findElement(By.xpath("//button[contains(@class, 'btnClose')]"));
    }

    public WebElement getDeleteRowDialogButton(int cancelDelete) {       // 1-cancel, 2-delete
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(
                By.xpath("//div[@class='v-card__actions']/button[" + cancelDelete + "]"))));
        return driver.findElement(By.xpath("//div[@class='v-card__actions']/button[" + cancelDelete + "]"));
    }

    public void waitProgressBarInvisible() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(
                By.xpath("//div[@role='progressbar']"))));
    }
}
