package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    @Test(priority = 1, description = "Проверка добавления товара в корзину",
            testName = "Добавление товара в корзину", groups = {"Smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("Добавление товаров в корзину")
    public void addToCartTest() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin()
                .verifyPageOpened()
                .addItemToCart(0)
                .addItemToCart(2)
                .verifyRemoveButtonDisplayed();
    }

    @Test(priority = 2, description = "Проверка удаления товара из корзины",
            testName = "Удаление товара из корзины", groups = {"Smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Story("Управление корзиной")
    public void removeFromCartTest() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin()
                .verifyPageOpened()
                .addItemToCart(0)
                .addItemToCart(2)
                .verifyRemoveButtonDisplayed()
                .removeItemFromCart(0)
                .removeItemFromCart(0);
    }

    @Test(priority = 3, description = "Проверка нажатия на кнопку корзины",
            testName = "Нажатие на кнопку корзины", groups = {"Smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("Переход в корзину")
    public void cartButtonClickTest() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin()
                .verifyPageOpened()
                .addItemToCart(0)
                .addItemToCart(2)
                .verifyCartIconDisplayed()
                .clickCartButton(); // Возвращает CartPage (если у вас есть)
    }
}