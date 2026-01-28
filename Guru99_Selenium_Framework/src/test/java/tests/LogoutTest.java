package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutShouldReturnToLoginPage() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("mngr652494", "ynYpEtU");

        Assert.assertTrue(homePage.isManagerIdDisplayed(), "Login Failed!");

        // Logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.clickLogout();
        logoutPage.acceptLogoutAlertIfPresent();


        // Verify رجعنا لصفحة اللوجن
        Assert.assertTrue(driver.getCurrentUrl().contains("V4"),
                "Not redirected to login page after logout!");
    }
}
