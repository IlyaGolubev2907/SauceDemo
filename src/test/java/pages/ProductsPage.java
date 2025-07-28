package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage extends LoadablePage {
    private final By TITLE = By.xpath("//span[text()='Products']");
    private final By CART_BUTTON = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    @Step("Добавление товара в корзину")
    public ProductsPage addToCart(String productName) {
        By itemButton = By.xpath(String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button", productName));
        driver.findElement(itemButton).click();
        return this;
    }

    @Step("Переход в корзину")
    public CartPage goToCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}
