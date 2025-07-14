package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage {

    private final By TITLE = By.xpath("//span[contains(@class, 'title') and contains(text(), 'Products')]");
    private final By ADD_ITEM = By.className("btn_primary");
    private final By REMOVE_ITEM = By.className("btn_secondary");
    private final By CART_BUTTON = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Открытие страницы каталога")
    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    @Step("Проверяем, что находимся на станице каталога")
    public boolean isPageProducts() {
        return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Получение списка товаров из каталога")
    public List<WebElement> getItems() {
        return driver.findElements(ADD_ITEM);
    }

    @Step("Получение количества добавленных товаров")
    public List<WebElement> getRemoveButtons() {
        return driver.findElements(REMOVE_ITEM);
    }

    @Step("Добавление товара в корзину")
    public void clickAddToCartByIndex(int index) {
        getItems().get(index).click();
    }

    @Step("Проверяем, что отображается кнопка remove, после добавление товара в корзину")
    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(REMOVE_ITEM).isDisplayed();
    }

    @Step("Нажатие на кнопку remove")
    public void clickRemoveFromCartByIndex(int index) {
        getRemoveButtons().get(index).click();
    }

    @Step("Проверяем, что отображается кнопка корзины")
    public boolean isCartButtonDisplayed() {
        return driver.findElement(CART_BUTTON).isDisplayed();
    }
    @Step("Нажатие на кнопку корзины")
    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }
}
