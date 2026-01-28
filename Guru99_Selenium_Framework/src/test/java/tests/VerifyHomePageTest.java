package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class VerifyHomePageTest extends BaseTest {

    @Test
    public void verifyManagerIdTitleAndWelcomeMessage() {

        // 1) Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("mngr652494", "ynYpEtU");

        // 2) Verify Manager ID
        Assert.assertTrue(homePage.isManagerIdDisplayed(), "Manager ID is NOT displayed!");
        System.out.println("Manager ID Text: " + homePage.getManagerIdText());

        // 3) Verify Title
        String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, "Guru99 Bank Manager HomePage", "Home page title is wrong!");
        System.out.println("Page Title: " + actualTitle);

        // 4) Verify Welcome Message
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Welcome message is NOT displayed!");
        String welcomeText = homePage.getWelcomeMessageText();
        Assert.assertTrue(welcomeText.contains("Welcome"), "Welcome message text is wrong!");
        System.out.println("Welcome Message: " + welcomeText);
    }
}
