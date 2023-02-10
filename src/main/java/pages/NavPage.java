package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage  extends BasePage{
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public WebElement getLanguageButton(){
        return driver.findElement(By.xpath("//button[contains(@class, 'btnLocale')]"));
    }
    public WebElement getEnglishLanguageLink(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='list-item-73']/span"))));
        return driver.findElement(By.xpath("//*[@id='list-item-73']/span"));
    }
    public WebElement getLoginLink(){
        return driver.findElement(By.xpath("//div[@class='v-toolbar__items']/a[@href='/login']"));
    }
    public void verifyCurrentLinkContains(String baseUrlExtension){
        wait.until(ExpectedConditions.urlContains(baseUrlExtension));
    }
}
