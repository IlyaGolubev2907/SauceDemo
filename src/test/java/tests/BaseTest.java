package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;
import java.util.HashMap;

@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    SoftAssert softAssert;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

@Parameters({"browser"})
@BeforeMethod (alwaysRun = true)
public void setup(@Optional("chrome") String browser) {
    ChromeOptions options = new ChromeOptions();
    HashMap<String, Object> chromePrefs = new HashMap<>();
    chromePrefs.put("credentials_enable_service", false);
    chromePrefs.put("profile.password_manager_enabled", false);
    options.setExperimentalOption("prefs", chromePrefs);
    options.addArguments("--incognito");
    options.addArguments("--disable-notifications");
    options.addArguments("--disable-popup-blocking");
    options.addArguments("--disable-infobars");
    if (browser.equalsIgnoreCase("chrome")) {
        driver = new ChromeDriver(options);
    } else if (browser.equalsIgnoreCase("firefox")) {
        driver = new FirefoxDriver();
    }

    softAssert = new SoftAssert();

    loginPage = new LoginPage(driver);
    productsPage = new ProductsPage(driver);
    cartPage = new CartPage(driver);
}
@AfterMethod(alwaysRun = true)
public void tearDown() {
    driver.quit();
    }
}
