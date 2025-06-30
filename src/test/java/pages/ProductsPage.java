package pages;

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

    public void open() {
        driver.get(BASE_URL + "inventory.html");
    }

    //Проверка что открыта страница каталога
    public boolean isPageProducts() {
        return driver.findElement(TITLE).isDisplayed();
    }

    //Получение списка товаров
    public List<WebElement> getItems() {
        return driver.findElements(ADD_ITEM);
    }

    //Получение кнопок remove
    public List<WebElement> getRemoveButtons() {
        return driver.findElements(REMOVE_ITEM);
    }

    //Нажатие add to cart по индексу товара
    public void clickAddToCartByIndex(int index) {
        getItems().get(index).click();
    }

    //Проверка что после нажатия add to cart кнопка меняется на remove
    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(REMOVE_ITEM).isDisplayed();
    }

    //Клик по кнопке remove
    public void clickRemoveFromCartByIndex(int index) {
        getRemoveButtons().get(index).click();
    }

    //Отображение кнопки корзины
    public boolean isCartButtonDisplayed() {
        return driver.findElement(CART_BUTTON).isDisplayed();
    }
    //Клик по иконке корзины
    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }
}
