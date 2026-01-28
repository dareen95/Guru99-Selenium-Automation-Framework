package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By managerIdText = By.xpath("//td[contains(text(),'Manger Id')]");
    private By welcomeMessage = By.xpath("//marquee[@class='heading3']");

    //  Menu links
    private By newCustomerLink = By.linkText("New Customer");
    private By newAccountLink = By.linkText("New Account");
    private By logoutLink = By.linkText("Log out");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isManagerIdDisplayed() {
        return waitForVisible(managerIdText).isDisplayed();
    }

    public String getManagerIdText() {
        return waitForVisible(managerIdText).getText();
    }

    public boolean isWelcomeMessageDisplayed() {
        return waitForVisible(welcomeMessage).isDisplayed();
    }

    public String getWelcomeMessageText() {
        return waitForVisible(welcomeMessage).getText();
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    // Alias
    public String getManagerText() {
        return getManagerIdText();
    }

    // ==========================
    //  Navigation Methods
    // ==========================

    public NewCustomerPage openNewCustomerPage() {
        click(newCustomerLink);
        return new NewCustomerPage(driver);
    }

    public NewAccountPage openNewAccountPage() {
        click(newAccountLink);
        return new NewAccountPage(driver);
    }

    public LogoutPage openLogoutPage() {
        click(logoutLink);
        return new LogoutPage(driver);
    }
}
