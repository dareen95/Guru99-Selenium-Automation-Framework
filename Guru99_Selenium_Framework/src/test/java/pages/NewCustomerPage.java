package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage extends BasePage {

    // رابط New Customer من القائمة
    private By newCustomerLink = By.linkText("New Customer");

    // Form locators
    private By customerNameInput = By.name("name");
    private By genderMaleRadio = By.cssSelector("input[value='m']");
    private By genderFemaleRadio = By.cssSelector("input[value='f']");
    private By dobInput = By.id("dob");
    private By addressTextarea = By.name("addr");
    private By cityInput = By.name("city");
    private By stateInput = By.name("state");
    private By pinInput = By.name("pinno");
    private By mobileInput = By.name("telephoneno");
    private By emailInput = By.name("emailid");
    private By passwordInput = By.name("password");
    private By submitBtn = By.name("sub");

    // Success page locators
    private By successMessage = By.xpath("//p[contains(text(),'Customer Registered Successfully')]");
    private By customerIdValue = By.xpath("//td[text()='Customer ID']/following-sibling::td");

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    // فتح صفحة New Customer
    public void openNewCustomerPage() {
        click(newCustomerLink);
    }

    // ====== Actions ======

    public void enterCustomerName(String name) {
        type(customerNameInput, name);
    }

    public void selectGender(String gender) {
        if (gender == null) return;

        if (gender.equalsIgnoreCase("male")) {
            click(genderMaleRadio);
        } else {
            click(genderFemaleRadio);
        }
    }

    public void enterDOB(String dob) {
        // مثال: 1999-01-01
        type(dobInput, dob);
    }

    public void enterAddress(String address) {
        type(addressTextarea, address);
    }

    public void enterCity(String city) {
        type(cityInput, city);
    }

    public void enterState(String state) {
        type(stateInput, state);
    }

    public void enterPin(String pin) {
        type(pinInput, pin);
    }

    public void enterMobile(String mobile) {
        type(mobileInput, mobile);
    }

    public void enterEmail(String email) {
        type(emailInput, email);
    }

    public void enterPassword(String password) {
        type(passwordInput, password);
    }

    public void clickSubmit() {
        click(submitBtn);
    }

    //  ميثود جاهزة تعبي الفورم كله
    public void fillNewCustomerForm(
            String name, String gender, String dobValue,
            String addressValue, String cityValue, String stateValue,
            String pinValue, String mobileValue, String emailValue,
            String passwordValue
    ) {
        enterCustomerName(name);
        selectGender(gender);
        enterDOB(dobValue);
        enterAddress(addressValue);
        enterCity(cityValue);
        enterState(stateValue);
        enterPin(pinValue);
        enterMobile(mobileValue);
        enterEmail(emailValue);
        enterPassword(passwordValue);
    }


    // ====== Validations ======

    public boolean isCustomerCreatedSuccessfully() {
        return isDisplayed(successMessage);
    }

    public String getCustomerId() {
        return getText(customerIdValue);
    }

    //  هذه هي الميثود التي يطلبها التيست (FullCycleTes
    public String createNewCustomerAndGetCustomerId() {
        // 1. توليد إيميل عشوائي لتجنب خطأ "Email already exists"
        String randomEmail = "test" + System.currentTimeMillis() + "@gmail.com";

        // 2. تعبئة البيانات باستخدام الميثودز الموجودة في الكلاس
        fillNewCustomerForm(
                "Gemini User", "male", "01011990",
                "123 Automation St", "Cairo", "Egypt",
                "123456", "0123456789", randomEmail, "Password123"
        );

        // 3. الضغط على Submit
        clickSubmit();

        // 4. جلب رقم العميل وإرجاعه للتيست
        return getCustomerId();
    }


}
