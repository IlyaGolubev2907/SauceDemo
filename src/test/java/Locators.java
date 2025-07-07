import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;

public class Locators {
    WebDriver driver;

    public void LocatorsTest() {
    }

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
    }

    @Test
    public void Test() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.className("form_input"));
        driver.findElement(By.tagName("form"));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.partialLinkText("Bolt T-Shirt"));
        driver.findElement(By.linkText("Sauce Labs Fleece Jacket"));
        driver.get("https://www.saucedemo.com/cart.html");
        //by.xpath
        driver.findElement(By.xpath("//button[@data-test='checkout']"));
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.xpath("//button[text()='Add to cart']"));
        driver.findElement(By.xpath("//div[contains(@class, 'inventory_item_desc')]"));
        driver.findElement(By.xpath("//img[contains(@alt, 'Sauce Labs Bike Light')]"));
        //axis
        driver.findElement(By.xpath("//select[contains(@class, 'product_sort_container')]/ancestor::div[1]"));
        driver.findElement(By.xpath("//select[@class='product_sort_container']/descendant::option"));
        driver.findElement(By.xpath("//*[@id='inventory_container']/div/div[1]/div[2]/following::*[1]"));
        driver.findElement(By.xpath("//select[@class='product_sort_container']/parent::*[1]"));
        driver.findElement(By.xpath("//select[contains(@class, 'product_sort_container')]/preceding::*[1]"));
        driver.findElement(By.xpath("//div[@class='app_logo' and text()='Swag Labs']"));
        //by.cssSelector
        driver.findElement(By.cssSelector(".product_sort_container"));
        driver.findElement(By.cssSelector(".btn.btn_primary"));
        driver.findElement(By.cssSelector(".product_sort_container option"));
        driver.findElement(By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)"));
        driver.findElement(By.cssSelector("select"));
        driver.findElement(By.cssSelector("select.product_sort_container"));
        driver.findElement(By.cssSelector("[data-test='product-sort-container']"));
        driver.findElement(By.cssSelector("[class~='product_sort_container']"));
        driver.findElement(By.cssSelector("[data-test='add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)']"));
        driver.findElement(By.cssSelector("[class^='product']"));
        driver.findElement(By.cssSelector("[class$='container']"));
        driver.findElement(By.cssSelector("[class*='sort']"));
    }

    @AfterMethod(
            alwaysRun = true
    )
    public void tearDown() {
        this.driver.quit();
    }
}
