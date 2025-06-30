package pages;

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
    //Проверяем что на странице корзины
    public boolean isPageProducts() {
        return driver.findElement(TITLE).isDisplayed();
    }
    //Получаем кол-во кнопок remove на странице
    public List<WebElement> getRemoveButtons() {
        return driver.findElements(REMOVE_BUTTON);
    }
    //Кликаем кнопку remove по индесу для удаления конкретного товара
    public void clickRemoveFromCartByIndex(int index) {
        getRemoveButtons().get(index).click();
    }
    public boolean isCartEmpty() {
        return driver.findElements(CART_ITEMS).isEmpty();
    }
}
