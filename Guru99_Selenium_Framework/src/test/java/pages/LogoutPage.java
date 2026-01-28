package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogoutPage extends BasePage {

    private By logoutLink = By.linkText("Log out");

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickLogout() {
        click(logoutLink);
    }

    public void acceptLogoutAlertIfPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            // no alert
        }
    }
}
