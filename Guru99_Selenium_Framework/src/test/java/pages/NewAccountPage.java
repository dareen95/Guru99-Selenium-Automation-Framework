package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewAccountPage extends BasePage {

    // Menu
    private By newAccountLink = By.linkText("New Account");

    // Form Fields
    private By customerIdInput = By.name("cusid");
    private By accountTypeSelect = By.name("selaccount");
    private By initialDepositInput = By.name("inideposit");
    private By submitBtn = By.name("button2");

    // Success Message
    private By successMessage = By.xpath("//p[contains(text(),'Account Generated Successfully')]");
    private By accountIdValue = By.xpath("//td[text()='Account ID']/following-sibling::td");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void openNewAccountPage() {
        click(newAccountLink);
    }

    public void enterCustomerId(String customerId) {
        type(customerIdInput, customerId);
    }

    public void selectAccountType(String type) {
        selectByVisibleText(accountTypeSelect, type);
    }

    public void enterInitialDeposit(String amount) {
        type(initialDepositInput, amount);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    public void fillNewAccountForm(String customerId, String accountType, String deposit) {
        enterCustomerId(customerId);
        selectAccountType(accountType);
        enterInitialDeposit(deposit);
    }

    public boolean isAccountCreatedSuccessfully() {
        return waitForVisible(successMessage).isDisplayed();
    }

    public String getAccountId() {
        return waitForVisible(accountIdValue).getText();
    }
    //  الميثود التي يطلبها التيست لربط العمليات ببعضها
    public String createNewAccountAndGetAccountId(String customerId) {
        // 1. تعبئة الفورم باستخدام الميثودز الموجودة في الكلاس
        // اخترنا نوع الحساب "Savings" ومبلغ "1000" كمثال
        fillNewAccountForm(customerId, "Savings", "1000");

        // 2. الضغط على زر الإرسال
        clickSubmit();

        // 3. جلب رقم الحساب الجديد وإرجاعه للتيست
        return getAccountId();
    }
}
