package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(priority = 1, description = "Проверка, что в корзине есть товары",
            testName = "Проверка наличия товаров в корзине", groups = {"Smoke"})
    @Severity(SeverityLevel.CRITICAL)
    @Story("Работа с корзиной")
    public void cartIsNotEmptyTest() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin()
                .addItemToCart(0)
                .addItemToCart(2)
                .clickCartButton()
                .verifyPageOpened()
                .verifyCartNotEmpty();
    }

    @Test(priority = 2, description = "Проверка удаления товара из корзины",
            testName = "Удаление товара из корзины", groups = {"Smoke"})
    @Severity(SeverityLevel.NORMAL)
    @Story("Управление корзиной")
    public void removeFromCartTest() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin()
                .addItemToCart(0)
                .addItemToCart(2)
                .clickCartButton()
                .verifyPageOpened()
                .removeItemByIndex(0)
                .removeItemByIndex(0)
                .verifyCartEmpty();
    }

    @Test(priority = 3, description = "Проверка, что в корзине нет товаров",
            testName = "Проверка отсутствия товаров в корзине", groups = {"Smoke"})
    @Severity(SeverityLevel.MINOR)
    @Story("Негативные сценарии")
    public void cartIsEmptyTest() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin()
                .verifyPageOpened()
                .clickCartButton()
                .verifyPageOpened()
                .verifyCartEmpty(); // Этот тест будет падать (как и задумано)
    }
}
