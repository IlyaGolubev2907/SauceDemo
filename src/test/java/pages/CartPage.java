package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    private final By TITLE = By.xpath("//span[contains(@class, 'title') and contains(text(), 'Your Cart')]");
    private final By REMOVE_BUTTON = By.className("btn_secondary");
    private final By CART_ITEMS = By.cssSelector("div.cart_item[data-test='inventory-item']");


    public CartPage(WebDriver driver) {
        super(driver);
    }
    @Step("Проверяем, что находимся на станице корзины")
    public boolean isPageCart() {
        return driver.findElement(TITLE).isDisplayed();
    }
    @Step("Получение кнопок remove на странице")
    public List<WebElement> getRemoveButtons() {
        return driver.findElements(REMOVE_BUTTON);
    }
    @Step("Удаление товара из корзины")
    public void clickRemoveFromCartByIndex(int index) {
        getRemoveButtons().get(index).click();
    }
    @Step("Проверяем, что корзина пустая")
    public boolean isCartEmpty() {
        return driver.findElements(CART_ITEMS).isEmpty();
    }
}
