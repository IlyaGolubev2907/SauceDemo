package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static tests.AllureUtils.takeScreenshot;

public class ProductsPage extends BasePage {

    private final By TITLE = By.xpath("//span[contains(@class, 'title') and contains(text(), 'Products')]");
    private final By ADD_ITEM = By.className("btn_primary");
    private final By REMOVE_ITEM = By.className("btn_secondary");
    private final By CART_BUTTON = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы каталога")
    public ProductsPage open() {
        driver.get(BASE_URL + "inventory.html");
        takeScreenshot(driver, "Страница каталога открыта");
        return this;
    }

    @Step("Проверка отображения страницы каталога")
    public ProductsPage verifyPageOpened() {
        Assert.assertTrue(driver.findElement(TITLE).isDisplayed(), "Страница каталога не открыта");
        takeScreenshot(driver, "Страница каталога отображена");
        return this;
    }

    @Step("Добавление товара в корзину по индексу {index}")
    public ProductsPage addItemToCart(int index) {
        getItems().get(index).click();
        takeScreenshot(driver, "Товар добавлен в корзину");
        return this;
    }

    @Step("Удаление товара из корзины по индексу {index}")
    public ProductsPage removeItemFromCart(int index) {
        getRemoveButtons().get(index).click();
        takeScreenshot(driver, "Товар удален из корзины");
        return this;
    }

    @Step("Проверка отображения кнопки Remove")
    public ProductsPage verifyRemoveButtonDisplayed() {
        Assert.assertTrue(driver.findElement(REMOVE_ITEM).isDisplayed(),
                "Кнопка Remove не отображается");
        return this;
    }

    @Step("Нажатие на кнопку корзины")
    public CartPage clickCartButton() {
        driver.findElement(CART_BUTTON).click();
        takeScreenshot(driver, "Переход в корзину");
        return new CartPage(driver);
    }

    @Step("Проверка отображения иконки корзины")
    public ProductsPage verifyCartIconDisplayed() {
        Assert.assertTrue(driver.findElement(CART_BUTTON).isDisplayed(),
                "Иконка корзины не отображается");
        return this;
    }

    // Вспомогательные методы (не для цепочки)
    private List<WebElement> getItems() {
        return driver.findElements(ADD_ITEM);
    }

    private List<WebElement> getRemoveButtons() {
        return driver.findElements(REMOVE_ITEM);
    }
}
