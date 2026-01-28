package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NewCustomerPage;

public class NewCustomerTest extends BaseTest {

    @Test
    public void createNewCustomerAndGetCustomerId() {

        // 1) Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("mngr652494", "ynYpEtU");   // ✅ بياناتك الصح

        // 2) Open New Customer Page
        NewCustomerPage newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.openNewCustomerPage();

        // 3) Unique Email (عشان ما يصير Duplicate)
        String uniqueEmail = "dareen" + System.currentTimeMillis() + "@test.com";

        // 4) Fill form
        newCustomerPage.fillNewCustomerForm(
                "Dareen Test",
                "female",
                "1999-10-20",
                "Gaza Street",
                "Gaza",
                "PS",
                "123456",
                "0599999999",
                uniqueEmail,
                "1234"
        );

        // 5) Submit
        newCustomerPage.clickSubmit();

        // 6) لو ظهر Alert معناها في حقل ناقص
        newCustomerPage.acceptAlertIfPresent();

        // 7) Verify + Print Customer ID
        Assert.assertTrue(newCustomerPage.isCustomerCreatedSuccessfully(),
                "Customer was NOT created successfully!");

        String customerId = newCustomerPage.getCustomerId();
        System.out.println(" Customer ID = " + customerId);
    }
}
