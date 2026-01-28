package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver initDriver() {

        ChromeOptions options = new ChromeOptions();

        // ✅ أهم سطر (مضمون)
        options.addArguments("--guest");

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("autofill.profile_enabled", false);
        prefs.put("autofill.credit_card_enabled", false);
        prefs.put("profile.autofill_profile_enabled", false);

        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
