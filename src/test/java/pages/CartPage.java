package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {

    private final By CART_TITLE = By.xpath("//span[@class='title' and text()='Your Cart']");
    private final By REMOVE_BUTTON = By.className("cart_button");
    private final By CART_ITEM = By.className("cart_item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка открытия страницы корзины")
    public CartPage verifyPageOpened() {
        Assert.assertTrue(driver.findElement(CART_TITLE).isDisplayed(),
                "Страница корзины не открыта");
        return this;
    }

    @Step("Проверка что корзина не пустая")
    public CartPage verifyCartNotEmpty() {
        List<WebElement> items = driver.findElements(CART_ITEM);
        Assert.assertFalse(items.isEmpty(), "Корзина пустая, но не должна быть");
        return this;
    }

    @Step("Проверка что корзина пустая")
    public CartPage verifyCartEmpty() {
        List<WebElement> items = driver.findElements(CART_ITEM);
        Assert.assertTrue(items.isEmpty(), "Корзина не пустая, но должна быть");
        return this;
    }

    @Step("Удаление товара из корзины по индексу {index}")
    public CartPage removeItemByIndex(int index) {
        List<WebElement> removeButtons = driver.findElements(REMOVE_BUTTON);
        removeButtons.get(index).click();
        return this;
    }

    // Старый метод (оставлен для совместимости)
    @Deprecated
    public boolean isCartEmpty() {
        return driver.findElements(CART_ITEM).isEmpty();
    }
}