package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewAccountPage;
import pages.NewCustomerPage;

public class NewAccountTest extends BaseTest {

    @Test
    public void createNewAccountSuccessfully() {

        // 1) Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mngr123456", "password123"); // ✨ عدّليهم حسب بياناتك

        // 2) Create New Customer
        NewCustomerPage newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.openNewCustomerPage();

        String email = "dareen" + System.currentTimeMillis() + "@gmail.com";

        newCustomerPage.fillNewCustomerForm(
                "Dareen Test",
                "female",
                "1999-10-20",
                "Gaza Street",
                "Gaza",
                "PS",
                "123456",
                "0599999999",
                email,
                "1234"
        );

        newCustomerPage.clickSubmit();

        Assert.assertTrue(newCustomerPage.isCustomerCreatedSuccessfully(),
                "Customer was NOT created successfully!");

        String customerId = newCustomerPage.getCustomerId();
        System.out.println("Customer ID: " + customerId);

        // 3) Create New Account
        NewAccountPage newAccountPage = new NewAccountPage(driver);
        newAccountPage.openNewAccountPage();

        newAccountPage.fillNewAccountForm(customerId, "Savings", "5000");
        newAccountPage.clickSubmit();

        Assert.assertTrue(newAccountPage.isAccountCreatedSuccessfully(),
                "Account was NOT created successfully!");

        String accountId = newAccountPage.getAccountId();
        System.out.println("Account ID: " + accountId);
    }
}
