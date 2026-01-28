package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FullCycleTest extends BaseTest {

    @Test
    public void fullCycle() {

        // 1) Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = loginPage.login("mngr652494", "ynYpEtU");

        // لو ظهر Alert معناها login غلط
        homePage.acceptAlertIfPresent();

        Assert.assertTrue(homePage.isManagerIdDisplayed(), "❌ Login failed!");
        System.out.println("✅ Login success");

        // 2) New Customer
        NewCustomerPage newCustomerPage = homePage.openNewCustomerPage();

        String customerId = newCustomerPage.createNewCustomerAndGetCustomerId();
        Assert.assertNotNull(customerId, "❌ Failed to get Customer ID!");
        System.out.println("✅ Customer ID = " + customerId);

        // 3) New Account
        NewAccountPage newAccountPage = homePage.openNewAccountPage();

        String accountId = newAccountPage.createNewAccountAndGetAccountId(customerId);
        Assert.assertNotNull(accountId, "❌ Failed to get Account ID!");
        System.out.println("✅ Account ID = " + accountId);

        // 4) Logout
        LogoutPage logoutPage = homePage.openLogoutPage();
        logoutPage.acceptLogoutAlertIfPresent();

        System.out.println("✅ Full cycle completed successfully!");
    }
}
