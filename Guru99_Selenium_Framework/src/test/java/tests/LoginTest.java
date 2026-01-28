package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mngr652494", "ynYpEtU");

        HomePage homePage = new HomePage(driver);

        Assert.assertTrue(homePage.getManagerText().contains("Manger Id"),
                "Login failed or Manager Id not displayed!");
    }
}
