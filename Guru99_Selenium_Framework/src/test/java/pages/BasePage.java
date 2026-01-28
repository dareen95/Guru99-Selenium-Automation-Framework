package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //  Wait for element visible
    public WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //  Wait for element clickable
    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //  Click
    public void click(By locator) {
        waitForClickable(locator).click();
    }

    // Type text
    public void type(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text
    public String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    //  Check displayed
    public boolean isDisplayed(By locator) {
        return waitForVisible(locator).isDisplayed();
    }

    //  Select dropdown by visible text
    public void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdown = waitForVisible(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    // Alert handler
    public void acceptAlertIfPresent() {
        try {
            WebDriverWait alertWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            alertWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println("⚠️ Alert: " + alert.getText());
            alert.accept();
        } catch (Exception e) {
            // no alert
        }
    }

    //  Helpful waits بعد اللوجن
    public void waitForTitleContains(String text) {
        wait.until(ExpectedConditions.titleContains(text));
    }

    public void waitForUrlContains(String text) {
        wait.until(ExpectedConditions.urlContains(text));
    }
}
