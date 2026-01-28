package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    private By userIdInput = By.name("uid");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String userId, String password) {
        // كتابة البيانات والضغط على الزر
        type(userIdInput, userId.trim());
        type(passwordInput, password.trim());
        click(loginButton);

        try {
            // ننتظر Alert لثانية واحدة فقط في حال فشل الدخول
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(1));
            shortWait.until(ExpectedConditions.alertIsPresent());

            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            throw new RuntimeException("❌ فشل تسجيل الدخول: " + alertText);

        } catch (org.openqa.selenium.TimeoutException e) {
            // إذا لم يظهر Alert، فهذا يعني أن الدخول ناجح
            System.out.println("✅ تم تسجيل الدخول، جاري تحميل الصفحة الرئيسية...");
        }

        return new HomePage(driver);
    }
}